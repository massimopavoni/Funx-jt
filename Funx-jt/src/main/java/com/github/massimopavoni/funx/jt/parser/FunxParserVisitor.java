// Generated from FunxParser.g4 by ANTLR 4.13.1
package com.github.massimopavoni.funx.jt.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunxParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(FunxParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(FunxParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(FunxParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#declarationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationType(FunxParser.DeclarationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#localDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDeclarations(FunxParser.LocalDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrowType}
	 * labeled alternative in {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowType(FunxParser.ArrowTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenType}
	 * labeled alternative in {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenType(FunxParser.ParenTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type}
	 * labeled alternative in {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FunxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(FunxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaStatement}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaStatement(FunxParser.LambdaStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letStatement}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(FunxParser.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(FunxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code appExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppExpression(FunxParser.AppExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(FunxParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(FunxParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(FunxParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpression(FunxParser.CompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExpression(FunxParser.PrimExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divModMultExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivModMultExpression(FunxParser.DivModMultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(FunxParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(FunxParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenPrimary}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenPrimary(FunxParser.ParenPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constPrimary}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstPrimary(FunxParser.ConstPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varPrimary}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarPrimary(FunxParser.VarPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(FunxParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambdaParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParams(FunxParser.LambdaParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FunxParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#ifS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfS(FunxParser.IfSContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(FunxParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#numConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumConstant(FunxParser.NumConstantContext ctx);
}