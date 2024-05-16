package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Environment implements Types<Environment> {
    private final Map<String, Scheme> variableSchemes;

    public Environment() {
        variableSchemes = new HashMap<>();
    }

    public Scheme bindingOf(String variable) {
        return variableSchemes.get(variable);
    }

    public void remove(String variable) {
        variableSchemes.remove(variable);
    }

    public Scheme generalizeType(Type type) {
        return new Scheme(Sets.difference(type.freeVariables(), freeVariables()), type);
    }

    @Override
    public Set<Long> freeVariables() {
        return variableSchemes.values().stream()
                .flatMap(s -> s.freeVariables().stream())
                .collect(ImmutableSet.toImmutableSet());
    }

    @Override
    public Environment applySubstitution(Substitution substitution) {
        variableSchemes.forEach((v, s) -> variableSchemes.put(v, s.applySubstitution(substitution)));
        return this;
    }
}
