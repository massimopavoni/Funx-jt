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
	 * Visit a parse tree produced by the {@code singleType}
	 * labeled alternative in {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleType(FunxParser.SingleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiType}
	 * labeled alternative in {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiType(FunxParser.MultiTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenType}
	 * labeled alternative in {@link FunxParser#typeTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenType(FunxParser.ParenTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type}
	 * labeled alternative in {@link FunxParser#typeTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FunxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#localFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctions(FunxParser.LocalFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(FunxParser.ParenContext ctx);
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
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FunxParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arith}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith(FunxParser.ArithContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#parenthesizedEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedEx(FunxParser.ParenthesizedExContext ctx);
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
	 * Visit a parse tree produced by {@link FunxParser#literalEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralEx(FunxParser.LiteralExContext ctx);
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
	/**
	 * Visit a parse tree produced by the {@code litBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitBool(FunxParser.LitBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBool(FunxParser.AndBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenBool(FunxParser.ParenBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotBool(FunxParser.NotBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunBool(FunxParser.FunBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompBool(FunxParser.CompBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orBool}
	 * labeled alternative in {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBool(FunxParser.OrBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FunxParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunArith(FunxParser.FunArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntArith(FunxParser.IntArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenArith(FunxParser.ParenArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatArith(FunxParser.FloatArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divModMultArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivModMultArith(FunxParser.DivModMultArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubArith}
	 * labeled alternative in {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubArith(FunxParser.AddSubArithContext ctx);
}