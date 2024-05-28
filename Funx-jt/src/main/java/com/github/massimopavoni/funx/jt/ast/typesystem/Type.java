package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

public abstract sealed class Type implements Types<Type> {
    public Scheme generalize(Environment env) {
        return new Scheme(Sets.difference(freeVariables(), env.freeVariables()), this);
    }

    public abstract Substitution unify(Type other) throws TypeException;

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();

    public static final class Error extends Type {
        public static final Error INSTANCE = new Error();

        private Error() {
        }

        @Override
        public Substitution unify(Type other) {
            return Substitution.EMPTY;
        }

        @Override
        public Set<Long> freeVariables() {
            return Collections.emptySet();
        }

        @Override
        public Type applySubstitution(Substitution substitution) {
            return this;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return obj instanceof Error;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "TypeError";
        }
    }

    public static final class Boring extends Type {
        public static final Boring INSTANCE = new Boring();

        private Boring() {
        }

        @Override
        public Substitution unify(Type other) {
            return Substitution.EMPTY;
        }

        @Override
        public Set<Long> freeVariables() {
            return Collections.emptySet();
        }

        @Override
        public Type applySubstitution(Substitution substitution) {
            return this;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return obj instanceof Boring;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "()";
        }
    }

    public static final class Variable extends Type {
        public static final Variable ZERO = new Variable(0L);
        public static final Variable ONE = new Variable(1L);
        public static final Variable TWO = new Variable(2L);

        public final long id;

        public Variable(long id) {
            this.id = id;
        }

        public static String toString(long id) {
            return id < 26 ? Character.toString((char) ('a' + id)) : "t" + id;
        }

        public static String toFancyString(long id) {
            return id < 24 ? Character.toString((char) (945 + id)) : "t" + id;
        }

        @Override
        public Substitution unify(Type other) throws TypeException {
            return bind(other);
        }

        public Substitution bind(Type type) throws TypeException {
            if (this.equals(type))
                return Substitution.EMPTY;
            if (type.freeVariables().contains(id))
                throw new TypeException(this, type);
            return new Substitution(Collections.singletonMap(id, type));
        }

        @Override
        public Set<Long> freeVariables() {
            return Set.of(id);
        }

        @Override
        public Type applySubstitution(Substitution substitution) {
            return substitution.variables().contains(id)
                    ? substitution.substituteOf(id)
                    : this;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Variable other))
                return false;
            return id == other.id;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(id);
        }

        @Override
        public String toString() {
            return InferenceEngine.fancyTypes() ? toFancyString(id) : toString(id);
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

        public static FunctionApplication arrowOf(Type... args) {
            if (args.length < 2)
                throw new IllegalArgumentException("arrow constructor requires at least 2 arguments");
            if (args.length == 2)
                return new FunctionApplication(TypeFunction.ARROW, List.of(args));
            return new FunctionApplication(TypeFunction.ARROW,
                    List.of(args[0], arrowOf(Arrays.copyOfRange(args, 1, args.length))));
        }

        @Override
        public Substitution unify(Type other) throws TypeException {
            return switch (other) {
                case Error ignored -> Substitution.EMPTY;
                case Boring ignored -> Substitution.EMPTY;
                case Variable variable -> variable.bind(this);
                case FunctionApplication fun -> {
                    if (function != fun.function || arguments.size() != fun.arguments.size())
                        throw new TypeException(this, fun);
                    if (arguments.isEmpty())
                        yield Substitution.EMPTY;
                    Substitution subst = arguments.getFirst().unify(fun.arguments.getFirst());
                    for (int i = 1; i < arguments.size(); i++) {
                        Substitution s = arguments.get(i).applySubstitution(subst)
                                .unify(fun.arguments.get(i).applySubstitution(subst));
                        subst = subst.compose(s);
                    }
                    yield subst;
                }
            };
        }

        @Override
        public Set<Long> freeVariables() {
            return arguments.stream()
                    .flatMap(a -> a.freeVariables().stream())
                    .collect(ImmutableSet.toImmutableSet());
        }

        @Override
        public Type applySubstitution(Substitution substitution) {
            return new FunctionApplication(function, arguments.stream()
                    .map(a -> a.applySubstitution(substitution))
                    .collect(ImmutableList.toImmutableList()));
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof FunctionApplication other))
                return false;
            return function == other.function && arguments.equals(other.arguments);
        }

        @Override
        public int hashCode() {
            return 31 * function.hashCode() + arguments.hashCode();
        }

        @Override
        public String toString() {
            if (function == TypeFunction.ARROW) {
                Type input = arguments.getFirst();
                return String.format("%s %s %s",
                        input instanceof FunctionApplication fa && fa.function == TypeFunction.ARROW
                                ? "(" + input + ")"
                                : input,
                        function.id, arguments.get(1));
            }
            if (arguments.isEmpty())
                return function.id;
            return String.format("%s %s", function.id,
                    arguments.stream()
                            .map(Type::toString)
                            .collect(Collectors.joining(" ")));
        }
    }
}
