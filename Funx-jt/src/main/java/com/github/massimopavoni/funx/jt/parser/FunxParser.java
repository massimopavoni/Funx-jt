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
		NEWLINE=1, TAB=2, WS=3, CloseMultiComment=4, OpenMultiComment=5, SingleComment=6, 
		COMMENT=7, MULTICOMMENT=8, ELSE=9, END=10, FI=11, IF=12, IN=13, LET=14, 
		OUT=15, THEN=16, WITH=17, TYPE=18, FUNID=19, BOOL=20, FLOAT=21, INT=22, 
		And=23, Or=24, Not=25, EqualsEquals=26, GreaterThan=27, GreaterThanEquals=28, 
		LessThan=29, LessThanEquals=30, NotEquals=31, Add=32, Divide=33, Modulo=34, 
		Multiply=35, Subtract=36, Backslash=37, Colon=38, Equals=39, UnderScore=40, 
		Arrow=41, OpenParen=42, CloseParen=43, OpenBracket=44, CloseBracket=45, 
		OpenBrace=46, CloseBrace=47;
	public static final int
		RULE_program = 0, RULE_functions = 1, RULE_function = 2, RULE_functionType = 3, 
		RULE_typeElems = 4, RULE_typeTerm = 5, RULE_localFunctions = 6, RULE_expression = 7, 
		RULE_parenthesizedEx = 8, RULE_applicationEx = 9, RULE_literalEx = 10, 
		RULE_lambdaEx = 11, RULE_lambdaElems = 12, RULE_letEx = 13, RULE_ifEx = 14, 
		RULE_boolEx = 15, RULE_comparison = 16, RULE_arithmeticEx = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "functionType", "typeElems", "typeTerm", 
			"localFunctions", "expression", "parenthesizedEx", "applicationEx", "literalEx", 
			"lambdaEx", "lambdaElems", "letEx", "ifEx", "boolEx", "comparison", "arithmeticEx"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'./'", "'/.'", "'//'", null, null, "'else'", 
			"'end'", "'fi'", "'if'", "'in'", "'let'", "'out'", "'then'", "'with'", 
			null, null, null, null, null, "'&&'", "'||'", "'!!'", "'=='", "'>'", 
			"'>='", "'<'", "'<='", "'!='", "'+'", "'/'", "'%'", "'*'", "'-'", "'\\'", 
			"':'", "'='", "'_'", "'->'", "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "CloseMultiComment", "OpenMultiComment", 
			"SingleComment", "COMMENT", "MULTICOMMENT", "ELSE", "END", "FI", "IF", 
			"IN", "LET", "OUT", "THEN", "WITH", "TYPE", "FUNID", "BOOL", "FLOAT", 
			"INT", "And", "Or", "Not", "EqualsEquals", "GreaterThan", "GreaterThanEquals", 
			"LessThan", "LessThanEquals", "NotEquals", "Add", "Divide", "Modulo", 
			"Multiply", "Subtract", "Backslash", "Colon", "Equals", "UnderScore", 
			"Arrow", "OpenParen", "CloseParen", "OpenBracket", "CloseBracket", "OpenBrace", 
			"CloseBrace"
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
			setState(36);
			functions();
			setState(37);
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
			setState(39);
			function();
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					match(NEWLINE);
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FUNID) {
						{
						setState(41);
						function();
						}
					}

					}
					} 
				}
				setState(48);
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
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
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
		public TerminalNode WITH() { return getToken(FunxParser.WITH, 0); }
		public LocalFunctionsContext localFunctions() {
			return getRuleContext(LocalFunctionsContext.class,0);
		}
		public TerminalNode OUT() { return getToken(FunxParser.OUT, 0); }
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
			setState(49);
			functionType();
			setState(50);
			match(NEWLINE);
			setState(51);
			match(FUNID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(52);
				lambdaElems(0);
				}
			}

			setState(55);
			match(Equals);
			setState(56);
			expression();
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(57);
				match(NEWLINE);
				setState(58);
				match(WITH);
				setState(59);
				localFunctions();
				setState(60);
				match(OUT);
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
	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public TerminalNode Colon() { return getToken(FunxParser.Colon, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(FUNID);
			setState(65);
			match(Colon);
			setState(66);
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

			setState(69);
			typeTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
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
					setState(71);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(72);
					match(Arrow);
					setState(73);
					typeTerm();
					}
					} 
				}
				setState(78);
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
	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends TypeTermContext {
		public TerminalNode TYPE() { return getToken(FunxParser.TYPE, 0); }
		public TypeContext(TypeTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTermContext typeTerm() throws RecognitionException {
		TypeTermContext _localctx = new TypeTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeTerm);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				_localctx = new ParenTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(OpenParen);
				setState(80);
				typeElems(0);
				setState(81);
				match(CloseParen);
				}
				break;
			case TYPE:
				_localctx = new TypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(TYPE);
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
		enterRule(_localctx, 12, RULE_localFunctions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(NEWLINE);
			setState(87);
			functions();
			setState(88);
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
	public static class ArithContext extends ExpressionContext {
		public ArithmeticExContext arithmeticEx() {
			return getRuleContext(ArithmeticExContext.class,0);
		}
		public ArithContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitArith(this);
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
	public static class BoolContext extends ExpressionContext {
		public BoolExContext boolEx() {
			return getRuleContext(BoolExContext.class,0);
		}
		public BoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBool(this);
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
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				parenthesizedEx();
				}
				break;
			case 2:
				_localctx = new AppContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				applicationEx(0);
				}
				break;
			case 3:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				lambdaEx();
				}
				break;
			case 4:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				letEx();
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				ifEx();
				}
				break;
			case 6:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				boolEx(0);
				}
				break;
			case 7:
				_localctx = new ArithContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				arithmeticEx(0);
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
		enterRule(_localctx, 16, RULE_parenthesizedEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(OpenParen);
			setState(100);
			expression();
			setState(101);
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
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public LiteralExContext literalEx() {
			return getRuleContext(LiteralExContext.class,0);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_applicationEx, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				{
				_localctx = new ParenAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(104);
				parenthesizedEx();
				}
				break;
			case FUNID:
				{
				_localctx = new SingleAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(FUNID);
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
					setState(108);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(112);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OpenParen:
						{
						setState(109);
						parenthesizedEx();
						}
						break;
					case FUNID:
						{
						setState(110);
						match(FUNID);
						}
						break;
					case BOOL:
					case FLOAT:
					case INT:
						{
						setState(111);
						literalEx();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
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
	public static class LiteralExContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(FunxParser.BOOL, 0); }
		public TerminalNode FLOAT() { return getToken(FunxParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(FunxParser.INT, 0); }
		public LiteralExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLiteralEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExContext literalEx() throws RecognitionException {
		LiteralExContext _localctx = new LiteralExContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literalEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class LambdaExContext extends ParserRuleContext {
		public TerminalNode Backslash() { return getToken(FunxParser.Backslash, 0); }
		public TerminalNode Arrow() { return getToken(FunxParser.Arrow, 0); }
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
		enterRule(_localctx, 22, RULE_lambdaEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(Backslash);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(122);
				lambdaElems(0);
				}
			}

			setState(125);
			match(Arrow);
			setState(126);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_lambdaElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleLambdaContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(129);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiLambdaContext(new LambdaElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lambdaElems);
					setState(131);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(132);
					match(FUNID);
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 26, RULE_letEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LET);
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				setState(139);
				function();
				}
				break;
			case NEWLINE:
				{
				setState(140);
				localFunctions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(143);
			match(IN);
			setState(144);
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
		enterRule(_localctx, 28, RULE_ifEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IF);
			setState(147);
			expression();
			setState(148);
			match(THEN);
			setState(149);
			expression();
			setState(150);
			match(ELSE);
			setState(151);
			expression();
			setState(152);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolExContext extends ParserRuleContext {
		public BoolExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolEx; }
	 
		public BoolExContext() { }
		public void copyFrom(BoolExContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitBoolContext extends BoolExContext {
		public TerminalNode BOOL() { return getToken(FunxParser.BOOL, 0); }
		public LitBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndBoolContext extends BoolExContext {
		public List<BoolExContext> boolEx() {
			return getRuleContexts(BoolExContext.class);
		}
		public BoolExContext boolEx(int i) {
			return getRuleContext(BoolExContext.class,i);
		}
		public TerminalNode And() { return getToken(FunxParser.And, 0); }
		public AndBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAndBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenBoolContext extends BoolExContext {
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public ParenBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotBoolContext extends BoolExContext {
		public TerminalNode Not() { return getToken(FunxParser.Not, 0); }
		public BoolExContext boolEx() {
			return getRuleContext(BoolExContext.class,0);
		}
		public NotBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNotBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunBoolContext extends BoolExContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public FunBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompBoolContext extends BoolExContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public CompBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitCompBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrBoolContext extends BoolExContext {
		public List<BoolExContext> boolEx() {
			return getRuleContexts(BoolExContext.class);
		}
		public BoolExContext boolEx(int i) {
			return getRuleContext(BoolExContext.class,i);
		}
		public TerminalNode Or() { return getToken(FunxParser.Or, 0); }
		public OrBoolContext(BoolExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitOrBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExContext boolEx() throws RecognitionException {
		return boolEx(0);
	}

	private BoolExContext boolEx(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExContext _localctx = new BoolExContext(_ctx, _parentState);
		BoolExContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_boolEx, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new ParenBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				parenthesizedEx();
				}
				break;
			case 2:
				{
				_localctx = new FunBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(FUNID);
				}
				break;
			case 3:
				{
				_localctx = new LitBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(BOOL);
				}
				break;
			case 4:
				{
				_localctx = new CompBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				comparison();
				}
				break;
			case 5:
				{
				_localctx = new NotBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(Not);
				setState(160);
				boolEx(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AndBoolContext(new BoolExContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolEx);
						setState(163);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(164);
						match(And);
						setState(165);
						boolEx(3);
						}
						break;
					case 2:
						{
						_localctx = new OrBoolContext(new BoolExContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolEx);
						setState(166);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(167);
						match(Or);
						setState(168);
						boolEx(2);
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class ComparisonContext extends ParserRuleContext {
		public TerminalNode EqualsEquals() { return getToken(FunxParser.EqualsEquals, 0); }
		public TerminalNode GreaterThan() { return getToken(FunxParser.GreaterThan, 0); }
		public TerminalNode GreaterThanEquals() { return getToken(FunxParser.GreaterThanEquals, 0); }
		public TerminalNode LessThan() { return getToken(FunxParser.LessThan, 0); }
		public TerminalNode LessThanEquals() { return getToken(FunxParser.LessThanEquals, 0); }
		public TerminalNode NotEquals() { return getToken(FunxParser.NotEquals, 0); }
		public List<ApplicationExContext> applicationEx() {
			return getRuleContexts(ApplicationExContext.class);
		}
		public ApplicationExContext applicationEx(int i) {
			return getRuleContext(ApplicationExContext.class,i);
		}
		public List<LiteralExContext> literalEx() {
			return getRuleContexts(LiteralExContext.class);
		}
		public LiteralExContext literalEx(int i) {
			return getRuleContext(LiteralExContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case OpenParen:
				{
				setState(174);
				applicationEx(0);
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				{
				setState(175);
				literalEx();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(178);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case OpenParen:
				{
				setState(179);
				applicationEx(0);
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				{
				setState(180);
				literalEx();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ArithmeticExContext extends ParserRuleContext {
		public ArithmeticExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticEx; }
	 
		public ArithmeticExContext() { }
		public void copyFrom(ArithmeticExContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunArithContext extends ArithmeticExContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public FunArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntArithContext extends ArithmeticExContext {
		public TerminalNode INT() { return getToken(FunxParser.INT, 0); }
		public IntArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIntArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenArithContext extends ArithmeticExContext {
		public ParenthesizedExContext parenthesizedEx() {
			return getRuleContext(ParenthesizedExContext.class,0);
		}
		public ParenArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatArithContext extends ArithmeticExContext {
		public TerminalNode FLOAT() { return getToken(FunxParser.FLOAT, 0); }
		public FloatArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFloatArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivModMultArithContext extends ArithmeticExContext {
		public List<ArithmeticExContext> arithmeticEx() {
			return getRuleContexts(ArithmeticExContext.class);
		}
		public ArithmeticExContext arithmeticEx(int i) {
			return getRuleContext(ArithmeticExContext.class,i);
		}
		public TerminalNode Divide() { return getToken(FunxParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(FunxParser.Modulo, 0); }
		public TerminalNode Multiply() { return getToken(FunxParser.Multiply, 0); }
		public DivModMultArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDivModMultArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubArithContext extends ArithmeticExContext {
		public List<ArithmeticExContext> arithmeticEx() {
			return getRuleContexts(ArithmeticExContext.class);
		}
		public ArithmeticExContext arithmeticEx(int i) {
			return getRuleContext(ArithmeticExContext.class,i);
		}
		public TerminalNode Add() { return getToken(FunxParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(FunxParser.Subtract, 0); }
		public AddSubArithContext(ArithmeticExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAddSubArith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExContext arithmeticEx() throws RecognitionException {
		return arithmeticEx(0);
	}

	private ArithmeticExContext arithmeticEx(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExContext _localctx = new ArithmeticExContext(_ctx, _parentState);
		ArithmeticExContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_arithmeticEx, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				{
				_localctx = new ParenArithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(184);
				parenthesizedEx();
				}
				break;
			case FUNID:
				{
				_localctx = new FunArithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(FUNID);
				}
				break;
			case FLOAT:
				{
				_localctx = new FloatArithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(FLOAT);
				}
				break;
			case INT:
				{
				_localctx = new IntArithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(196);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new DivModMultArithContext(new ArithmeticExContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticEx);
						setState(190);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(191);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(192);
						arithmeticEx(3);
						}
						break;
					case 2:
						{
						_localctx = new AddSubArithContext(new ArithmeticExContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticEx);
						setState(193);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(194);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						arithmeticEx(2);
						}
						break;
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return typeElems_sempred((TypeElemsContext)_localctx, predIndex);
		case 9:
			return applicationEx_sempred((ApplicationExContext)_localctx, predIndex);
		case 12:
			return lambdaElems_sempred((LambdaElemsContext)_localctx, predIndex);
		case 15:
			return boolEx_sempred((BoolExContext)_localctx, predIndex);
		case 17:
			return arithmeticEx_sempred((ArithmeticExContext)_localctx, predIndex);
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
			return precpred(_ctx, 1);
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
	private boolean boolEx_sempred(BoolExContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arithmeticEx_sempred(ArithmeticExContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00ca\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001"+
		"\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"K\b\u0004\n\u0004\f\u0004N\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005U\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tq\b\t\u0005\ts\b\t\n\t\f\tv\t\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0003\u000b|\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0086\b\f"+
		"\n\f\f\f\u0089\t\f\u0001\r\u0001\r\u0001\r\u0003\r\u008e\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a2\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u00aa\b\u000f\n\u000f\f\u000f\u00ad\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00b1\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00b6\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00bd\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00c5\b\u0011\n\u0011\f\u0011"+
		"\u00c8\t\u0011\u0001\u0011\u0000\u0005\b\u0012\u0018\u001e\"\u0012\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"\u0000\u0004\u0001\u0000\u0014\u0016\u0001\u0000\u001a\u001f"+
		"\u0001\u0000!#\u0002\u0000  $$\u00d7\u0000$\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u0006@\u0001"+
		"\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000"+
		"\fV\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010c\u0001"+
		"\u0000\u0000\u0000\u0012j\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000"+
		"\u0000\u0016y\u0001\u0000\u0000\u0000\u0018\u0080\u0001\u0000\u0000\u0000"+
		"\u001a\u008a\u0001\u0000\u0000\u0000\u001c\u0092\u0001\u0000\u0000\u0000"+
		"\u001e\u00a1\u0001\u0000\u0000\u0000 \u00b0\u0001\u0000\u0000\u0000\""+
		"\u00bc\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0000"+
		"\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\'.\u0003\u0004\u0002\u0000"+
		"(*\u0005\u0001\u0000\u0000)+\u0003\u0004\u0002\u0000*)\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,(\u0001\u0000"+
		"\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000012\u0003\u0006\u0003\u000023\u0005\u0001\u0000\u000035\u0005\u0013"+
		"\u0000\u000046\u0003\u0018\f\u000054\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000078\u0005\'\u0000\u00008>\u0003\u000e"+
		"\u0007\u00009:\u0005\u0001\u0000\u0000:;\u0005\u0011\u0000\u0000;<\u0003"+
		"\f\u0006\u0000<=\u0005\u000f\u0000\u0000=?\u0001\u0000\u0000\u0000>9\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?\u0005\u0001\u0000\u0000"+
		"\u0000@A\u0005\u0013\u0000\u0000AB\u0005&\u0000\u0000BC\u0003\b\u0004"+
		"\u0000C\u0007\u0001\u0000\u0000\u0000DE\u0006\u0004\uffff\uffff\u0000"+
		"EF\u0003\n\u0005\u0000FL\u0001\u0000\u0000\u0000GH\n\u0001\u0000\u0000"+
		"HI\u0005)\u0000\u0000IK\u0003\n\u0005\u0000JG\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000M\t\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0005*\u0000"+
		"\u0000PQ\u0003\b\u0004\u0000QR\u0005+\u0000\u0000RU\u0001\u0000\u0000"+
		"\u0000SU\u0005\u0012\u0000\u0000TO\u0001\u0000\u0000\u0000TS\u0001\u0000"+
		"\u0000\u0000U\u000b\u0001\u0000\u0000\u0000VW\u0005\u0001\u0000\u0000"+
		"WX\u0003\u0002\u0001\u0000XY\u0005\u0001\u0000\u0000Y\r\u0001\u0000\u0000"+
		"\u0000Zb\u0003\u0010\b\u0000[b\u0003\u0012\t\u0000\\b\u0003\u0016\u000b"+
		"\u0000]b\u0003\u001a\r\u0000^b\u0003\u001c\u000e\u0000_b\u0003\u001e\u000f"+
		"\u0000`b\u0003\"\u0011\u0000aZ\u0001\u0000\u0000\u0000a[\u0001\u0000\u0000"+
		"\u0000a\\\u0001\u0000\u0000\u0000a]\u0001\u0000\u0000\u0000a^\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000b\u000f"+
		"\u0001\u0000\u0000\u0000cd\u0005*\u0000\u0000de\u0003\u000e\u0007\u0000"+
		"ef\u0005+\u0000\u0000f\u0011\u0001\u0000\u0000\u0000gh\u0006\t\uffff\uffff"+
		"\u0000hk\u0003\u0010\b\u0000ik\u0005\u0013\u0000\u0000jg\u0001\u0000\u0000"+
		"\u0000ji\u0001\u0000\u0000\u0000kt\u0001\u0000\u0000\u0000lp\n\u0001\u0000"+
		"\u0000mq\u0003\u0010\b\u0000nq\u0005\u0013\u0000\u0000oq\u0003\u0014\n"+
		"\u0000pm\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000"+
		"\u0000\u0000qs\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000sv\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"u\u0013\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0007\u0000"+
		"\u0000\u0000x\u0015\u0001\u0000\u0000\u0000y{\u0005%\u0000\u0000z|\u0003"+
		"\u0018\f\u0000{z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}~\u0005)\u0000\u0000~\u007f\u0003\u000e\u0007\u0000"+
		"\u007f\u0017\u0001\u0000\u0000\u0000\u0080\u0081\u0006\f\uffff\uffff\u0000"+
		"\u0081\u0082\u0005\u0013\u0000\u0000\u0082\u0087\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\n\u0001\u0000\u0000\u0084\u0086\u0005\u0013\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0019\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0005\u000e\u0000\u0000\u008b\u008e\u0003\u0004\u0002\u0000\u008c"+
		"\u008e\u0003\f\u0006\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0005\r\u0000\u0000\u0090\u0091\u0003\u000e\u0007\u0000\u0091\u001b\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0005\f\u0000\u0000\u0093\u0094\u0003\u000e"+
		"\u0007\u0000\u0094\u0095\u0005\u0010\u0000\u0000\u0095\u0096\u0003\u000e"+
		"\u0007\u0000\u0096\u0097\u0005\t\u0000\u0000\u0097\u0098\u0003\u000e\u0007"+
		"\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u001d\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0006\u000f\uffff\uffff\u0000\u009b\u00a2\u0003\u0010"+
		"\b\u0000\u009c\u00a2\u0005\u0013\u0000\u0000\u009d\u00a2\u0005\u0014\u0000"+
		"\u0000\u009e\u00a2\u0003 \u0010\u0000\u009f\u00a0\u0005\u0019\u0000\u0000"+
		"\u00a0\u00a2\u0003\u001e\u000f\u0003\u00a1\u009a\u0001\u0000\u0000\u0000"+
		"\u00a1\u009c\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000"+
		"\u00a1\u009e\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000"+
		"\u00a2\u00ab\u0001\u0000\u0000\u0000\u00a3\u00a4\n\u0002\u0000\u0000\u00a4"+
		"\u00a5\u0005\u0017\u0000\u0000\u00a5\u00aa\u0003\u001e\u000f\u0003\u00a6"+
		"\u00a7\n\u0001\u0000\u0000\u00a7\u00a8\u0005\u0018\u0000\u0000\u00a8\u00aa"+
		"\u0003\u001e\u000f\u0002\u00a9\u00a3\u0001\u0000\u0000\u0000\u00a9\u00a6"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u001f"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1"+
		"\u0003\u0012\t\u0000\u00af\u00b1\u0003\u0014\n\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0007\u0001\u0000\u0000\u00b3\u00b6\u0003"+
		"\u0012\t\u0000\u00b4\u00b6\u0003\u0014\n\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6!\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0006\u0011\uffff\uffff\u0000\u00b8\u00bd\u0003\u0010"+
		"\b\u0000\u00b9\u00bd\u0005\u0013\u0000\u0000\u00ba\u00bd\u0005\u0015\u0000"+
		"\u0000\u00bb\u00bd\u0005\u0016\u0000\u0000\u00bc\u00b7\u0001\u0000\u0000"+
		"\u0000\u00bc\u00b9\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00c6\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\n\u0002\u0000\u0000\u00bf\u00c0\u0007\u0002\u0000\u0000"+
		"\u00c0\u00c5\u0003\"\u0011\u0003\u00c1\u00c2\n\u0001\u0000\u0000\u00c2"+
		"\u00c3\u0007\u0003\u0000\u0000\u00c3\u00c5\u0003\"\u0011\u0002\u00c4\u00be"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c5\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c7#\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u0015*.5>LTajpt{\u0087\u008d\u00a1\u00a9\u00ab\u00b0"+
		"\u00b5\u00bc\u00c4\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}