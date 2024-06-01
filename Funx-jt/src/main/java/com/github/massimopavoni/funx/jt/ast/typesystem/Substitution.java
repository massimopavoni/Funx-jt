package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Substitution class for type inference unification.
 */
public final class Substitution implements Types<Substitution> {
    /**
     * Empty substitution.
     */
    public static final Substitution EMPTY = new Substitution();
    /**
     * Map of type variables and their substitute types.
     */
    private final Map<Long, Type> variableTypes;

    /**
     * Constructor for the substitution.
     */
    public Substitution() {
        variableTypes = new HashMap<>();
    }

    /**
     * Constructor for the substitution from a map of variables and types.
     *
     * @param variableTypes map of type variables and their substitute types
     */
    public Substitution(Map<Long, Type> variableTypes) {
        this.variableTypes = variableTypes;
    }

    /**
     * Compose two substitutions.
     *
     * @param other other substitution to compose with
     * @return composed substitution
     */
    public Substitution compose(Substitution other) {
        Substitution subst = other.applySubstitution(this);
        subst.variableTypes.putAll(variableTypes);
        return subst;
    }

    /**
     * Get the set of variables in the substitution.
     *
     * @return set of variables
     */
    public Set<Long> variables() {
        return variableTypes.keySet();
    }

    /**
     * Get the substitute type of a type variable.
     *
     * @param variable type variable
     * @return substitute type
     */
    public Type substituteOf(Long variable) {
        return variableTypes.get(variable);
    }

    /**
     * Exclude a set of type variables from the substitution.
     *
     * @param variables set of variables to exclude
     * @return new substitution with the variables excluded
     */
    public Substitution exclude(Set<Long> variables) {
        return new Substitution(variableTypes.entrySet().stream()
                .filter(e -> !variables.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    /**
     * Get the set of free variables.
     *
     * @return free variables set
     */
    @Override
    public Set<Long> freeVariables() {
        return variableTypes.values().stream()
                .flatMap(t -> t.freeVariables().stream())
                .collect(ImmutableSet.toImmutableSet());
    }

    /**
     * Apply a substitution.
     *
     * @param substitution substitution to apply
     * @return object with applied substitution
     */
    @Override
    public Substitution applySubstitution(Substitution substitution) {
        return new Substitution(variableTypes.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().applySubstitution(substitution))));
    }
}
