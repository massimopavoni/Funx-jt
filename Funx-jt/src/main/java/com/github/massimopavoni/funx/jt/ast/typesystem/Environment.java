package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Environment implements Types<Environment> {
    private final Map<String, Scheme> variableSchemes;

    public Environment() {
        variableSchemes = new HashMap<>();
    }

    public Environment(Environment environment) {
        variableSchemes = new HashMap<>(environment.variableSchemes);
    }

    public Scheme bindingOf(String variable) {
        return variableSchemes.get(variable);
    }

    public Environment bind(String variable, Scheme scheme) {
        Environment newEnv = new Environment(this);
        newEnv.variableSchemes.put(variable, scheme);
        return newEnv;
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
