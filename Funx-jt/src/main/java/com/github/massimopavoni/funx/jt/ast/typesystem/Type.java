package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public sealed abstract class Type implements Types<Type>
        permits Type.Variable, Type.FunctionApplication {
    public static final class Variable extends Type {
        public static final Variable ZERO = new Variable(0L);

        public final long id;

        public Variable(long id) {
            this.id = id;
        }

        @Override
        public Set<Long> freeVariables() {
            return ImmutableSet.of(id);
        }

        @Override
        public Type apply(Substitution substitution) {
            return substitution.variables().contains(id)
                    ? substitution.substituteOf(id)
                    : this;
        }
    }

    public static final class FunctionApplication extends Type {
        public static final FunctionApplication BOOLEAN_TYPE =
                new FunctionApplication(TypeFunction.BOOLEAN, Collections.emptyList());
        public static final FunctionApplication INTEGER_TYPE =
                new FunctionApplication(TypeFunction.INTEGER, Collections.emptyList());

        public final TypeFunction function;
        public final List<Type> arguments;

        public FunctionApplication(TypeFunction function, List<Type> arguments) {
            this.function = function;
            this.arguments = arguments;
        }

        @Override
        public Set<Long> freeVariables() {
            return arguments.stream()
                    .flatMap(a -> a.freeVariables().stream())
                    .collect(ImmutableSet.toImmutableSet());
        }

        @Override
        public Type apply(Substitution substitution) {
            return new FunctionApplication(function, arguments.stream()
                    .map(a -> a.apply(substitution))
                    .collect(ImmutableList.toImmutableList()));
        }
    }
}
