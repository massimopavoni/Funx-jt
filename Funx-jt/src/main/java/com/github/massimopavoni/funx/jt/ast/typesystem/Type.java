package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Base class for monomorphic types.
 */
public abstract sealed class Type implements Types<Type> {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    protected Type() {
        // do nothing
    }

    /**
     * Generalize a monomorphic type to get a polymorphic type ({@link Scheme}).
     *
     * @param ctx context to generalize in
     * @return potentially polymorphic type scheme
     */
    public Scheme generalize(Context ctx) {
        return new Scheme(Sets.intersection(freeVariables(), ctx.freeVariables()), this);
    }

    /**
     * Unification method: attempts to find a substitution that makes two types equal.
     *
     * @param other other type
     * @return unification substitution
     * @throws TypeException if unification fails
     */
    public abstract Substitution unify(Type other) throws TypeException;

    /**
     * Force all types to implement {@link Object#equals}.
     *
     * @param obj other object
     * @return true if equal, false otherwise
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Force all types to implement {@link Object#hashCode}
     *
     * @return object hash code
     */
    @Override
    public abstract int hashCode();

    /**
     * Force all types to implement {@link Object#toString}
     *
     * @return object string representation
     */
    @Override
    public abstract String toString();

    /**
     * Type error class,
     * used to keep trying to infer other types after errors are encountered.
     */
    public static final class Error extends Type {
        /**
         * Singleton instance.
         */
        public static final Error INSTANCE = new Error();

        /**
         * Singleton class constructor, private to prevent instantiation from outside.
         */
        private Error() {
            // do nothing
        }

        /**
         * Unification method for type error.
         *
         * @param other other type
         * @return unification substitution
         */
        @Override
        public Substitution unify(Type other) {
            return Substitution.EMPTY;
        }

        /**
         * Get the set of free variables.
         *
         * @return free variables set
         */
        @Override
        public Set<Long> freeVariables() {
            return Collections.emptySet();
        }

        /**
         * Apply a substitution.
         *
         * @param substitution substitution to apply
         * @return object with applied substitution
         */
        @Override
        public Type applySubstitution(Substitution substitution) {
            return this;
        }

        /**
         * Type error {@link Object#equals} method.
         *
         * @param obj other object
         * @return true if equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return obj instanceof Error;
        }

        /**
         * Type error {@link Object#hashCode} method.
         *
         * @return object hash code
         */
        @Override
        public int hashCode() {
            return 0;
        }

        /**
         * Type error {@link Object#toString} method.
         *
         * @return object string representation
         */
        @Override
        public String toString() {
            return "TypeError";
        }
    }

    /**
     * Boring type class, used expressions that should not have a type.
     */
    public static final class Boring extends Type {
        /**
         * Singleton instance.
         */
        public static final Boring INSTANCE = new Boring();

        /**
         * Singleton class constructor, private to prevent instantiation from outside.
         */
        private Boring() {
            // do nothing
        }

        /**
         * Unification method for boring type.
         *
         * @param other other type
         * @return unification substitution
         */
        @Override
        public Substitution unify(Type other) {
            return Substitution.EMPTY;
        }

        /**
         * Get the set of free variables.
         *
         * @return free variables set
         */
        @Override
        public Set<Long> freeVariables() {
            return Collections.emptySet();
        }

        /**
         * Apply a substitution.
         *
         * @param substitution substitution to apply
         * @return object with applied substitution
         */
        @Override
        public Type applySubstitution(Substitution substitution) {
            return this;
        }

        /**
         * Boring type {@link Object#equals} method.
         *
         * @param obj other object
         * @return true if equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return obj instanceof Boring;
        }

        /**
         * Boring type {@link Object#hashCode} method.
         *
         * @return object hash code
         */
        @Override
        public int hashCode() {
            return 0;
        }

        /**
         * Boring type {@link Object#toString} method.
         *
         * @return object string representation
         */
        @Override
        public String toString() {
            return "()";
        }
    }

    /**
     * Type variable class.
     */
    public static final class Variable extends Type {
        /**
         * Predefined type variable for Prelude function polymorphic types.
         */
        public static final Variable ZERO = new Variable(0L);
        /**
         * Predefined type variable for Prelude function polymorphic types.
         */
        public static final Variable ONE = new Variable(1L);
        /**
         * Predefined type variable for Prelude function polymorphic types.
         */
        public static final Variable TWO = new Variable(2L);

        /**
         * Type variable identifier.
         */
        public final long id;

        /**
         * Constructor for the type variable.
         *
         * @param id identifier
         */
        public Variable(long id) {
            this.id = id;
        }

        /**
         * Static {@code toString} method for normal type variables printing.
         *
         * @param id type variable identifier
         * @return latin alphabet string representation
         */
        public static String toString(long id) {
            return id < 26 ? Character.toString((char) ('a' + id)) : "t" + id;
        }

        /**
         * Static {@code toString} method for fancy type variables printing.
         *
         * @param id type variable identifier
         * @return greek alphabet string representation
         */
        public static String toFancyString(long id) {
            return id < 24 ? Character.toString((char) (945 + id)) : "t" + id;
        }

        /**
         * Unification method for type variables.
         *
         * @param other other type
         * @return unification substitution
         * @throws TypeException if unification fails
         */
        @Override
        public Substitution unify(Type other) throws TypeException {
            return bind(other);
        }

        /**
         * Bind a type to a type variable for unification.
         *
         * @param type type to bind
         * @return unification substitution
         * @throws TypeException if binding fails (occur check)
         */
        public Substitution bind(Type type) throws TypeException {
            if (this.equals(type))
                return Substitution.EMPTY;
            if (type.freeVariables().contains(id))
                throw new TypeException(this, type);
            return new Substitution(Collections.singletonMap(id, type));
        }

        /**
         * Get the set of free variables.
         *
         * @return free variables set
         */
        @Override
        public Set<Long> freeVariables() {
            return Set.of(id);
        }

        /**
         * Apply a substitution.
         *
         * @param substitution substitution to apply
         * @return object with applied substitution
         */
        @Override
        public Type applySubstitution(Substitution substitution) {
            return substitution.variables().contains(id)
                    ? substitution.substituteOf(id)
                    : this;
        }

        /**
         * Type variable {@link Object#equals} method.
         *
         * @param obj other object
         * @return true if equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Variable other))
                return false;
            return id == other.id;
        }

        /**
         * Type variable {@link Object#hashCode} method.
         *
         * @return object hash code
         */
        @Override
        public int hashCode() {
            return Long.hashCode(id);
        }

        /**
         * Type variable {@link Object#toString} method.
         *
         * @return object string representation
         */
        @Override
        public String toString() {
            return InferenceEngine.fancyTypes() ? toFancyString(id) : toString(id);
        }
    }

    /**
     * Type function application class.
     */
    public static final class FunctionApplication extends Type {
        /**
         * Predefined zero arity type function application for Prelude function types.
         */
        public static final FunctionApplication BOOLEAN_TYPE =
                new FunctionApplication(TypeFunction.BOOLEAN, Collections.emptyList());
        /**
         * Predefined zero arity type function application for Prelude function types.
         */
        public static final FunctionApplication INTEGER_TYPE =
                new FunctionApplication(TypeFunction.INTEGER, Collections.emptyList());

        /**
         * Type function enum constant.
         */
        public final TypeFunction function;
        /**
         * Function application arguments.
         */
        public final List<Type> arguments;

        /**
         * Constructor for the type function application.
         *
         * @param function  type function
         * @param arguments application arguments
         */
        public FunctionApplication(TypeFunction function, List<Type> arguments) {
            if (arguments.size() != function.arity)
                throw new InferenceException("function application arity mismatch");
            this.function = function;
            this.arguments = arguments;
        }

        /**
         * Static method for currying arrow types using variadic arguments.
         *
         * @param args type varargs
         * @return curried arrow function application
         */
        public static FunctionApplication arrowOf(Type... args) {
            if (args.length < 2)
                throw new IllegalArgumentException("arrow constructor requires at least 2 arguments");
            if (args.length == 2)
                return new FunctionApplication(TypeFunction.ARROW, List.of(args));
            return new FunctionApplication(TypeFunction.ARROW,
                    List.of(args[0], arrowOf(Arrays.copyOfRange(args, 1, args.length))));
        }

        /**
         * Unification method for type function applications.
         *
         * @param other other type
         * @return unification substitution
         * @throws TypeException if unification fails
         */
        @Override
        public Substitution unify(Type other) throws TypeException {
            return switch (other) {
                case Error ignored -> Substitution.EMPTY;
                case Boring ignored -> Substitution.EMPTY;
                // type variable case binds this function application to the type variable
                case Variable variable -> variable.bind(this);
                // function application case unifies the arguments' types
                // after checking that the function is the same and the arguments have the same size
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

        /**
         * Get the set of free variables.
         *
         * @return free variables set
         */
        @Override
        public Set<Long> freeVariables() {
            return arguments.stream()
                    .flatMap(a -> a.freeVariables().stream())
                    .collect(ImmutableSet.toImmutableSet());
        }

        /**
         * Apply a substitution.
         *
         * @param substitution substitution to apply
         * @return object with applied substitution
         */
        @Override
        public Type applySubstitution(Substitution substitution) {
            return new FunctionApplication(function, arguments.stream()
                    .map(a -> a.applySubstitution(substitution))
                    .collect(ImmutableList.toImmutableList()));
        }

        /**
         * Type function application {@link Object#equals} method.
         *
         * @param obj other object
         * @return true if equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof FunctionApplication other))
                return false;
            return function == other.function && arguments.equals(other.arguments);
        }

        /**
         * Type function application {@link Object#hashCode} method.
         *
         * @return object hash code
         */
        @Override
        public int hashCode() {
            return 31 * function.hashCode() + arguments.hashCode();
        }

        /**
         * Type function application {@link Object#toString} method.
         *
         * @return object string representation
         */
        @Override
        public String toString() {
            if (function == TypeFunction.ARROW) {
                Type input = arguments.getFirst();
                // since curried arrow types are right-associative,
                // we only print parentheses around the input type if it is another arrow type
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
