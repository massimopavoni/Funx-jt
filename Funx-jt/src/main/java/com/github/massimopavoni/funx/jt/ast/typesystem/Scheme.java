package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.*;
import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.Variable.ZERO;

public final class Scheme implements Types<Scheme> {
    public static final Scheme BOOLEAN_UNARY = new Scheme(Collections.emptySet(),
            arrowOf(BOOLEAN_TYPE, BOOLEAN_TYPE));
    public static final Scheme ARITHMETIC_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(INTEGER_TYPE, INTEGER_TYPE, INTEGER_TYPE));
    public static final Scheme COMPARISON_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(INTEGER_TYPE, INTEGER_TYPE, BOOLEAN_TYPE));
    public static final Scheme EQUALITY_BINARY = new Scheme(Set.of(ZERO.id),
            arrowOf(ZERO, ZERO, BOOLEAN_TYPE));
    public static final Scheme BOOLEAN_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(BOOLEAN_TYPE, BOOLEAN_TYPE, BOOLEAN_TYPE));

    public final Set<Long> variables;
    public final Type type;
    public final Set<Long> orderedVariables;
    private final Set<Long> freeVariables;

    public Scheme(Set<Long> variables, Type type) {
        this.variables = variables;
        orderedVariables = variables.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        this.type = type;
        freeVariables = Sets.difference(type.freeVariables(), variables);
    }

    public Utils.Pair<Substitution, Type> instantiate() {
        Substitution instantiation = new Substitution(variables.stream()
                .collect(ImmutableMap.toImmutableMap(v -> v, v -> InferenceEngine.newTypeVariable())));
        return new Utils.Pair<>(instantiation, type.applySubstitution(instantiation));
    }

    @Override
    public Set<Long> freeVariables() {
        return freeVariables;
    }

    @Override
    public Scheme applySubstitution(Substitution substitution) {
        return new Scheme(variables, type.applySubstitution(substitution.exclude(variables)));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Scheme other))
            return false;
        return variables.equals(other.variables) && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return 31 * variables.hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s%s",
                variables.isEmpty() ? "" : "forall " + orderedVariables.stream()
                        .map(InferenceEngine.fancyTypes() ? Variable::toFancyString : Variable::toString)
                        .collect(Collectors.joining(" ")) + ". ",
                type);
    }
}
