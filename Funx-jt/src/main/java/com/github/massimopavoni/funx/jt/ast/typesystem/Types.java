package com.github.massimopavoni.funx.jt.ast.typesystem;

import java.util.Set;

public sealed interface Types<T extends Types<T>>
        permits Type, Scheme, Substitution, Environment {
    Set<Long> freeVariables();

    T apply(Substitution substitution);
}
