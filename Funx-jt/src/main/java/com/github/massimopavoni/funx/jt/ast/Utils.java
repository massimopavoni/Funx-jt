package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Useful static methods for AST operations.
 */
public final class Utils {
    /**
     * Static class constructor, private to prevent instantiation.
     *
     * @throws IllegalStateException if an attempt to instantiate the class is made
     */
    private Utils() {
        throw new IllegalStateException("Static class cannot be instantiated.");
    }

    /**
     * Get the enum constant from an enum by filtering on a filter.
     *
     * @param enumClass   enum class to use
     * @param fieldFilter filter to apply
     * @param <E>         enum generic parameter
     * @return enum constant or null if not found
     */
    public static <E extends Enum<E>> E enumFromField(Class<E> enumClass, Predicate<E> fieldFilter) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(fieldFilter)
                .findFirst()
                .orElse(null);
    }

    /**
     * Return the string representation of a lexer token.
     * Put here instead of the lexer to avoid using java code snippets in ANTLR '.g4' grammar files.
     *
     * @param token lexer token
     * @return string representation of the token
     */
    public static String fromLexerToken(int token) {
        return FunxLexer.VOCABULARY.getLiteralName(token).replace("'", "");
    }

    /**
     * Tuple record class.
     *
     * @param fst first element
     * @param snd second element
     * @param <A> first element type
     * @param <B> second element type
     */
    public record Tuple<A, B>(A fst, B snd) {
        /**
         * Change the first element of the tuple.
         *
         * @param fst new first element
         * @return new tuple with the first element changed
         */
        public Tuple<A, B> setFst(A fst) {
            return new Tuple<>(fst, snd);
        }

        /**
         * Change the second element of the tuple.
         *
         * @param snd new second element
         * @return new tuple with the second element changed
         */
        public Tuple<A, B> setSnd(B snd) {
            return new Tuple<>(fst, snd);
        }
    }
}
