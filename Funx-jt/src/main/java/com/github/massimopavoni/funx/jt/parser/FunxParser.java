// Generated from FunxParser.g4 by ANTLR 4.13.1
package com.github.massimopavoni.funx.jt.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FunxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, TAB=2, WS=3, COMMENT=4, MULTICOMMENT=5, ELSE=6, END=7, FI=8, 
		IF=9, IN=10, LET=11, OUT=12, THEN=13, WITH=14, TYPEID=15, FUNID=16, BOOLEAN=17, 
		FLOAT=18, INTEGER=19, Ampersand=20, Backslash=21, Bang=22, Colon=23, Dot=24, 
		Equals=25, Minus=26, Pipe=27, Plus=28, SemiColon=29, Slash=30, Star=31, 
		UnderScore=32, Arrow=33, DotArrow=34, OpenParen=35, CloseParen=36, OpenBracket=37, 
		CloseBracket=38, OpenBrace=39, CloseBrace=40, OpenJavaBrace=41, CloseJavaBrace=42, 
		CloseMultiComment=43, OpenMultiComment=44, SingleComment=45, JAVA=46;
	public static final int
		RULE_program = 0, RULE_functions = 1, RULE_function = 2, RULE_funType = 3, 
		RULE_typeElems = 4, RULE_typeTerm = 5, RULE_with = 6, RULE_localFunctions = 7, 
		RULE_expression = 8, RULE_parenthesizedEx = 9, RULE_literalEx = 10, RULE_applicationEx = 11, 
		RULE_applicationTerm = 12, RULE_lambdaEx = 13, RULE_lambdaElems = 14, 
		RULE_letEx = 15, RULE_ifEx = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "funType", "typeElems", "typeTerm", 
			"with", "localFunctions", "expression", "parenthesizedEx", "literalEx", 
			"applicationEx", "applicationTerm", "lambdaEx", "lambdaElems", "letEx", 
			"ifEx"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'else'", "'end'", "'fi'", "'if'", 
			"'in'", "'let'", "'out'", "'then'", "'with'", null, null, null, null, 
			null, "'&'", "'\\'", "'!'", "':'", "'.'", "'='", "'-'", "'|'", "'+'", 
			"';'", "'/'", "'*'", "'_'", "'->'", "'.>'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'{{#'", "'#}}'", "'./'", "'/.'", "'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "COMMENT", "MULTICOMMENT", "ELSE", "END", 
			"FI", "IF", "IN", "LET", "OUT", "THEN", "WITH", "TYPEID", "FUNID", "BOOLEAN", 
			"FLOAT", "INTEGER", "Ampersand", "Backslash", "Bang", "Colon", "Dot", 
			"Equals", "Minus", "Pipe", "Plus", "SemiColon", "Slash", "Star", "UnderScore", 
			"Arrow", "DotArrow", "OpenParen", "CloseParen", "OpenBracket", "CloseBracket", 
			"OpenBrace", "CloseBrace", "OpenJavaBrace", "CloseJavaBrace", "CloseMultiComment", 
			"OpenMultiComment", "SingleComment", "JAVA"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FunxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FunxParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			functions();
			setState(35);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			function();
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					match(NEWLINE);
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FUNID) {
						{
						setState(39);
						function();
						}
					}

					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public FunTypeContext funType() {
			return getRuleContext(FunTypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public TerminalNode Equals() { return getToken(FunxParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaElemsContext lambdaElems() {
			return getRuleContext(LambdaElemsContext.class,0);
		}
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			funType();
			setState(48);
			match(NEWLINE);
			setState(49);
			match(FUNID);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(50);
				lambdaElems(0);
				}
			}

			setState(53);
			match(Equals);
			setState(54);
			expression();
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(55);
				match(NEWLINE);
				setState(56);
				with();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunTypeContext extends ParserRuleContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public TerminalNode Colon() { return getToken(FunxParser.Colon, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public FunTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunTypeContext funType() throws RecognitionException {
		FunTypeContext _localctx = new FunTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(FUNID);
			setState(60);
			match(Colon);
			setState(61);
			typeElems(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeElemsContext extends ParserRuleContext {
		public TypeElemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeElems; }
	 
		public TypeElemsContext() { }
		public void copyFrom(TypeElemsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleTypeContext extends TypeElemsContext {
		public TypeTermContext typeTerm() {
			return getRuleContext(TypeTermContext.class,0);
		}
		public SingleTypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitSingleType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiTypeContext extends TypeElemsContext {
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(FunxParser.Arrow, 0); }
		public TypeTermContext typeTerm() {
			return getRuleContext(TypeTermContext.class,0);
		}
		public MultiTypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMultiType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeElemsContext typeElems() throws RecognitionException {
		return typeElems(0);
	}

	private TypeElemsContext typeElems(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeElemsContext _localctx = new TypeElemsContext(_ctx, _parentState);
		TypeElemsContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_typeElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(64);
			typeTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiTypeContext(new TypeElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeElems);
					setState(66);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(67);
					match(Arrow);
					setState(68);
					typeTerm();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTermContext extends ParserRuleContext {
		public TypeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTerm; }
	 
		public TypeTermContext() { }
		public void copyFrom(TypeTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends TypeTermContext {
		public TerminalNode TYPEID() { return getToken(FunxParser.TYPEID, 0); }
		public TypeContext(TypeTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenTypeContext extends TypeTermContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenTypeContext(TypeTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTermContext typeTerm() throws RecognitionException {
		TypeTermContext _localctx = new TypeTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeTerm);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPEID:
				_localctx = new TypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(TYPEID);
				}
				break;
			case OpenParen:
				_localctx = new ParenTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(OpenParen);
				setState(76);
				typeElems(0);
				setState(77);
				match(CloseParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WithContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(FunxParser.WITH, 0); }
		public LocalFunctionsContext localFunctions() {
			return getRuleContext(LocalFunctionsContext.class,0);
		}
		public TerminalNode OUT() { return getToken(FunxParser.OUT, 0); }
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(WITH);
			setState(82);
			localFunctions();
			setState(83);
			match(OUT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalFunctionsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public LocalFunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localFunctions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLocalFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalFunctionsContext localFunctions() throws RecognitionException {
		LocalFunctionsContext _localctx = new LocalFunctionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localFunctions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(NEWLINE);
			setState(86);
			functions();
			setState(87);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppContext extends ExpressionContext {
		public ApplicationExContext applicationEx() {
			return getRuleContext(ApplicationExContext.class,0);
		}
		public AppContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends ExpressionContext {
		public LambdaExContext lambdaEx() {
			return getRuleContext(LambdaExContext.class,0);
		}
		public LambdaContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends ExpressionContext {
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JavaContext extends ExpressionContext {
		public TerminalNode JAVA() { return getToken(FunxParser.JAVA, 0); }
		public JavaContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitJava(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends ExpressionContext {
		public LiteralExContext literalEx() {
			return getRuleContext(LiteralExContext.class,0);
		}
		public LitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExpressionContext {
		public LetExContext letEx() {
			return getRuleContext(LetExContext.class,0);
		}
		public LetContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExpressionContext {
		public IfExContext ifEx() {
			return getRuleContext(IfExContext.class,0);
		}
		public IfContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				literalEx();
				}
				break;
			case 2:
				_localctx = new AppContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				applicationEx(0);
				}
				break;
			case 3:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				lambdaEx();
				}
				break;
			case 4:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				letEx();
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				ifEx();
				}
				break;
			case 6:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				parenthesizedEx();
				}
				break;
			case 7:
				_localctx = new JavaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				match(JAVA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenthesizedExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenthesizedEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedExContext parenthesizedEx() throws RecognitionException {
		ParenthesizedExContext _localctx = new ParenthesizedExContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parenthesizedEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(OpenParen);
			setState(99);
			expression();
			setState(100);
			match(CloseParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExContext extends ParserRuleContext {
		public LiteralExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalEx; }
	 
		public LiteralExContext() { }
		public void copyFrom(LiteralExContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends LiteralExContext {
		public TerminalNode BOOLEAN() { return getToken(FunxParser.BOOLEAN, 0); }
		public BoolContext(LiteralExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends LiteralExContext {
		public TerminalNode FLOAT() { return getToken(FunxParser.FLOAT, 0); }
		public FloatContext(LiteralExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends LiteralExContext {
		public TerminalNode INTEGER() { return getToken(FunxParser.INTEGER, 0); }
		public IntContext(LiteralExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExContext literalEx() throws RecognitionException {
		LiteralExContext _localctx = new LiteralExContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literalEx);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(BOOLEAN);
				}
				break;
			case INTEGER:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(FLOAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationExContext extends ParserRuleContext {
		public ApplicationExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applicationEx; }
	 
		public ApplicationExContext() { }
		public void copyFrom(ApplicationExContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleAppContext extends ApplicationExContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public SingleAppContext(ApplicationExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitSingleApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenAppContext extends ApplicationExContext {
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public ParenAppContext(ApplicationExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiAppContext extends ApplicationExContext {
		public ApplicationExContext applicationEx() {
			return getRuleContext(ApplicationExContext.class,0);
		}
		public ApplicationTermContext applicationTerm() {
			return getRuleContext(ApplicationTermContext.class,0);
		}
		public MultiAppContext(ApplicationExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMultiApp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationExContext applicationEx() throws RecognitionException {
		return applicationEx(0);
	}

	private ApplicationExContext applicationEx(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ApplicationExContext _localctx = new ApplicationExContext(_ctx, _parentState);
		ApplicationExContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_applicationEx, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				_localctx = new SingleAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				match(FUNID);
				}
				break;
			case OpenParen:
				{
				_localctx = new ParenAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				parenthesizedEx();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiAppContext(new ApplicationExContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_applicationEx);
					setState(112);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(113);
					applicationTerm();
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationTermContext extends ParserRuleContext {
		public ApplicationTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applicationTerm; }
	 
		public ApplicationTermContext() { }
		public void copyFrom(ApplicationTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunTermContext extends ApplicationTermContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public FunTermContext(ApplicationTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitTermContext extends ApplicationTermContext {
		public LiteralExContext literalEx() {
			return getRuleContext(LiteralExContext.class,0);
		}
		public LitTermContext(ApplicationTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLitTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenTermContext extends ApplicationTermContext {
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public ParenTermContext(ApplicationTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationTermContext applicationTerm() throws RecognitionException {
		ApplicationTermContext _localctx = new ApplicationTermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_applicationTerm);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				_localctx = new FunTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(FUNID);
				}
				break;
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
				_localctx = new LitTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				literalEx();
				}
				break;
			case OpenParen:
				_localctx = new ParenTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				parenthesizedEx();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExContext extends ParserRuleContext {
		public TerminalNode Backslash() { return getToken(FunxParser.Backslash, 0); }
		public TerminalNode DotArrow() { return getToken(FunxParser.DotArrow, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaElemsContext lambdaElems() {
			return getRuleContext(LambdaElemsContext.class,0);
		}
		public LambdaExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambdaEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExContext lambdaEx() throws RecognitionException {
		LambdaExContext _localctx = new LambdaExContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lambdaEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(Backslash);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(125);
				lambdaElems(0);
				}
			}

			setState(128);
			match(DotArrow);
			setState(129);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaElemsContext extends ParserRuleContext {
		public LambdaElemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaElems; }
	 
		public LambdaElemsContext() { }
		public void copyFrom(LambdaElemsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiLambdaContext extends LambdaElemsContext {
		public LambdaElemsContext lambdaElems() {
			return getRuleContext(LambdaElemsContext.class,0);
		}
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public MultiLambdaContext(LambdaElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMultiLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleLambdaContext extends LambdaElemsContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public SingleLambdaContext(LambdaElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitSingleLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaElemsContext lambdaElems() throws RecognitionException {
		return lambdaElems(0);
	}

	private LambdaElemsContext lambdaElems(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LambdaElemsContext _localctx = new LambdaElemsContext(_ctx, _parentState);
		LambdaElemsContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lambdaElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleLambdaContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(132);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiLambdaContext(new LambdaElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lambdaElems);
					setState(134);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(135);
					match(FUNID);
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetExContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FunxParser.LET, 0); }
		public TerminalNode IN() { return getToken(FunxParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public LocalFunctionsContext localFunctions() {
			return getRuleContext(LocalFunctionsContext.class,0);
		}
		public LetExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLetEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExContext letEx() throws RecognitionException {
		LetExContext _localctx = new LetExContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_letEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(LET);
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				setState(142);
				function();
				}
				break;
			case NEWLINE:
				{
				setState(143);
				localFunctions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(146);
			match(IN);
			setState(147);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FunxParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode THEN() { return getToken(FunxParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(FunxParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(FunxParser.FI, 0); }
		public IfExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIfEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExContext ifEx() throws RecognitionException {
		IfExContext _localctx = new IfExContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(IF);
			setState(150);
			expression();
			setState(151);
			match(THEN);
			setState(152);
			expression();
			setState(153);
			match(ELSE);
			setState(154);
			expression();
			setState(155);
			match(FI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return typeElems_sempred((TypeElemsContext)_localctx, predIndex);
		case 11:
			return applicationEx_sempred((ApplicationExContext)_localctx, predIndex);
		case 14:
			return lambdaElems_sempred((LambdaElemsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeElems_sempred(TypeElemsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean applicationEx_sempred(ApplicationExContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lambdaElems_sempred(LambdaElemsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0005\u0001+\b\u0001\n\u0001"+
		"\f\u0001.\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00024\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004F\b\u0004\n\u0004\f\u0004I\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005P\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"a\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n"+
		"j\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bo\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000bs\b\u000b\n\u000b\f\u000bv\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0003\f{\b\f\u0001\r\u0001\r\u0003\r\u007f\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0089\b\u000e\n\u000e\f\u000e\u008c\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u0091\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0003\b\u0016\u001c\u0011"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \u0000\u0000\u00a1\u0000\"\u0001\u0000\u0000\u0000\u0002"+
		"%\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006;\u0001"+
		"\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000"+
		"\fQ\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010`\u0001"+
		"\u0000\u0000\u0000\u0012b\u0001\u0000\u0000\u0000\u0014i\u0001\u0000\u0000"+
		"\u0000\u0016n\u0001\u0000\u0000\u0000\u0018z\u0001\u0000\u0000\u0000\u001a"+
		"|\u0001\u0000\u0000\u0000\u001c\u0083\u0001\u0000\u0000\u0000\u001e\u008d"+
		"\u0001\u0000\u0000\u0000 \u0095\u0001\u0000\u0000\u0000\"#\u0003\u0002"+
		"\u0001\u0000#$\u0005\u0000\u0000\u0001$\u0001\u0001\u0000\u0000\u0000"+
		"%,\u0003\u0004\u0002\u0000&(\u0005\u0001\u0000\u0000\')\u0003\u0004\u0002"+
		"\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000"+
		"\u0000\u0000*&\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0003\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000/0\u0003\u0006\u0003\u000001\u0005\u0001"+
		"\u0000\u000013\u0005\u0010\u0000\u000024\u0003\u001c\u000e\u000032\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"56\u0005\u0019\u0000\u000069\u0003\u0010\b\u000078\u0005\u0001\u0000\u0000"+
		"8:\u0003\f\u0006\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":\u0005\u0001\u0000\u0000\u0000;<\u0005\u0010\u0000\u0000<=\u0005\u0017"+
		"\u0000\u0000=>\u0003\b\u0004\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0006"+
		"\u0004\uffff\uffff\u0000@A\u0003\n\u0005\u0000AG\u0001\u0000\u0000\u0000"+
		"BC\n\u0001\u0000\u0000CD\u0005!\u0000\u0000DF\u0003\n\u0005\u0000EB\u0001"+
		"\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000JP\u0005\u000f\u0000\u0000KL\u0005#\u0000\u0000LM\u0003\b\u0004"+
		"\u0000MN\u0005$\u0000\u0000NP\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000"+
		"\u0000OK\u0001\u0000\u0000\u0000P\u000b\u0001\u0000\u0000\u0000QR\u0005"+
		"\u000e\u0000\u0000RS\u0003\u000e\u0007\u0000ST\u0005\f\u0000\u0000T\r"+
		"\u0001\u0000\u0000\u0000UV\u0005\u0001\u0000\u0000VW\u0003\u0002\u0001"+
		"\u0000WX\u0005\u0001\u0000\u0000X\u000f\u0001\u0000\u0000\u0000Ya\u0003"+
		"\u0014\n\u0000Za\u0003\u0016\u000b\u0000[a\u0003\u001a\r\u0000\\a\u0003"+
		"\u001e\u000f\u0000]a\u0003 \u0010\u0000^a\u0003\u0012\t\u0000_a\u0005"+
		".\u0000\u0000`Y\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`[\u0001"+
		"\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000a\u0011\u0001\u0000"+
		"\u0000\u0000bc\u0005#\u0000\u0000cd\u0003\u0010\b\u0000de\u0005$\u0000"+
		"\u0000e\u0013\u0001\u0000\u0000\u0000fj\u0005\u0011\u0000\u0000gj\u0005"+
		"\u0013\u0000\u0000hj\u0005\u0012\u0000\u0000if\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000j\u0015\u0001\u0000"+
		"\u0000\u0000kl\u0006\u000b\uffff\uffff\u0000lo\u0005\u0010\u0000\u0000"+
		"mo\u0003\u0012\t\u0000nk\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000"+
		"ot\u0001\u0000\u0000\u0000pq\n\u0002\u0000\u0000qs\u0003\u0018\f\u0000"+
		"rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000u\u0017\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000w{\u0005\u0010\u0000\u0000x{\u0003\u0014\n\u0000y{\u0003"+
		"\u0012\t\u0000zw\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{\u0019\u0001\u0000\u0000\u0000|~\u0005\u0015\u0000"+
		"\u0000}\u007f\u0003\u001c\u000e\u0000~}\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\"\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082\u001b\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0006\u000e\uffff\uffff\u0000\u0084\u0085"+
		"\u0005\u0010\u0000\u0000\u0085\u008a\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\n\u0001\u0000\u0000\u0087\u0089\u0005\u0010\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u001d\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u0090\u0005"+
		"\u000b\u0000\u0000\u008e\u0091\u0003\u0004\u0002\u0000\u008f\u0091\u0003"+
		"\u000e\u0007\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0005"+
		"\n\u0000\u0000\u0093\u0094\u0003\u0010\b\u0000\u0094\u001f\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0005\t\u0000\u0000\u0096\u0097\u0003\u0010\b"+
		"\u0000\u0097\u0098\u0005\r\u0000\u0000\u0098\u0099\u0003\u0010\b\u0000"+
		"\u0099\u009a\u0005\u0006\u0000\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b"+
		"\u009c\u0005\b\u0000\u0000\u009c!\u0001\u0000\u0000\u0000\u000e(,39GO"+
		"`intz~\u008a\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}