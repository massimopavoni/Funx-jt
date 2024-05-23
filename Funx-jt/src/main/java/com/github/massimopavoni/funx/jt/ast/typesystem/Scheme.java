package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;
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
    private final Set<Long> freeVariables;

    public Scheme(Set<Long> variables, Type type) {
        this.variables = variables;
        this.type = type;
        freeVariables = Sets.difference(type.freeVariables(), variables);
    }

    public Type instantiate() {
        return type.applySubstitution(new Substitution(variables.stream()
                .collect(ImmutableMap.toImmutableMap(v -> v, v -> InferenceEngine.newTypeVariable()))));
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
    public String toString() {
        if (variables.isEmpty())
            return type.toString();
        return String.format("forall %s. %s",
                variables.stream()
                        .map(v -> "t" + v)
                        .collect(Collectors.joining(" ")),
                type);
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
}
