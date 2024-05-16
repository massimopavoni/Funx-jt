package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Substitution implements Types<Substitution> {
    public static final Substitution EMPTY = new Substitution();
    private final Map<Long, Type> variableTypes;

    public Substitution() {
        variableTypes = new HashMap<>();
    }

    public Substitution(Map<Long, Type> variableTypes) {
        this.variableTypes = variableTypes;
    }

    public void compose(Substitution other) {
        variableTypes.putAll(other.apply(this).variableTypes);
    }

    public Set<Long> variables() {
        return variableTypes.keySet();
    }

    public Type substituteOf(Long variable) {
        return variableTypes.get(variable);
    }

    public Substitution exclude(Set<Long> variables) {
        return new Substitution(variableTypes.entrySet().stream()
                .filter(e -> !variables.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    @Override
    public Set<Long> freeVariables() {
        return variableTypes.values().stream()
                .flatMap(t -> t.freeVariables().stream())
                .collect(ImmutableSet.toImmutableSet());
    }

    @Override
    public Substitution apply(Substitution substitution) {
        variableTypes.forEach((v, t) -> variableTypes.put(v, t.apply(substitution)));
        return this;
    }
}
