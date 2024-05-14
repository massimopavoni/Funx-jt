package com.github.massimopavoni.funx.jt.parser;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.TypeEnum;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.node.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse tree visitor used to build the program's AST.
 */
public class ASTBuilder extends FunxParserBaseVisitor<ASTNode> {
    /**
     * Name of the file being parsed.
     */
    private final String fileName;

    /**
     * Constructor for the AST builder.
     *
     * @param fileName name of the file being parsed
     */
    public ASTBuilder(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the input position from the start of a parser context.
     *
     * @param ctx parser context
     * @return input position
     */
    private static InputPosition getInputPosition(ParserRuleContext ctx) {
        return new InputPosition(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine() + 1);
    }

    /**
     * Convert a list of parameters and an expression into a lambda chain.
     *
     * @param position   input position
     * @param params     list of parameters
     * @param expression expression
     * @return first node of the lambda chain
     */
    private ASTNode createLambdaChain(InputPosition position, List<String> params, ASTNode expression) {
        if (params.size() == 1)
            return new Expression.Lambda(
                    position,
                    params.getFirst(),
                    expression);
        return new Expression.Lambda(
                position,
                params.removeFirst(),
                createLambdaChain(position, params, expression));
    }

    /**
     * Create a double application from a binary operator,
     * retrieving the Prelude function name from the used symbol.
     *
     * @param position input position
     * @param symbol   operator symbol
     * @param left     left node
     * @param right    right node
     * @return double application node
     */
    private ASTNode binarySymbolApplication(InputPosition position, String symbol, ASTNode left, ASTNode right) {
        return new Expression.Application(
                position,
                new Expression.Application(
                        position,
                        new Expression.Variable(
                                position,
                                PreludeFunction.fromFunctionSymbol(symbol).functionName),
                        left),
                right);
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#module()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitModule(FunxParser.ModuleContext ctx) {
        String moduleName;
        String packageName;
        if (ctx.MODULE() == null) {
            moduleName = fileName;
            packageName = "";
        } else {
            moduleName = ctx.MODULEID().getLast().getText();
            packageName = String.join(".",
                    ctx.MODULEID().stream()
                            .limit(ctx.MODULEID().size() - 1)
                            .map(ParseTree::getText)
                            .toList());
        }
        return new ASTNode.Module(
                getInputPosition(ctx),
                moduleName,
                packageName,
                ctx.main() == null ? null : visit(ctx.main()),
                visit(ctx.declarations()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declarations()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitDeclarations(FunxParser.DeclarationsContext ctx) {
        return new ASTNode.Declarations(
                getInputPosition(ctx),
                ctx.declaration().stream()
                        .map(this::visit).toList());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#main()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitMain(FunxParser.MainContext ctx) {
        return new Declaration(
                getInputPosition(ctx),
                ctx.MAIN().getText(),
                null,
                ctx.MAIN().getText(),
                visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declaration()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitDeclaration(FunxParser.DeclarationContext ctx) {
        InputPosition position = getInputPosition(ctx);
        ASTNode statement;
        if (ctx.with() == null)
            statement = visit(ctx.statement());
        else
            statement = new Expression.Let(
                    position,
                    visit(ctx.with().localDeclarations().declarations()),
                    visit(ctx.statement()));
        FunxParser.DeclarationTypeContext declarationTypeContext = ctx.declarationType();
        return new Declaration(
                position,
                declarationTypeContext.id.getText(),
                visit(declarationTypeContext),
                ctx.id.getText(),
                ctx.lambdaParams() == null
                        ? statement
                        : createLambdaChain(position,
                        ctx.lambdaParams().VARID().stream()
                                .map(ParseTree::getText)
                                .collect(Collectors.toCollection(ArrayList::new)), statement));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declarationType()}.
     *
     * @param ctx the parse tree
     * @return visitor result
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
     * @return visitor result
     */
    @Override
    public ASTNode visitArrowType(FunxParser.ArrowTypeContext ctx) {
        return new Type.ArrowType(
                visit(ctx.typeElems(0)),
                visit(ctx.typeElems(1)));
    }

    /**
     * Visit a parse tree produced by the {@code parenType}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitParenType(FunxParser.ParenTypeContext ctx) {
        return visit(ctx.typeElems());
    }

    /**
     * Visit a parse tree produced by the {@code namedType}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitNamedType(FunxParser.NamedTypeContext ctx) {
        return new Type.NamedType(
                TypeEnum.fromTypeName(ctx.TYPE().getText()));
    }

    /**
     * Visit a parse tree produced by the {@code expressionStatement}
     * labeled alternative in {@link FunxParser#statement()}.
     *
     * @param ctx the parse tree
     * @return visitor result
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
     * @return visitor result
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
     * @return visitor result
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
     * @return visitor result
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
     * @return visitor result
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
     * @return visitor result
     */
    @Override
    public ASTNode visitAppExpression(FunxParser.AppExpressionContext ctx) {
        return new Expression.Application(
                getInputPosition(ctx),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code notExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitNotExpression(FunxParser.NotExpressionContext ctx) {
        InputPosition position = getInputPosition(ctx);
        return new Expression.Application(position,
                new Expression.Variable(
                        position,
                        PreludeFunction.NOT.functionName),
                visit(ctx.expression()));
    }

    /**
     * Visit a parse tree produced by the {@code divModMultExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitDivModMultExpression(FunxParser.DivModMultExpressionContext ctx) {
        return binarySymbolApplication(
                getInputPosition(ctx),
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code addSubExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitAddSubExpression(FunxParser.AddSubExpressionContext ctx) {
        return binarySymbolApplication(
                getInputPosition(ctx),
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code compExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitCompExpression(FunxParser.CompExpressionContext ctx) {
        return binarySymbolApplication(
                getInputPosition(ctx),
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code eqExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitEqExpression(FunxParser.EqExpressionContext ctx) {
        return binarySymbolApplication(
                getInputPosition(ctx),
                ASTNode.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code andExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitAndExpression(FunxParser.AndExpressionContext ctx) {
        // Transform logical conjunction into if statement for short-circuiting behavior
        return new Expression.If(
                getInputPosition(ctx),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)),
                new Expression.Constant(InputPosition.UNKNOWN, false));
    }

    /**
     * Visit a parse tree produced by the {@code orExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitOrExpression(FunxParser.OrExpressionContext ctx) {
        // Transform logical disjunction into if statement for short-circuiting behavior
        return new Expression.If(
                getInputPosition(ctx),
                visit(ctx.expression(0)),
                new Expression.Constant(InputPosition.UNKNOWN, true),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code parenPrimary}
     * labeled alternative in {@link FunxParser#primary()}.
     *
     * @param ctx the parse tree
     * @return visitor result
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
     * @return visitor result
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
     * @return visitor result
     */
    @Override
    public ASTNode visitVarPrimary(FunxParser.VarPrimaryContext ctx) {
        return new Expression.Variable(
                getInputPosition(ctx),
                ctx.VARID().getText());
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#lambda()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitLambda(FunxParser.LambdaContext ctx) {
        return createLambdaChain(
                getInputPosition(ctx),
                ctx.lambdaParams().VARID().stream()
                        .map(ParseTree::getText)
                        .toList(), visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#let()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitLet(FunxParser.LetContext ctx) {
        return new Expression.Let(
                getInputPosition(ctx),
                visit(ctx.localDeclarations().declarations()),
                visit(ctx.statement()));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#ifS()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitIfS(FunxParser.IfSContext ctx) {
        return new Expression.If(
                getInputPosition(ctx),
                visit(ctx.statement(0)),
                visit(ctx.statement(1)),
                visit(ctx.statement(2)));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#constant()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitConstant(FunxParser.ConstantContext ctx) {
        if (ctx.numConstant() != null)
            return visit(ctx.numConstant());
        InputPosition position = getInputPosition(ctx);
        return switch (ctx.start.getType()) {
            case FunxLexer.BOOL -> new Expression.Constant(
                    position,
                    Boolean.parseBoolean(ctx.BOOL().getText()));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "constant");
        };
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#numConstant()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitNumConstant(FunxParser.NumConstantContext ctx) {
        InputPosition position = getInputPosition(ctx);
        return switch (ctx.start.getType()) {
            case FunxLexer.INT -> new Expression.Constant(
                    position,
                    Integer.parseInt(
                            ctx.INT().getText().replaceAll("[()]", "")));
            // Default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "numeric constant");
        };
    }
}

