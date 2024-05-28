package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.*;

public final class Environment implements Types<Environment> {
    private final Map<String, Scheme> variableSchemes;
    private final Set<String> lambdaParams;

    public Environment() {
        variableSchemes = new HashMap<>();
        lambdaParams = new HashSet<>();
    }

    public Environment(Environment env) {
        variableSchemes = new HashMap<>(env.variableSchemes);
        lambdaParams = new HashSet<>(env.lambdaParams);
    }

    public Scheme bindingOf(String variable) {
        return variableSchemes.get(variable);
    }

    public void bind(String variable, Scheme scheme) {
        variableSchemes.put(variable, scheme);
    }

    public boolean lambdaBind(String paramId) {
        return lambdaParams.add(paramId);
    }

    public void lambdaFree(String paramId) {
        lambdaParams.remove(paramId);
    }

    @Override
    public Set<Long> freeVariables() {
        return variableSchemes.values().stream()
                .flatMap(s -> s.freeVariables().stream())
                .collect(ImmutableSet.toImmutableSet());
    }

    @Override
    public Environment applySubstitution(Substitution substitution) {
        Environment newEnv = new Environment(this);
        newEnv.variableSchemes.replaceAll((v, s) -> s.applySubstitution(substitution));
        return newEnv;
    }
}
