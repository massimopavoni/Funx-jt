package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.*;
import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.Variable.ZERO;

/**
 * Type scheme class, making a monomorphic type a polymorphic one.
 */
public final class Scheme implements Types<Scheme> {
    /**
     * Predefined scheme for Prelude arithmetic binary functions.
     */
    public static final Scheme ARITHMETIC_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(INTEGER_TYPE, INTEGER_TYPE, INTEGER_TYPE));
    /**
     * Predefined scheme for Prelude comparison binary functions.
     */
    public static final Scheme COMPARISON_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(INTEGER_TYPE, INTEGER_TYPE, BOOLEAN_TYPE));
    /**
     * Predefined scheme for Prelude equality binary functions.
     */
    public static final Scheme EQUALITY_BINARY = new Scheme(Set.of(ZERO.id),
            arrowOf(ZERO, ZERO, BOOLEAN_TYPE));
    /**
     * Predefined scheme for Prelude boolean unary functions.
     */
    public static final Scheme BOOLEAN_UNARY = new Scheme(Collections.emptySet(),
            arrowOf(BOOLEAN_TYPE, BOOLEAN_TYPE));
    /**
     * Predefined scheme for Prelude boolean binary functions.
     */
    public static final Scheme BOOLEAN_BINARY = new Scheme(Collections.emptySet(),
            arrowOf(BOOLEAN_TYPE, BOOLEAN_TYPE, BOOLEAN_TYPE));

    /**
     * Set of bound variables.
     */
    public final Set<Long> variables;
    /**
     * Inner scheme type being generalized.
     */
    public final Type type;
    /**
     * Sorted set of bound variables.
     */
    public final Set<Long> sortedVariables;
    /**
     * Set view of free variables.
     */
    private final Set<Long> freeVariables;

    /**
     * Constructor for scheme.
     *
     * @param variables bound variables
     * @param type      inner type
     */
    public Scheme(Set<Long> variables, Type type) {
        this.variables = variables;
        sortedVariables = variables.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        this.type = type;
        freeVariables = Sets.difference(type.freeVariables(), variables);
    }

    /**
     * Instantiate the scheme, replacing bound variables with fresh type variables.
     *
     * @return tuple of potential substitution and instantiated type
     */
    public Utils.Tuple<Substitution, Type> instantiate() {
        Substitution instantiation = new Substitution(variables.stream()
                .collect(ImmutableMap.toImmutableMap(v -> v, v -> InferenceEngine.newTypeVariable())));
        return new Utils.Tuple<>(instantiation, type.applySubstitution(instantiation));
    }

    /**
     * Get the set of free variables.
     *
     * @return free variables set
     */
    @Override
    public Set<Long> freeVariables() {
        return freeVariables;
    }

    /**
     * Apply a substitution.
     *
     * @param substitution substitution to apply
     * @return object with applied substitution
     */
    @Override
    public Scheme applySubstitution(Substitution substitution) {
        return new Scheme(variables, type.applySubstitution(substitution.exclude(variables)));
    }

    /**
     * Scheme {@link Object#equals} method.
     *
     * @param obj other object
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Scheme other))
            return false;
        return variables.equals(other.variables) && type.equals(other.type);
    }

    /**
     * Scheme {@link Object#hashCode} method.
     *
     * @return object hash code
     */
    @Override
    public int hashCode() {
        return 31 * variables.hashCode() + type.hashCode();
    }

    /**
     * Scheme {@link Object#toString} method.
     *
     * @return object string representation
     */
    @Override
    public String toString() {
        return String.format("%s%s",
                variables.isEmpty() ? "" : "forall " + sortedVariables.stream()
                        .map(InferenceEngine.fancyTypes() ? Variable::toFancyString : Variable::toString)
                        .collect(Collectors.joining(" ")) + ". ",
                type);
    }
}
