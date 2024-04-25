package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;
import java.util.List;

public abstract class Statement extends ASTNode {
    public final static class Lambda extends ASTNode {
        public final ASTNode params;
        public final ASTNode body;

        public Lambda(ASTNode params, ASTNode body) {
            this.params = params;
            this.body = body;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder,
                    String.format("\\\\%s", params.toString()),
                    Collections.singletonList(body));
        }

        @Override
        public String toString() {
            return String.format("%s%s %s %s",
                    ASTNode.fromLexerToken(FunxLexer.Backslash),
                    params.toString(),
                    ASTNode.fromLexerToken(FunxLexer.Arrow),
                    body.toString());
        }

        public final static class Param extends ASTNode {
            public final String funId;

            public Param(String funId) {
                this.funId = funId;
            }

            @Override
            public String toGraphviz(StringBuilder builder) {
                // currently unused
                return "";
            }

            @Override
            public String toString() {
                return funId;
            }
        }

        public final static class MultiParam extends ASTNode {
            public final ASTNode first;
            public final ASTNode second;

            public MultiParam(ASTNode first, ASTNode second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public String toGraphviz(StringBuilder builder) {
                // currently unused
                return "";
            }

            @Override
            public String toString() {
                return String.format("%s %s", first.toString(), second.toString());
            }
        }
    }

    public final static class Let extends ASTNode {
        public final List<ASTNode> localFunctions;
        public final ASTNode body;

        public Let(List<ASTNode> localFunctions, ASTNode body) {
            this.localFunctions = localFunctions;
            this.body = body;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            String nodeId = getNodeId();
            builder.append(String.format("""
                            %1$s [label="%2$s"];
                            subgraph cluster_%1$s {
                            """,
                    nodeId, ASTNode.fromLexerToken(FunxLexer.LET)));
            List<String> childrenIds = localFunctions.stream()
                    .map(f -> f.toGraphviz(builder)).toList();
            builder.append("}\n");
            builder.append(String.format("""
                            %1$s -> %2$s [lhead="cluster_%1$s"];
                            %1$s -> %3$s;
                            """,
                    nodeId, childrenIds.get(childrenIds.size() / 2), body.toGraphviz(builder)));
            return nodeId;
        }

        @Override
        public String toString() {
            return String.format("%s\n%s\n%s %s",
                    ASTNode.fromLexerToken(FunxLexer.LET),
                    String.join("\n", localFunctions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new)),
                    ASTNode.fromLexerToken(FunxLexer.IN),
                    body.toString());
        }
    }

    public final static class If extends ASTNode {
        public final ASTNode condition;
        public final ASTNode thenBranch;
        public final ASTNode elseBranch;

        public If(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder,
                    ASTNode.fromLexerToken(FunxLexer.IF),
                    List.of(condition, thenBranch, elseBranch));
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s %s %s",
                    ASTNode.fromLexerToken(FunxLexer.IF),
                    condition.toString(),
                    ASTNode.fromLexerToken(FunxLexer.THEN),
                    thenBranch.toString(),
                    ASTNode.fromLexerToken(FunxLexer.ELSE),
                    elseBranch.toString());
        }
    }
}
