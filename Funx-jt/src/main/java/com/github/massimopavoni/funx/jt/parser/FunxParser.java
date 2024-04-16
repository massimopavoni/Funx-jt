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
		IF=9, IN=10, LET=11, OUT=12, THEN=13, WITH=14, TYPE=15, FUNID=16, BOOLEAN=17, 
		FLOAT=18, INTEGER=19, Ampersand=20, Backslash=21, Bang=22, Colon=23, Dot=24, 
		Equals=25, Minus=26, Pipe=27, Plus=28, SemiColon=29, Slash=30, Star=31, 
		UnderScore=32, DotArrow=33, OpenParen=34, CloseParen=35, OpenBracket=36, 
		CloseBracket=37, OpenBrace=38, CloseBrace=39, OpenJavaBrace=40, CloseJavaBrace=41, 
		CloseMultiComment=42, OpenMultiComment=43, SingleComment=44, JAVA=45;
	public static final int
		RULE_program = 0, RULE_functions = 1, RULE_function = 2, RULE_with = 3, 
		RULE_localFunctions = 4, RULE_expression = 5, RULE_parenthesizedEx = 6, 
		RULE_literalEx = 7, RULE_applicationEx = 8, RULE_applicationTerm = 9, 
		RULE_lambdaEx = 10, RULE_lambdaElems = 11, RULE_letEx = 12, RULE_ifEx = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "with", "localFunctions", "expression", 
			"parenthesizedEx", "literalEx", "applicationEx", "applicationTerm", "lambdaEx", 
			"lambdaElems", "letEx", "ifEx"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'else'", "'end'", "'fi'", "'if'", 
			"'in'", "'let'", "'out'", "'then'", "'with'", null, null, null, null, 
			null, "'&'", "'\\'", "'!'", "':'", "'.'", "'='", "'-'", "'|'", "'+'", 
			"';'", "'/'", "'*'", "'_'", "'.>'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'{{#'", "'#}}'", "'./'", "'/.'", "'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "COMMENT", "MULTICOMMENT", "ELSE", "END", 
			"FI", "IF", "IN", "LET", "OUT", "THEN", "WITH", "TYPE", "FUNID", "BOOLEAN", 
			"FLOAT", "INTEGER", "Ampersand", "Backslash", "Bang", "Colon", "Dot", 
			"Equals", "Minus", "Pipe", "Plus", "SemiColon", "Slash", "Star", "UnderScore", 
			"DotArrow", "OpenParen", "CloseParen", "OpenBracket", "CloseBracket", 
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
			setState(28);
			functions();
			setState(29);
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
			setState(31);
			function();
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					match(NEWLINE);
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FUNID) {
						{
						setState(33);
						function();
						}
					}

					}
					} 
				}
				setState(40);
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
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public TerminalNode Equals() { return getToken(FunxParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaElemsContext lambdaElems() {
			return getRuleContext(LambdaElemsContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
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
			setState(41);
			match(FUNID);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(42);
				lambdaElems(0);
				}
			}

			setState(45);
			match(Equals);
			setState(46);
			expression();
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(47);
				match(NEWLINE);
				setState(48);
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
		enterRule(_localctx, 6, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(WITH);
			setState(52);
			localFunctions();
			setState(53);
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
		enterRule(_localctx, 8, RULE_localFunctions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(NEWLINE);
			setState(56);
			functions();
			setState(57);
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
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new LitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				literalEx();
				}
				break;
			case 2:
				_localctx = new AppContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				applicationEx(0);
				}
				break;
			case 3:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				lambdaEx();
				}
				break;
			case 4:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				letEx();
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				ifEx();
				}
				break;
			case 6:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				parenthesizedEx();
				}
				break;
			case 7:
				_localctx = new JavaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
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
		enterRule(_localctx, 12, RULE_parenthesizedEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(OpenParen);
			setState(69);
			expression();
			setState(70);
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
		enterRule(_localctx, 14, RULE_literalEx);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(BOOLEAN);
				}
				break;
			case INTEGER:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(INTEGER);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_applicationEx, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				_localctx = new SingleAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				match(FUNID);
				}
				break;
			case OpenParen:
				{
				_localctx = new ParenAppContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				parenthesizedEx();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiAppContext(new ApplicationExContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_applicationEx);
					setState(82);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(83);
					applicationTerm();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 18, RULE_applicationTerm);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				_localctx = new FunTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(FUNID);
				}
				break;
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
				_localctx = new LitTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				literalEx();
				}
				break;
			case OpenParen:
				_localctx = new ParenTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
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
		enterRule(_localctx, 20, RULE_lambdaEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(Backslash);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(95);
				lambdaElems(0);
				}
			}

			setState(98);
			match(DotArrow);
			setState(99);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_lambdaElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleLambdaContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(102);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiLambdaContext(new LambdaElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lambdaElems);
					setState(104);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(105);
					match(FUNID);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 24, RULE_letEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LET);
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				setState(112);
				function();
				}
				break;
			case NEWLINE:
				{
				setState(113);
				localFunctions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(116);
			match(IN);
			setState(117);
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
		enterRule(_localctx, 26, RULE_ifEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IF);
			setState(120);
			expression();
			setState(121);
			match(THEN);
			setState(122);
			expression();
			setState(123);
			match(ELSE);
			setState(124);
			expression();
			setState(125);
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
		case 8:
			return applicationEx_sempred((ApplicationExContext)_localctx, predIndex);
		case 11:
			return lambdaElems_sempred((LambdaElemsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean applicationEx_sempred(ApplicationExContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lambdaElems_sempred(LambdaElemsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0080\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001\u0005\u0001%\b\u0001\n\u0001"+
		"\f\u0001(\t\u0001\u0001\u0002\u0001\u0002\u0003\u0002,\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005C\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"L\b\u0007\u0001\b\u0001\b\u0001\b\u0003\bQ\b\b\u0001\b\u0001\b\u0005\b"+
		"U\b\b\n\b\f\bX\t\b\u0001\t\u0001\t\u0001\t\u0003\t]\b\t\u0001\n\u0001"+
		"\n\u0003\na\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000bk\b\u000b\n\u000b\f\u000bn\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0003\fs\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0000"+
		"\u0002\u0010\u0016\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0000\u0084\u0000\u001c\u0001\u0000\u0000"+
		"\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000"+
		"\u00063\u0001\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\nB\u0001\u0000"+
		"\u0000\u0000\fD\u0001\u0000\u0000\u0000\u000eK\u0001\u0000\u0000\u0000"+
		"\u0010P\u0001\u0000\u0000\u0000\u0012\\\u0001\u0000\u0000\u0000\u0014"+
		"^\u0001\u0000\u0000\u0000\u0016e\u0001\u0000\u0000\u0000\u0018o\u0001"+
		"\u0000\u0000\u0000\u001aw\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002"+
		"\u0001\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f&\u0003\u0004\u0002\u0000 \"\u0005\u0001\u0000\u0000"+
		"!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#%\u0001\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000%(\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003"+
		"\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)+\u0005\u0010\u0000"+
		"\u0000*,\u0003\u0016\u000b\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0005\u0019\u0000\u0000.1\u0003"+
		"\n\u0005\u0000/0\u0005\u0001\u0000\u000002\u0003\u0006\u0003\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0005\u0001\u0000\u0000"+
		"\u000034\u0005\u000e\u0000\u000045\u0003\b\u0004\u000056\u0005\f\u0000"+
		"\u00006\u0007\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u000089\u0003"+
		"\u0002\u0001\u00009:\u0005\u0001\u0000\u0000:\t\u0001\u0000\u0000\u0000"+
		";C\u0003\u000e\u0007\u0000<C\u0003\u0010\b\u0000=C\u0003\u0014\n\u0000"+
		">C\u0003\u0018\f\u0000?C\u0003\u001a\r\u0000@C\u0003\f\u0006\u0000AC\u0005"+
		"-\u0000\u0000B;\u0001\u0000\u0000\u0000B<\u0001\u0000\u0000\u0000B=\u0001"+
		"\u0000\u0000\u0000B>\u0001\u0000\u0000\u0000B?\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000C\u000b\u0001\u0000"+
		"\u0000\u0000DE\u0005\"\u0000\u0000EF\u0003\n\u0005\u0000FG\u0005#\u0000"+
		"\u0000G\r\u0001\u0000\u0000\u0000HL\u0005\u0011\u0000\u0000IL\u0005\u0013"+
		"\u0000\u0000JL\u0005\u0012\u0000\u0000KH\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u000f\u0001\u0000\u0000"+
		"\u0000MN\u0006\b\uffff\uffff\u0000NQ\u0005\u0010\u0000\u0000OQ\u0003\f"+
		"\u0006\u0000PM\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QV\u0001"+
		"\u0000\u0000\u0000RS\n\u0002\u0000\u0000SU\u0003\u0012\t\u0000TR\u0001"+
		"\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000W\u0011\u0001\u0000\u0000\u0000XV\u0001\u0000"+
		"\u0000\u0000Y]\u0005\u0010\u0000\u0000Z]\u0003\u000e\u0007\u0000[]\u0003"+
		"\f\u0006\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\"+
		"[\u0001\u0000\u0000\u0000]\u0013\u0001\u0000\u0000\u0000^`\u0005\u0015"+
		"\u0000\u0000_a\u0003\u0016\u000b\u0000`_\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0005!\u0000\u0000cd\u0003"+
		"\n\u0005\u0000d\u0015\u0001\u0000\u0000\u0000ef\u0006\u000b\uffff\uffff"+
		"\u0000fg\u0005\u0010\u0000\u0000gl\u0001\u0000\u0000\u0000hi\n\u0001\u0000"+
		"\u0000ik\u0005\u0010\u0000\u0000jh\u0001\u0000\u0000\u0000kn\u0001\u0000"+
		"\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0017"+
		"\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000or\u0005\u000b\u0000"+
		"\u0000ps\u0003\u0004\u0002\u0000qs\u0003\b\u0004\u0000rp\u0001\u0000\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0005\n\u0000"+
		"\u0000uv\u0003\n\u0005\u0000v\u0019\u0001\u0000\u0000\u0000wx\u0005\t"+
		"\u0000\u0000xy\u0003\n\u0005\u0000yz\u0005\r\u0000\u0000z{\u0003\n\u0005"+
		"\u0000{|\u0005\u0006\u0000\u0000|}\u0003\n\u0005\u0000}~\u0005\b\u0000"+
		"\u0000~\u001b\u0001\u0000\u0000\u0000\f\"&+1BKPV\\`lr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}