package com.github.massimopavoni.funx.jt.parser;

import com.github.massimopavoni.funx.jt.ast.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse tree visitor used to build the program's AST.
 */
public class ASTBuilder extends FunxParserBaseVisitor<ASTNode> {
    /**
     * Default constructor.
     */
    public ASTBuilder() {
    }

    /**
     * Convert a list of parameters and a statement into a lambda chain.
     *
     * @param params    list of parameters
     * @param statement statement
     * @return first node of the lambda chain
     */
    private ASTNode createLambdaChain(List<String> params, ASTNode statement) {
        if (params.size() == 1)
            return new Statement.Lambda(params.getFirst(), statement);
        return new Statement.Lambda(params.removeFirst(),
                createLambdaChain(params, statement));
    }

    /**
     * Create a double application from a binary operator,
     * retrieving the Prelude function name from the used symbol.
     *
     * @param symbol operator symbol
     * @param left   left node
     * @param right  right node
     * @return double application node
     */
    private ASTNode binarySymbolApplication(String symbol, ASTNode left, ASTNode right) {
        return new Expression.Application(
                new Expression.Application(
                        new Primary.Variable(PreludeFunction.fromFunctionSymbol(symbol).functionName),
                        left),
                right);
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#module()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitModule(FunxParser.ModuleContext ctx) {
        // Potentially do other things (e.g. set a different package)
        return visit(ctx.declarations());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declarations()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitDeclarations(FunxParser.DeclarationsContext ctx) {
        return new ASTNode.Module(ctx.declaration().stream()
                .map(this::visit).toList());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declaration()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitDeclaration(FunxParser.DeclarationContext ctx) {
        ASTNode statement;
        if (ctx.localDeclarations() != null)
            statement = new Statement.Let(ctx.localDeclarations().declarations().declaration().stream()
                    .map(this::visit).toList(),
                    visit(ctx.statement()));
        else
            statement = visit(ctx.statement());
        FunxParser.DeclarationTypeContext declarationTypeContext = ctx.declarationType();
        return new Declaration(
                declarationTypeContext.id.getText(),
                visit(declarationTypeContext),
                ctx.id.getText(),
                ctx.lambdaParams() != null
                        ? createLambdaChain(ctx.lambdaParams().VARID().stream()
                        .map(ParseTree::getText)
                        .collect(Collectors.toCollection(ArrayList::new)), statement)
                        : statement);
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declarationType()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitDeclarationType(FunxParser.DeclarationTypeContext ctx) {
        return visit(ctx.typeElems());
    }

    /**
     * Visit a parse tree produced by the {@code arrowType}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitArrowType(FunxParser.ArrowTypeContext ctx) {
        return new Type.ArrowType(visit(ctx.typeElems(0)),
                visit(ctx.typeElems(1)));
    }

    /**
     * Visit a parse tree produced by the {@code parenType}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParenType(FunxParser.ParenTypeContext ctx) {
        return visit(ctx.typeElems());
    }

    /**
     * Visit a parse tree produced by the {@code type}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitType(FunxParser.TypeContext ctx) {
        return new Type.SimpleType(TypeEnum.fromString(ctx.TYPE().getText()));
    }

    /**
     * Visit a parse tree produced by the {@code expressionStatement}
     * labeled alternative in {@link FunxParser#statement()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitExpressionStatement(FunxParser.ExpressionStatementContext ctx) {
        return visit(ctx.expression());
    }

    /**
     * Visit a parse tree produced by the {@code lambdaStatement}
     * labeled alternative in {@link FunxParser#statement()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLambdaStatement(FunxParser.LambdaStatementContext ctx) {
        return visit(ctx.lambda());
    }

    /**
     * Visit a parse tree produced by the {@code letStatement}
     * labeled alternative in {@link FunxParser#statement()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLetStatement(FunxParser.LetStatementContext ctx) {
        return visit(ctx.let());
    }

    /**
     * Visit a parse tree produced by the {@code ifStatement}
     * labeled alternative in {@link FunxParser#statement()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitIfStatement(FunxParser.IfStatementContext ctx) {
        return visit(ctx.ifS());
    }

    /**
     * Visit a parse tree produced by the {@code primExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitPrimExpression(FunxParser.PrimExpressionContext ctx) {
        return visit(ctx.primary());
    }

    /**
     * Visit a parse tree produced by the {@code appExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAppExpression(FunxParser.AppExpressionContext ctx) {
        return new Expression.Application(visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code notExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitNotExpression(FunxParser.NotExpressionContext ctx) {
        return new Expression.Application(
                new Primary.Variable(PreludeFunction.NOT.functionName),
                visit(ctx.expression()));
    }

    /**
     * Visit a parse tree produced by the {@code divModMultExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitDivModMultExpression(FunxParser.DivModMultExpressionContext ctx) {
        return binarySymbolApplication(
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code addSubExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAddSubExpression(FunxParser.AddSubExpressionContext ctx) {
        return binarySymbolApplication(
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code compExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitCompExpression(FunxParser.CompExpressionContext ctx) {
        return binarySymbolApplication(
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code eqExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitEqExpression(FunxParser.EqExpressionContext ctx) {
        return binarySymbolApplication(
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code andExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAndExpression(FunxParser.AndExpressionContext ctx) {
        // Transform logical conjunction into if statement for short-circuiting behavior
        return new Statement.If(visit(ctx.expression(0)),
                visit(ctx.expression(1)),
                new Primary.Constant(false));
    }

    /**
     * Visit a parse tree produced by the {@code orExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitOrExpression(FunxParser.OrExpressionContext ctx) {
        // Transform logical disjunction into if statement for short-circuiting behavior
        return new Statement.If(visit(ctx.expression(0)),
                new Primary.Constant(true),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code parenPrimary}
     * labeled alternative in {@link FunxParser#primary()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParenPrimary(FunxParser.ParenPrimaryContext ctx) {
        return visit(ctx.statement());
    }

    /**
     * Visit a parse tree produced by the {@code constPrimary}
     * labeled alternative in {@link FunxParser#primary()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitConstPrimary(FunxParser.ConstPrimaryContext ctx) {
        return visit(ctx.constant());
    }

    /**
     * Visit a parse tree produced by the {@code varPrimary}
     * labeled alternative in {@link FunxParser#primary()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitVarPrimary(FunxParser.VarPrimaryContext ctx) {
        return new Primary.Variable(ctx.VARID().getText());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#lambda()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLambda(FunxParser.LambdaContext ctx) {
        return createLambdaChain(ctx.lambdaParams().VARID().stream()
                .map(ParseTree::getText)
                .toList(), visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#let()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLet(FunxParser.LetContext ctx) {
        return new Statement.Let(ctx.localDeclarations().declarations().declaration().stream()
                .map(this::visit).toList(),
                visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#ifS()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitIfS(FunxParser.IfSContext ctx) {
        return new Statement.If(visit(ctx.statement(0)),
                visit(ctx.statement(1)),
                visit(ctx.statement(2)));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#constant()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitConstant(FunxParser.ConstantContext ctx) {
        if (ctx.numConstant() != null)
            return visit(ctx.numConstant());
        return switch (ctx.start.getType()) {
            case FunxLexer.BOOL -> new Primary.Constant(Boolean.parseBoolean(ctx.BOOL().getText()));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "constant");
        };
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#numConstant()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitNumConstant(FunxParser.NumConstantContext ctx) {
        return switch (ctx.start.getType()) {
            case FunxLexer.INT -> new Primary.Constant(
                    Integer.parseInt(
                            ctx.INT().getText().replaceAll("[()]", "")));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "numeric constant");
        };
    }
}

