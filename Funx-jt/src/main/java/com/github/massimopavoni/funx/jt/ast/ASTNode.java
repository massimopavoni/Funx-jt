package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;

/**
 * Base class for every node in the AST.
 */
public abstract class ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    ASTNode() {
    }

    /**
     * Returns the string representation of a lexer token.
     * Put here instead of the lexer to avoid using java code snippets in ANTLR '.g4' grammar files.
     *
     * @param token lexer token
     * @return string representation of the token
     */
    public static String fromLexerToken(int token) {
        return FunxLexer.VOCABULARY.getLiteralName(token).replaceAll("'", "");
    }

    /**
     * Returns a unique identifier for the node.
     * Used for AST tree visualization.
     *
     * @return unique identifier using the hash code of the object
     */
    public String getNodeId() {
        return String.valueOf(hashCode());
    }

    /**
     * Default behavior for the {@link ASTNode#toGraphviz} method,
     * using more parameters to set a node label and connect all children to this node.
     *
     * @param builder  Graphviz code string builder
     * @param label    node label
     * @param children list of children nodes
     * @return node identifier
     */
    public String toGraphvizDefault(StringBuilder builder, String label, List<ASTNode> children) {
        String nodeId = getNodeId();
        builder.append(String.format("%s [label=\"%s\"];\n",
                nodeId, label));
        children.forEach(c -> builder.append(
                String.format("%s -> %s;\n",
                        nodeId,
                        c.toGraphviz(builder))));
        return nodeId;
    }

    /**
     * Method for AST tree visualization.
     *
     * @param builder Graphviz code string builder
     * @return node identifier
     */
    public abstract String toGraphviz(StringBuilder builder);

    /**
     * To string method override,
     * essentially re-prints the original source code.
     *
     * @return string representation of the node
     */
    @Override
    public abstract String toString();

    /**
     * Root node of the AST.
     */
    public final static class Program extends ASTNode {
        /**
         * List of functions in the program.
         */
        public final List<ASTNode> functions;

        /**
         * Constructor for the program node.
         *
         * @param functions list of functions in the program
         */
        public Program(List<ASTNode> functions) {
            this.functions = functions;
        }

        /**
         * Custom program node {@link ASTNode#toGraphviz} method,
         * creating and closing the directed graph.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            builder.append("""
                    digraph AST {
                    compound=true;
                    node [color=gray40, shape=egg];
                    edge [color=gray40, arrowsize=0.8];
                    """);
            String nodeId = toGraphvizDefault(builder, getClass().getSimpleName(), functions);
            builder.append("}\n");
            return nodeId;
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.join("\n\n",
                    functions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new));
        }
    }
}
