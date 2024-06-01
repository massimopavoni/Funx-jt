package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Type system context class.
 */
public final class Context implements Types<Context> {
    /**
     * Mappings between variable names and corresponding schemes.
     */
    private final Map<String, Scheme> environment;
    /**
     * Current lambda parameters.
     */
    private final Set<String> lambdaParams;

    /**
     * Constructor for the context.
     */
    public Context() {
        environment = new HashMap<>();
        lambdaParams = new HashSet<>();
    }

    /**
     * Constructor for the context from another context.
     *
     * @param ctx other context
     */
    public Context(Context ctx) {
        environment = new HashMap<>(ctx.environment);
        lambdaParams = new HashSet<>(ctx.lambdaParams);
    }

    /**
     * Get a variable scheme.
     *
     * @param variable variable name
     * @return variable scheme
     */
    public Scheme bindingOf(String variable) {
        return environment.get(variable);
    }

    /**
     * Bind a variable to a scheme.
     *
     * @param variable variable name
     * @param scheme   scheme to bind
     */
    public void bind(String variable, Scheme scheme) {
        environment.put(variable, scheme);
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
        return environment.values().stream()
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
    public Context applySubstitution(Substitution substitution) {
        Context newCtx = new Context(this);
        newCtx.environment.replaceAll((v, s) -> s.applySubstitution(substitution));
        return newCtx;
    }
}
