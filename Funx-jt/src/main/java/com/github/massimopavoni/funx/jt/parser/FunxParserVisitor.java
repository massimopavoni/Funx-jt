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
	 * Visit a parse tree produced by {@link FunxParser#with}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(FunxParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#localFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctions(FunxParser.LocalFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lit}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(FunxParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code app}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp(FunxParser.AppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambda}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(FunxParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FunxParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(FunxParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(FunxParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code java}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJava(FunxParser.JavaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#parenthesizedEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedEx(FunxParser.ParenthesizedExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FunxParser#literalEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FunxParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FunxParser#literalEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(FunxParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link FunxParser#literalEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(FunxParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleApp}
	 * labeled alternative in {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleApp(FunxParser.SingleAppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenApp}
	 * labeled alternative in {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenApp(FunxParser.ParenAppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiApp}
	 * labeled alternative in {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiApp(FunxParser.MultiAppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funTerm}
	 * labeled alternative in {@link FunxParser#applicationTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunTerm(FunxParser.FunTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litTerm}
	 * labeled alternative in {@link FunxParser#applicationTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitTerm(FunxParser.LitTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link FunxParser#applicationTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTerm(FunxParser.ParenTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambdaEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaEx(FunxParser.LambdaExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiLambda}
	 * labeled alternative in {@link FunxParser#lambdaElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLambda(FunxParser.MultiLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleLambda}
	 * labeled alternative in {@link FunxParser#lambdaElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleLambda(FunxParser.SingleLambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#letEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetEx(FunxParser.LetExContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#ifEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfEx(FunxParser.IfExContext ctx);
}