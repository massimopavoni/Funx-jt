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

    public Substitution compose(Substitution other) {
        Substitution subst = other.applySubstitution(this);
        subst.variableTypes.putAll(variableTypes);
        return subst;
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
    public Substitution applySubstitution(Substitution substitution) {
        return new Substitution(variableTypes.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().applySubstitution(substitution))));
    }
}
