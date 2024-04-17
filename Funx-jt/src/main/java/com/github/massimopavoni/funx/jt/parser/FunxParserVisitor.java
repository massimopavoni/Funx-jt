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
	 * Visit a parse tree produced by {@link FunxParser#typeElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeElems(FunxParser.TypeElemsContext ctx);
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
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(FunxParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FunxParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambda}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(FunxParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code app}
	 * labeled alternative in {@link FunxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp(FunxParser.AppContext ctx);
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
	 * Visit a parse tree produced by {@link FunxParser#parenOrFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenOrFun(FunxParser.ParenOrFunContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#applicationEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationEx(FunxParser.ApplicationExContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#multiApplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiApplication(FunxParser.MultiApplicationContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambdaEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaEx(FunxParser.LambdaExContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#lambdaElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaElems(FunxParser.LambdaElemsContext ctx);
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
	 * Visit a parse tree produced by {@link FunxParser#boolEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolEx(FunxParser.BoolExContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#boolOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOr(FunxParser.BoolOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTerm(FunxParser.BoolTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#boolAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAnd(FunxParser.BoolAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleBool}
	 * labeled alternative in {@link FunxParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleBool(FunxParser.SimpleBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notBool}
	 * labeled alternative in {@link FunxParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotBool(FunxParser.NotBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litBool}
	 * labeled alternative in {@link FunxParser#boolPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitBool(FunxParser.LitBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compBool}
	 * labeled alternative in {@link FunxParser#boolPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompBool(FunxParser.CompBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code appParenBool}
	 * labeled alternative in {@link FunxParser#boolPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppParenBool(FunxParser.AppParenBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FunxParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#arithmeticEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticEx(FunxParser.ArithmeticExContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#addSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(FunxParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#arithmeticTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticTerm(FunxParser.ArithmeticTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunxParser#divModMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivModMult(FunxParser.DivModMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litArith}
	 * labeled alternative in {@link FunxParser#arithmeticFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitArith(FunxParser.LitArithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code appParenArith}
	 * labeled alternative in {@link FunxParser#arithmeticFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppParenArith(FunxParser.AppParenArithContext ctx);
}