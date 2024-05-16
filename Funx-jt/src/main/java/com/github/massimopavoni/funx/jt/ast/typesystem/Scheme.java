package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.BOOLEAN_TYPE;
import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.INTEGER_TYPE;
import static com.github.massimopavoni.funx.jt.ast.typesystem.TypeFunction.ARROW;

public final class Scheme implements Types<Scheme> {
    public static final Scheme BOOLEAN_FUNCTION = new Scheme(Collections.emptySet(),
            new Type.FunctionApplication(ARROW,
                    List.of(BOOLEAN_TYPE, new Type.FunctionApplication(ARROW,
                            List.of(BOOLEAN_TYPE, BOOLEAN_TYPE)))));
    public static final Scheme ARITHMETIC_FUNCTION = new Scheme(Collections.emptySet(),
            new Type.FunctionApplication(ARROW,
                    List.of(INTEGER_TYPE, new Type.FunctionApplication(ARROW,
                            List.of(INTEGER_TYPE, BOOLEAN_TYPE)))));
    public static final Scheme COMPARISON_FUNCTION = new Scheme(Collections.emptySet(),
            new Type.FunctionApplication(ARROW,
                    List.of(INTEGER_TYPE, new Type.FunctionApplication(ARROW,
                            List.of(INTEGER_TYPE, BOOLEAN_TYPE)))));

    public final Set<Long> variables;
    public final Type type;
    private final Sets.SetView<Long> freeVariables;

    public Scheme(Set<Long> variables, Type type) {
        this.variables = variables;
        this.type = type;
        freeVariables = Sets.difference(type.freeVariables(), variables);
    }

    @Override
    public Set<Long> freeVariables() {
        return freeVariables;
    }

    @Override
    public Scheme apply(Substitution substitution) {
        return new Scheme(variables, type.apply(substitution.exclude(variables)));
    }
}
