package com.github.massimopavoni.funx.jt.parser;

import com.github.massimopavoni.funx.jt.ast.*;

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
     * Visit a parse tree produced by {@link FunxParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitProgram(FunxParser.ProgramContext ctx) {
        return visit(ctx.functions());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#functions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitFunctions(FunxParser.FunctionsContext ctx) {
        return new ASTNode.Program(ctx.function().stream()
                .map(this::visit).toList());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#function}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitFunction(FunxParser.FunctionContext ctx) {
        ASTNode statement;
        if (ctx.localFunctions() != null)
            statement = new Statement.Let(ctx.localFunctions().functions().function().stream()
                    .map(this::visit).toList(),
                    visit(ctx.statement()));
        else
            statement = visit(ctx.statement());
        return new Function(visit(ctx.functionType()),
                ctx.id.getText(),
                ctx.lambdaParams() != null
                        ? new Statement.Lambda(visit(ctx.lambdaParams()), statement)
                        : statement);
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#functionType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitFunctionType(FunxParser.FunctionTypeContext ctx) {
        return visit(ctx.typeElems());
    }

    /**
     * Visit a parse tree produced by the {@code arrowType}
     * labeled alternative in {@link FunxParser#typeElems}.
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
     * labeled alternative in {@link FunxParser#typeElems}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParenType(FunxParser.ParenTypeContext ctx) {
        return new Type.ParenType(visit(ctx.typeElems()));
    }

    /**
     * Visit a parse tree produced by the {@code type}
     * labeled alternative in {@link FunxParser#typeElems}.
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
     * labeled alternative in {@link FunxParser#statement}.
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
     * labeled alternative in {@link FunxParser#statement}.
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
     * labeled alternative in {@link FunxParser#statement}.
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
     * labeled alternative in {@link FunxParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitIfStatement(FunxParser.IfStatementContext ctx) {
        return visit(ctx.ifS());
    }

    /**
     * Visit a parse tree produced by the {@code appExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAppExpression(FunxParser.AppExpressionContext ctx) {
        ASTNode left = visit(ctx.expression(0));
        return new BinaryOperator.Application(left,
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code compExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitCompExpression(FunxParser.CompExpressionContext ctx) {
        ASTNode left = visit(ctx.expression(0));
        ASTNode right = visit(ctx.expression(1));
        return switch (ctx.bop.getType()) {
            case FunxLexer.GreaterThan -> new BinaryOperator.GreaterThan(left, right);
            case FunxLexer.GreaterThanEquals -> new BinaryOperator.GreaterThanEquals(left, right);
            case FunxLexer.LessThan -> new BinaryOperator.LessThan(left, right);
            case FunxLexer.LessThanEquals -> new BinaryOperator.LessThanEquals(left, right);
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "comparison operator");
        };
    }

    /**
     * Visit a parse tree produced by the {@code primExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitPrimExpression(FunxParser.PrimExpressionContext ctx) {
        return visit(ctx.primary());
    }

    /**
     * Visit a parse tree produced by the {@code notExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitNotExpression(FunxParser.NotExpressionContext ctx) {
        return new UnaryOperator.Not(visit(ctx.expression()));
    }

    /**
     * Visit a parse tree produced by the {@code orExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitOrExpression(FunxParser.OrExpressionContext ctx) {
        return new BinaryOperator.Or(visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code andExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAndExpression(FunxParser.AndExpressionContext ctx) {
        return new BinaryOperator.And(visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code addSubExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitAddSubExpression(FunxParser.AddSubExpressionContext ctx) {
        ASTNode left = visit(ctx.expression(0));
        ASTNode right = visit(ctx.expression(1));
        return switch (ctx.bop.getType()) {
            case FunxLexer.Add -> new BinaryOperator.Add(left, right);
            case FunxLexer.Subtract -> new BinaryOperator.Subtract(left, right);
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "lower precedence arithmetic operator");
        };
    }

    /**
     * Visit a parse tree produced by the {@code eqExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitEqExpression(FunxParser.EqExpressionContext ctx) {
        ASTNode left = visit(ctx.expression(0));
        ASTNode right = visit(ctx.expression(1));
        return switch (ctx.bop.getType()) {
            case FunxLexer.EqualsEquals -> new BinaryOperator.EqualsEquals(left, right);
            case FunxLexer.NotEquals -> new BinaryOperator.NotEquals(left, right);
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "equality operator");
        };
    }

    /**
     * Visit a parse tree produced by the {@code divModMultExpression}
     * labeled alternative in {@link FunxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitDivModMultExpression(FunxParser.DivModMultExpressionContext ctx) {
        ASTNode left = visit(ctx.expression(0));
        ASTNode right = visit(ctx.expression(1));
        return switch (ctx.bop.getType()) {
            case FunxLexer.Divide -> new BinaryOperator.Divide(left, right);
            case FunxLexer.Modulo -> new BinaryOperator.Modulo(left, right);
            case FunxLexer.Multiply -> new BinaryOperator.Multiply(left, right);
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "higher precedence arithmetic operator");
        };
    }

    /**
     * Visit a parse tree produced by the {@code parenPrimary}
     * labeled alternative in {@link FunxParser#primary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParenPrimary(FunxParser.ParenPrimaryContext ctx) {
        return new Primary.Parenthesized(visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by the {@code litPrimary}
     * labeled alternative in {@link FunxParser#primary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLitPrimary(FunxParser.LitPrimaryContext ctx) {
        return visit(ctx.literal());
    }

    /**
     * Visit a parse tree produced by the {@code funPrimary}
     * labeled alternative in {@link FunxParser#primary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitFunPrimary(FunxParser.FunPrimaryContext ctx) {
        return new Primary.Fun(ctx.funId.getText());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#lambda}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLambda(FunxParser.LambdaContext ctx) {
        return new Statement.Lambda(visit(ctx.lambdaParams()), visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by the {@code paramLambda}
     * labeled alternative in {@link FunxParser#lambdaParams}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitParamLambda(FunxParser.ParamLambdaContext ctx) {
        return new Statement.Lambda.Param(ctx.FUNID().getText());
    }

    /**
     * Visit a parse tree produced by the {@code multiParamLambda}
     * labeled alternative in {@link FunxParser#lambdaParams}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitMultiParamLambda(FunxParser.MultiParamLambdaContext ctx) {
        return new Statement.Lambda.MultiParam(visit(ctx.lambdaParams(0)),
                visit(ctx.lambdaParams(1)));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#let}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLet(FunxParser.LetContext ctx) {
        return new Statement.Let(ctx.localFunctions().functions().function().stream()
                .map(this::visit).toList(),
                visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#ifS}.
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
     * Visit a parse tree produced by {@link FunxParser#literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitLiteral(FunxParser.LiteralContext ctx) {
        if (ctx.numLiteral() != null)
            return visit(ctx.numLiteral());
        return switch (ctx.start.getType()) {
            case FunxLexer.BOOL -> new Primary.Literal(Boolean.parseBoolean(ctx.BOOL().getText()));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "literal");
        };
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#numLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ASTNode visitNumLiteral(FunxParser.NumLiteralContext ctx) {
        return switch (ctx.start.getType()) {
            case FunxLexer.FLOAT -> new Primary.Literal(
                    Double.parseDouble(
                            ctx.FLOAT().getText().replaceAll("[()]", "")));
            case FunxLexer.INT -> new Primary.Literal(
                    Integer.parseInt(
                            ctx.INT().getText().replaceAll("[()]", "")));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "numeric literal");
        };
    }
}
