package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Type system environment class.
 */
public final class Environment implements Types<Environment> {
    /**
     * Variable schemes map.
     */
    private final Map<String, Scheme> variableSchemes;
    /**
     * Current lambda parameters.
     */
    private final Set<String> lambdaParams;

    /**
     * Constructor for the environment.
     */
    public Environment() {
        variableSchemes = new HashMap<>();
        lambdaParams = new HashSet<>();
    }

    /**
     * Constructor for the environment from another environment.
     *
     * @param env other environment
     */
    public Environment(Environment env) {
        variableSchemes = new HashMap<>(env.variableSchemes);
        lambdaParams = new HashSet<>(env.lambdaParams);
    }

    /**
     * Get a variable scheme.
     *
     * @param variable variable name
     * @return variable scheme
     */
    public Scheme bindingOf(String variable) {
        return variableSchemes.get(variable);
    }

    /**
     * Bind a variable to a scheme.
     *
     * @param variable variable name
     * @param scheme   scheme to bind
     */
    public void bind(String variable, Scheme scheme) {
        variableSchemes.put(variable, scheme);
    }

    /**
     * Bind a lambda parameter.
     *
     * @param paramId parameter name
     * @return true if the parameter was bound, false otherwise
     */
    public boolean lambdaBind(String paramId) {
        return lambdaParams.add(paramId);
    }

    /**
     * Free a lambda parameter.
     *
     * @param paramId parameter name
     */
    public void lambdaFree(String paramId) {
        lambdaParams.remove(paramId);
    }

    /**
     * Get the set of free variables.
     *
     * @return free variables set
     */
    @Override
    public Set<Long> freeVariables() {
        return variableSchemes.values().stream()
                .flatMap(s -> s.freeVariables().stream())
                .collect(ImmutableSet.toImmutableSet());
    }

    /**
     * Apply a substitution.
     *
     * @param substitution substitution to apply
     * @return object with applied substitution
     */
    @Override
    public Environment applySubstitution(Substitution substitution) {
        Environment newEnv = new Environment(this);
        newEnv.variableSchemes.replaceAll((v, s) -> s.applySubstitution(substitution));
        return newEnv;
    }
}
