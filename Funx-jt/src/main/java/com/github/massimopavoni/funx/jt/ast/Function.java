package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;

/**
 * Function node class.
 */
public final class Function extends ASTNode {
    /**
     * Type node.
     */
    public final ASTNode type;
    /**
     * Identifier.
     */
    public final String id;
    /**
     * Lambda function node.
     */
    public final ASTNode lambda;

    /**
     * Constructor for the function node.
     *
     * @param type   type node
     * @param id     identifier
     * @param lambda lambda function node
     */
    public Function(ASTNode type, String id, ASTNode lambda) {
        this.type = type;
        this.id = id;
        this.lambda = lambda;
    }

    /**
     * Method for AST tree visualization.
     *
     * @param builder Graphviz code string builder
     * @return node identifier
     */
    @Override
    public String toGraphviz(StringBuilder builder) {
        return toGraphvizDefault(builder,
                String.format("%s : %s", id, type.toString()),
                Collections.singletonList(lambda));
    }

    /**
     * To string method override,
     * essentially re-prints the original source code.
     *
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return String.format("%s\n%s %s %s",
                type.toString(),
                id,
                ASTNode.fromLexerToken(FunxLexer.Equals),
                lambda.toString());
    }
}
