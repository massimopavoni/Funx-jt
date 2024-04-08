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
		NEWLINE=1, TAB=2, WS=3, COMMENT=4, MULTICOMMENT=5, ELSE=6, END=7, IF=8, 
		IN=9, LET=10, THEN=11, WITH=12, FUNID=13, BOOLEAN=14, DECIMAL=15, EXPONENT=16, 
		FLOAT=17, Backslash=18, CloseMultiComment=19, Colon=20, Equals=21, OpenMultiComment=22, 
		SemiColon=23, SingleComment=24, UnderScore=25, DotArrow=26, OpenParen=27, 
		CloseParen=28, OpenBracket=29, CloseBracket=30, OpenBrace=31, CloseBrace=32, 
		OpenJavaBrace=33, CloseJavaBrace=34;
	public static final int
		RULE_program = 0, RULE_functions = 1, RULE_function = 2, RULE_funend = 3, 
		RULE_with = 4, RULE_expression = 5, RULE_literal = 6, RULE_applicationEx = 7, 
		RULE_applicationTerm = 8, RULE_lambdaEx = 9, RULE_lambdaElems = 10, RULE_letEx = 11, 
		RULE_end = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "funend", "with", "expression", "literal", 
			"applicationEx", "applicationTerm", "lambdaEx", "lambdaElems", "letEx", 
			"end"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'else'", "'end'", "'if'", "'in'", 
			"'let'", "'then'", "'with'", null, null, null, null, null, "'\\'", "'./'", 
			"':'", "'='", "'/.'", "';'", "'//'", "'_'", "'.>'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'{{#'", "'#}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "COMMENT", "MULTICOMMENT", "ELSE", "END", 
			"IF", "IN", "LET", "THEN", "WITH", "FUNID", "BOOLEAN", "DECIMAL", "EXPONENT", 
			"FLOAT", "Backslash", "CloseMultiComment", "Colon", "Equals", "OpenMultiComment", 
			"SemiColon", "SingleComment", "UnderScore", "DotArrow", "OpenParen", 
			"CloseParen", "OpenBracket", "CloseBracket", "OpenBrace", "CloseBrace", 
			"OpenJavaBrace", "CloseJavaBrace"
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
			setState(26);
			functions();
			setState(27);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(31);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNID:
					{
					setState(29);
					function();
					}
					break;
				case NEWLINE:
					{
					setState(30);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE || _la==FUNID );
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
		public FunendContext funend() {
			return getRuleContext(FunendContext.class,0);
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
			setState(35);
			match(FUNID);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(36);
				lambdaElems(0);
				}
			}

			setState(39);
			match(Equals);
			setState(40);
			expression();
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(41);
				match(NEWLINE);
				setState(42);
				with();
				}
				break;
			}
			setState(45);
			funend();
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
	public static class FunendContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public TerminalNode SemiColon() { return getToken(FunxParser.SemiColon, 0); }
		public FunendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funend; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFunend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunendContext funend() throws RecognitionException {
		FunendContext _localctx = new FunendContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==NEWLINE || _la==SemiColon) ) {
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
	public static class WithContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(FunxParser.WITH, 0); }
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(WITH);
			setState(50);
			match(NEWLINE);
			setState(51);
			functions();
			setState(52);
			end();
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
	public static class ConstantContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ExpressionContext {
		public ApplicationExContext applicationEx() {
			return getRuleContext(ApplicationExContext.class,0);
		}
		public ApplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedContext extends ExpressionContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenthesizedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenthesized(this);
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

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case DECIMAL:
			case FLOAT:
				_localctx = new ConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				literal();
				}
				break;
			case FUNID:
				_localctx = new ApplicationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				applicationEx(0);
				}
				break;
			case Backslash:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				lambdaEx();
				}
				break;
			case LET:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				letEx();
				}
				break;
			case OpenParen:
				_localctx = new ParenthesizedContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				match(OpenParen);
				setState(59);
				expression();
				setState(60);
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
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends LiteralContext {
		public TerminalNode BOOLEAN() { return getToken(FunxParser.BOOLEAN, 0); }
		public BoolContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatingContext extends LiteralContext {
		public TerminalNode FLOAT() { return getToken(FunxParser.FLOAT, 0); }
		public FloatingContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFloating(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends LiteralContext {
		public TerminalNode DECIMAL() { return getToken(FunxParser.DECIMAL, 0); }
		public IntegerContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_literal);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(BOOLEAN);
				}
				break;
			case DECIMAL:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(DECIMAL);
				}
				break;
			case FLOAT:
				_localctx = new FloatingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
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
	public static class SingleApplicationContext extends ApplicationExContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public SingleApplicationContext(ApplicationExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitSingleApplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiApplicationContext extends ApplicationExContext {
		public ApplicationExContext applicationEx() {
			return getRuleContext(ApplicationExContext.class,0);
		}
		public ApplicationTermContext applicationTerm() {
			return getRuleContext(ApplicationTermContext.class,0);
		}
		public MultiApplicationContext(ApplicationExContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMultiApplication(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_applicationEx, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleApplicationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(70);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiApplicationContext(new ApplicationExContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_applicationEx);
					setState(72);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(73);
					applicationTerm();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class LiteralTermContext extends ApplicationTermContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralTermContext(ApplicationTermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLiteralTerm(this);
			else return visitor.visitChildren(this);
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

	public final ApplicationTermContext applicationTerm() throws RecognitionException {
		ApplicationTermContext _localctx = new ApplicationTermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_applicationTerm);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				_localctx = new FunTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(FUNID);
				}
				break;
			case BOOLEAN:
			case DECIMAL:
			case FLOAT:
				_localctx = new LiteralTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				literal();
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
		enterRule(_localctx, 18, RULE_lambdaEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(Backslash);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(84);
				lambdaElems(0);
				}
			}

			setState(87);
			match(DotArrow);
			setState(88);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_lambdaElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleLambdaContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(91);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiLambdaContext(new LambdaElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lambdaElems);
					setState(93);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(94);
					match(FUNID);
					}
					} 
				}
				setState(99);
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
	public static class LetExContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FunxParser.LET, 0); }
		public TerminalNode IN() { return getToken(FunxParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
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
		enterRule(_localctx, 22, RULE_letEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LET);
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				setState(101);
				function();
				}
				break;
			case NEWLINE:
				{
				setState(102);
				match(NEWLINE);
				setState(103);
				functions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(106);
			match(IN);
			setState(107);
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
	public static class EndContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(FunxParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(END);
			setState(110);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return applicationEx_sempred((ApplicationExContext)_localctx, predIndex);
		case 10:
			return lambdaElems_sempred((LambdaElemsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean applicationEx_sempred(ApplicationExContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
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
		"\u0004\u0001\"q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u0001 \b\u0001\u000b\u0001\f\u0001!\u0001\u0002\u0001\u0002\u0003"+
		"\u0002&\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002,\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005?\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006D\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007K\b\u0007\n\u0007\f\u0007N\t\u0007\u0001\b\u0001\b\u0003"+
		"\bR\b\b\u0001\t\u0001\t\u0003\tV\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n`\b\n\n\n\f\nc\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bi\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0002\u000e\u0014"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0001\u0002\u0000\u0001\u0001\u0017\u0017r\u0000\u001a\u0001\u0000\u0000"+
		"\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000"+
		"\u0006/\u0001\u0000\u0000\u0000\b1\u0001\u0000\u0000\u0000\n>\u0001\u0000"+
		"\u0000\u0000\fC\u0001\u0000\u0000\u0000\u000eE\u0001\u0000\u0000\u0000"+
		"\u0010Q\u0001\u0000\u0000\u0000\u0012S\u0001\u0000\u0000\u0000\u0014Z"+
		"\u0001\u0000\u0000\u0000\u0016d\u0001\u0000\u0000\u0000\u0018m\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005\u0000"+
		"\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000\u001d \u0003\u0004\u0002"+
		"\u0000\u001e \u0005\u0001\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000"+
		"\u001f\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0003\u0001\u0000"+
		"\u0000\u0000#%\u0005\r\u0000\u0000$&\u0003\u0014\n\u0000%$\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005"+
		"\u0015\u0000\u0000(+\u0003\n\u0005\u0000)*\u0005\u0001\u0000\u0000*,\u0003"+
		"\b\u0004\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-.\u0003\u0006\u0003\u0000.\u0005\u0001\u0000\u0000"+
		"\u0000/0\u0007\u0000\u0000\u00000\u0007\u0001\u0000\u0000\u000012\u0005"+
		"\f\u0000\u000023\u0005\u0001\u0000\u000034\u0003\u0002\u0001\u000045\u0003"+
		"\u0018\f\u00005\t\u0001\u0000\u0000\u00006?\u0003\f\u0006\u00007?\u0003"+
		"\u000e\u0007\u00008?\u0003\u0012\t\u00009?\u0003\u0016\u000b\u0000:;\u0005"+
		"\u001b\u0000\u0000;<\u0003\n\u0005\u0000<=\u0005\u001c\u0000\u0000=?\u0001"+
		"\u0000\u0000\u0000>6\u0001\u0000\u0000\u0000>7\u0001\u0000\u0000\u0000"+
		">8\u0001\u0000\u0000\u0000>9\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000"+
		"\u0000?\u000b\u0001\u0000\u0000\u0000@D\u0005\u000e\u0000\u0000AD\u0005"+
		"\u000f\u0000\u0000BD\u0005\u0011\u0000\u0000C@\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000CB\u0001\u0000\u0000\u0000D\r\u0001\u0000\u0000"+
		"\u0000EF\u0006\u0007\uffff\uffff\u0000FG\u0005\r\u0000\u0000GL\u0001\u0000"+
		"\u0000\u0000HI\n\u0001\u0000\u0000IK\u0003\u0010\b\u0000JH\u0001\u0000"+
		"\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000M\u000f\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000"+
		"\u0000OR\u0005\r\u0000\u0000PR\u0003\f\u0006\u0000QO\u0001\u0000\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000R\u0011\u0001\u0000\u0000\u0000SU\u0005"+
		"\u0012\u0000\u0000TV\u0003\u0014\n\u0000UT\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005\u001a\u0000\u0000"+
		"XY\u0003\n\u0005\u0000Y\u0013\u0001\u0000\u0000\u0000Z[\u0006\n\uffff"+
		"\uffff\u0000[\\\u0005\r\u0000\u0000\\a\u0001\u0000\u0000\u0000]^\n\u0001"+
		"\u0000\u0000^`\u0005\r\u0000\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0015"+
		"\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000dh\u0005\n\u0000\u0000"+
		"ei\u0003\u0004\u0002\u0000fg\u0005\u0001\u0000\u0000gi\u0003\u0002\u0001"+
		"\u0000he\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jk\u0005\t\u0000\u0000kl\u0003\n\u0005\u0000l\u0017\u0001"+
		"\u0000\u0000\u0000mn\u0005\u0007\u0000\u0000no\u0005\u0001\u0000\u0000"+
		"o\u0019\u0001\u0000\u0000\u0000\u000b\u001f!%+>CLQUah";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}