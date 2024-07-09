package com.github.massimopavoni.funx.jt.parser;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.typesystem.InferenceEngine;
import com.github.massimopavoni.funx.jt.ast.typesystem.Scheme;
import com.github.massimopavoni.funx.jt.ast.typesystem.Type;
import com.github.massimopavoni.funx.jt.ast.typesystem.TypeFunction;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
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
     * Stack of types for the current declaration,
     * used to build the declaration type.
     */
    private final Deque<Type> currentDeclarationTypes = new ArrayDeque<>();
    /**
     * Map of type variables for the current declaration,
     * used for polymorphic type signatures.
     */
    private final Map<String, Type.Variable> declarationTypeVariables = new HashMap<>();

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
     * Convert a deque of parameters and an expression into a lambda chain.
     *
     * @param position   input position
     * @param params     deque of parameters
     * @param expression expression
     * @return first node of the lambda chain
     */
    private ASTNode createLambdaChain(InputPosition position, Deque<String> params, ASTNode expression) {
        if (params.size() == 1)
            return new Expression.Lambda(
                    position,
                    params.getFirst(),
                    expression);
        return new Expression.Lambda(
                position,
                params.pop(),
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
                                PreludeFunction.fromSymbol(symbol).id),
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
            // get the last module identifier token as module name and use the previous ones for the package name
            moduleName = ctx.MODULEID().getLast().getText();
            packageName = String.join(".",
                    ctx.MODULEID().stream()
                            .limit((long) ctx.MODULEID().size() - 1)
                            .map(ParseTree::getText)
                            .toList());
        }
        InputPosition position = getInputPosition(ctx);
        FunxParser.MainContext mainContext = ctx.main();
        return new ASTNode.Module(
                position,
                moduleName,
                packageName,
                new Expression.Let(
                        position,
                        visit(ctx.declarations()),
                        // if there is no main function, return a constant null (boring type)
                        mainContext == null
                                ? new Expression.Constant(InputPosition.UNKNOWN, null)
                                : visit(ctx.main())));
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
        return visit(ctx.statement());
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
        // with means syntactic sugar for a let expression
        if (ctx.with() == null)
            statement = visit(ctx.statement());
        else
            statement = new Expression.Let(
                    position,
                    visit(ctx.with().localDeclarations().declarations()),
                    visit(ctx.statement()));
        // if there is a declaration type, create a scheme for it
        String typeId = null;
        Scheme scheme = null;
        if (ctx.declarationScheme() != null) {
            declarationTypeVariables.clear();
            FunxParser.DeclarationSchemeContext declarationTypeContext = ctx.declarationScheme();
            typeId = declarationTypeContext.id.getText();
            visit(declarationTypeContext);
            Type type = currentDeclarationTypes.pop();
            scheme = new Scheme(type.freeVariables(), type);
        }
        return new Declaration(
                position, typeId, scheme,
                ctx.id.getText(),
                // lambda params are syntactic sugar for a lambda chain
                ctx.lambdaParams() == null
                        ? statement
                        : createLambdaChain(position,
                        ctx.lambdaParams().VARID().stream()
                                .map(ParseTree::getText)
                                .collect(Collectors.toCollection(ArrayDeque::new)), statement));
    }

    /**
     * Visit a parse tree produced by {@link FunxParser#declarationScheme()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitDeclarationScheme(FunxParser.DeclarationSchemeContext ctx) {
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
        visit(ctx.typeElems(0));
        Type input = currentDeclarationTypes.pop();
        visit(ctx.typeElems(1));
        currentDeclarationTypes.add(Type.FunctionApplication.arrowOf(
                input, currentDeclarationTypes.pop()));
        return null;
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
     * Visit a parse tree produced by the {@code typeVar}
     * labeled alternative in {@link FunxParser#typeElems()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitTypeVar(FunxParser.TypeVarContext ctx) {
        // use same type variable for the same variable identifier already encountered within the type
        Type.Variable typeVariable = declarationTypeVariables.get(ctx.VARID().getText());
        if (typeVariable == null) {
            typeVariable = InferenceEngine.newTypeVariable();
            declarationTypeVariables.put(ctx.VARID().getText(), typeVariable);
        }
        currentDeclarationTypes.add(typeVariable);
        return null;
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
        currentDeclarationTypes.add(new Type.FunctionApplication(
                TypeFunction.fromId(ctx.TYPE().getText()),
                Collections.emptyList()));
        return null;
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
     * Visit a parse tree produced by the {@code composeExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitComposeExpression(FunxParser.ComposeExpressionContext ctx) {
        return binarySymbolApplication(
                getInputPosition(ctx),
                Utils.fromLexerToken(ctx.bop.getType()),
                visit(ctx.expression(0)),
                visit(ctx.expression(1)));
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
                Utils.fromLexerToken(ctx.bop.getType()),
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
                Utils.fromLexerToken(ctx.bop.getType()),
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
                Utils.fromLexerToken(ctx.bop.getType()),
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
                Utils.fromLexerToken(ctx.bop.getType()),
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
                        PreludeFunction.NOT.id),
                visit(ctx.expression()));
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
        // transform logical conjunction into if statement for short-circuiting behavior
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
        // transform logical disjunction into if statement for short-circuiting behavior
        return new Expression.If(
                getInputPosition(ctx),
                visit(ctx.expression(0)),
                new Expression.Constant(InputPosition.UNKNOWN, true),
                visit(ctx.expression(1)));
    }

    /**
     * Visit a parse tree produced by the {@code rightAppExpression}
     * labeled alternative in {@link FunxParser#expression()}.
     *
     * @param ctx the parse tree
     * @return visitor result
     */
    @Override
    public ASTNode visitRightAppExpression(FunxParser.RightAppExpressionContext ctx) {
        return new Expression.Application(
                getInputPosition(ctx),
                visit(ctx.expression(0)),
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
                // lambda params are syntactic sugar for a lambda chain
                ctx.lambdaParams().VARID().stream()
                        .map(ParseTree::getText)
                        .collect(Collectors.toCollection(ArrayDeque::new)), visit(ctx.statement()));
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
            // default case should never be reached
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
                    // remove parentheses from negative numbers
                    Long.parseLong(
                            ctx.INT().getText().replaceAll("[()]", "")));
            // default case should never be reached
            default -> throw new IllegalParserStateException(ctx, "numeric constant");
        };
    }
}

