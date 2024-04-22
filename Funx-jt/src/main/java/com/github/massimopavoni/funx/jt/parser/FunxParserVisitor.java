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
	 * Visit a parse tree produced by {@link FunxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FunxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(FunxParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FunxParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(FunxParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#localFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctions(FunxParser.LocalFunctionsContext ctx);
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
	 * Visit a parse tree produced by the {@code ex}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx(FunxParser.ExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaSt}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaSt(FunxParser.LambdaStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letSt}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetSt(FunxParser.LetStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSt}
	 * labeled alternative in {@link FunxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSt(FunxParser.IfStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code app}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp(FunxParser.AppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comp}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(FunxParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prim}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrim(FunxParser.PrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(FunxParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(FunxParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(FunxParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(FunxParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(FunxParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divModMult}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivModMult(FunxParser.DivModMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(FunxParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lit}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(FunxParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun}
	 * labeled alternative in {@link FunxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(FunxParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(FunxParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambdaElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaElems(FunxParser.LambdaElemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FunxParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(FunxParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FunxParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#numLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(FunxParser.NumLiteralContext ctx);
}