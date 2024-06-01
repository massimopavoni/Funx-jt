package com.github.massimopavoni.funx.jt.ast.typesystem;

import java.util.Set;

/**
 * Interface for defining classes that interact with types.
 *
 * @param <T> The type of the class implementing the interface.
 */
sealed interface Types<T extends Types<T>>
        permits Type, Scheme, Substitution, Context {
    /**
     * Get the set of free variables.
     *
     * @return free variables set
     */
    Set<Long> freeVariables();

    /**
     * Apply a substitution.
     *
     * @param substitution substitution to apply
     * @return object with applied substitution
     */
    T applySubstitution(Substitution substitution);
}
