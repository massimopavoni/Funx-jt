package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;

public abstract class ASTNode {
    public static String fromLexerToken(int token) {
        return FunxLexer.VOCABULARY.getLiteralName(token).replaceAll("'", "");
    }

    public String getNodeId() {
        return String.valueOf(hashCode());
    }

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

    public abstract String toGraphviz(StringBuilder builder);

    @Override
    public abstract String toString();

    public final static class Program extends ASTNode {
        public final List<ASTNode> functions;

        public Program(List<ASTNode> functions) {
            this.functions = functions;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            builder.append("""
                    digraph AST {
                    compound=true;
                    """);
            String nodeId = toGraphvizDefault(builder, getClass().getSimpleName(), functions);
            builder.append("}\n");
            return nodeId;
        }

        @Override
        public String toString() {
            return String.join("\n\n",
                    functions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new));
        }
    }
}
