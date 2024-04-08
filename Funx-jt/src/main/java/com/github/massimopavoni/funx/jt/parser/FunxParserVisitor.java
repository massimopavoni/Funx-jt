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
	 * Visit a parse tree produced by {@link FunxParser#funend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunend(FunxParser.FunendContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#with}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(FunxParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(FunxParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code application}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(FunxParser.ApplicationContext ctx);
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
	 * Visit a parse tree produced by the {@code parenthesized}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesized(FunxParser.ParenthesizedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FunxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FunxParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link FunxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(FunxParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floating}
	 * labeled alternative in {@link FunxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloating(FunxParser.FloatingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleApplication}
	 * labeled alternative in {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleApplication(FunxParser.SingleApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiApplication}
	 * labeled alternative in {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiApplication(FunxParser.MultiApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funTerm}
	 * labeled alternative in {@link FunxParser#applicationTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunTerm(FunxParser.FunTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalTerm}
	 * labeled alternative in {@link FunxParser#applicationTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralTerm(FunxParser.LiteralTermContext ctx);
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
	 * Visit a parse tree produced by {@link FunxParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(FunxParser.EndContext ctx);
}