package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.TypeEnum;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Base class for type nodes.
 */
public abstract class Type extends ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    protected Type() {
        super(InputPosition.UNKNOWN);
    }

    /**
     * Force subclasses to override the {@link Object} equals method.
     *
     * @param obj object co compare
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Force subclasses to override the {@link Object} hashCode method.
     *
     * @return hash code of the object
     */
    @Override
    public abstract int hashCode();

    /**
     * Force subclasses to override the {@link Object} toString method.
     *
     * @return string representation of the object
     */
    @Override
    public abstract String toString();

    /**
     * Names type class.
     */
    public static final class NamedType extends Type {
        /**
         * Type enum.
         */
        public final TypeEnum type;

        /**
         * Constructor for the named type node.
         *
         * @param type type enum
         */
        public NamedType(TypeEnum type) {
            this.type = type;
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitNamedType(this);
        }

        /**
         * Equals method override to compare two named type nodes.
         *
         * @param obj object to compare
         * @return true if the two objects are equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof NamedType other))
                return false;
            return this.type == other.type;
        }

        /**
         * Hash code method override for the named type node.
         *
         * @return hash code of the object
         */
        @Override
        public int hashCode() {
            return type.hashCode();
        }

        /**
         * To string method override for the named type node.
         *
         * @return string representation of the object
         */
        @Override
        public String toString() {
            return type.typeName;
        }
    }

    /**
     * Variable type class.
     */
    public static final class VariableType extends Type {
        /**
         * Type name.
         */
        public final String name;

        /**
         * Constructor for the variable type node.
         *
         * @param name type name
         */
        public VariableType(String name) {
            this.name = name;
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitVariableType(this);
        }

        /**
         * Equals method override to compare two variable type nodes.
         *
         * @param obj object to compare
         * @return true if the two objects are equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof VariableType other))
                return false;
            return this.name.equals(other.name);
        }

        /**
         * Hash code method override for the variable type node.
         *
         * @return hash code of the object
         */
        @Override
        public int hashCode() {
            return name.hashCode();
        }

        /**
         * To string method override for the variable type node.
         *
         * @return string representation of the object
         */
        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Arrow type class.
     */
    public static final class ArrowType extends Type {
        /**
         * Default arithmetic function type.
         */
        public static final Type.ArrowType ARITHMETIC_FUNCTION_TYPE =
                new Type.ArrowType(new NamedType(TypeEnum.INTEGER),
                        new Type.ArrowType(new NamedType(TypeEnum.INTEGER),
                                new NamedType(TypeEnum.INTEGER)));

        /**
         * Default comparison function type.
         */
        public static final Type.ArrowType COMPARISON_FUNCTION_TYPE =
                new Type.ArrowType(new NamedType(TypeEnum.INTEGER),
                        new Type.ArrowType(new NamedType(TypeEnum.INTEGER),
                                new NamedType(TypeEnum.BOOLEAN)));

        /**
         * Input type node.
         */
        public final ASTNode input;
        /**
         * Output type node.
         */
        public final ASTNode output;

        /**
         * Constructor for the arrow type node.
         *
         * @param input  input type node
         * @param output output type node
         */
        public ArrowType(ASTNode input, ASTNode output) {
            this.input = input;
            this.output = output;
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitArrowType(this);
        }

        /**
         * Equals method override to compare two arrow type nodes.
         *
         * @param obj object to compare
         * @return true if the two objects are equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof ArrowType other))
                return false;
            return this.input.equals(other.input) && this.output.equals(other.output);
        }

        /**
         * Hash code method override for the arrow type node.
         *
         * @return hash code of the object
         */
        @Override
        public int hashCode() {
            return 31 * input.hashCode() + output.hashCode();
        }

        /**
         * To string method override for the arrow type node.
         *
         * @return string representation of the object
         */
        @Override
        public String toString() {
            return String.format("(%s -> %s)", input, output);
        }
    }
}
