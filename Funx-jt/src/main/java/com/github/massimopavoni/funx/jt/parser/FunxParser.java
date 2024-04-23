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
		RULE_localFunctions = 4, RULE_typeElems = 5, RULE_statement = 6, RULE_expression = 7, 
		RULE_primary = 8, RULE_lambda = 9, RULE_lambdaElems = 10, RULE_let = 11, 
		RULE_if = 12, RULE_literal = 13, RULE_numLiteral = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "functionType", "localFunctions", 
			"typeElems", "statement", "expression", "primary", "lambda", "lambdaElems", 
			"let", "if", "literal", "numLiteral"
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
			setState(30);
			functions();
			setState(31);
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
			setState(33);
			function();
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					match(NEWLINE);
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FUNID) {
						{
						setState(35);
						function();
						}
					}

					}
					} 
				}
				setState(42);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
			setState(43);
			functionType();
			setState(44);
			match(NEWLINE);
			setState(45);
			match(FUNID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(46);
				lambdaElems(0);
				}
			}

			setState(49);
			match(Equals);
			setState(50);
			statement();
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(51);
				match(NEWLINE);
				setState(52);
				match(WITH);
				setState(53);
				localFunctions();
				setState(54);
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
			setState(58);
			match(FUNID);
			setState(59);
			match(Colon);
			setState(60);
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
			setState(62);
			match(NEWLINE);
			setState(63);
			functions();
			setState(64);
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
	public static class ArrowTypeContext extends TypeElemsContext {
		public List<TypeElemsContext> typeElems() {
			return getRuleContexts(TypeElemsContext.class);
		}
		public TypeElemsContext typeElems(int i) {
			return getRuleContext(TypeElemsContext.class,i);
		}
		public TerminalNode Arrow() { return getToken(FunxParser.Arrow, 0); }
		public ArrowTypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitArrowType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenTypeContext extends TypeElemsContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenTypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends TypeElemsContext {
		public TerminalNode TYPE() { return getToken(FunxParser.TYPE, 0); }
		public TypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitType(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_typeElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				{
				_localctx = new ParenTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(67);
				match(OpenParen);
				setState(68);
				typeElems(0);
				setState(69);
				match(CloseParen);
				}
				break;
			case TYPE:
				{
				_localctx = new TypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(TYPE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrowTypeContext(new TypeElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeElems);
					setState(74);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(75);
					match(Arrow);
					setState(76);
					typeElems(1);
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitEx(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaStContext extends StatementContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambdaSt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetStContext extends StatementContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public LetStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLetSt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStContext extends StatementContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public IfStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIfSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case BOOL:
			case FLOAT:
			case INT:
			case Not:
			case OpenParen:
				_localctx = new ExContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				expression(0);
				}
				break;
			case Backslash:
				_localctx = new LambdaStContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				lambda();
				}
				break;
			case LET:
				_localctx = new LetStContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				let();
				}
				break;
			case IF:
				_localctx = new IfStContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				if_();
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AppContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GreaterThan() { return getToken(FunxParser.GreaterThan, 0); }
		public TerminalNode GreaterThanEquals() { return getToken(FunxParser.GreaterThanEquals, 0); }
		public TerminalNode LessThan() { return getToken(FunxParser.LessThan, 0); }
		public TerminalNode LessThanEquals() { return getToken(FunxParser.LessThanEquals, 0); }
		public CompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitPrim(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpressionContext {
		public TerminalNode Not() { return getToken(FunxParser.Not, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(FunxParser.Or, 0); }
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(FunxParser.And, 0); }
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(FunxParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(FunxParser.Subtract, 0); }
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EqualsEquals() { return getToken(FunxParser.EqualsEquals, 0); }
		public TerminalNode NotEquals() { return getToken(FunxParser.NotEquals, 0); }
		public EqContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivModMultContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Divide() { return getToken(FunxParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(FunxParser.Modulo, 0); }
		public TerminalNode Multiply() { return getToken(FunxParser.Multiply, 0); }
		public DivModMultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDivModMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case BOOL:
			case FLOAT:
			case INT:
			case OpenParen:
				{
				_localctx = new PrimContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(89);
				primary();
				}
				break;
			case Not:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(Not);
				setState(91);
				expression(7);
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
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AppContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(95);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new DivModMultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(97);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(100);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(103);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2013265920L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new EqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(106);
						_la = _input.LA(1);
						if ( !(_la==EqualsEquals || _la==NotEquals) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(107);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(109);
						match(And);
						setState(110);
						expression(3);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(112);
						match(Or);
						setState(113);
						expression(2);
						}
						break;
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
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends PrimaryContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends PrimaryContext {
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public FunContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primary);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(OpenParen);
				setState(120);
				statement();
				setState(121);
				match(CloseParen);
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				_localctx = new LitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				literal();
				}
				break;
			case FUNID:
				_localctx = new FunContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(FUNID);
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
	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode Backslash() { return getToken(FunxParser.Backslash, 0); }
		public TerminalNode Arrow() { return getToken(FunxParser.Arrow, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LambdaElemsContext lambdaElems() {
			return getRuleContext(LambdaElemsContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(Backslash);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(128);
				lambdaElems(0);
				}
			}

			setState(131);
			match(Arrow);
			setState(132);
			statement();
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
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public List<LambdaElemsContext> lambdaElems() {
			return getRuleContexts(LambdaElemsContext.class);
		}
		public LambdaElemsContext lambdaElems(int i) {
			return getRuleContext(LambdaElemsContext.class,i);
		}
		public LambdaElemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaElems; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambdaElems(this);
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
			setState(135);
			match(FUNID);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LambdaElemsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lambdaElems);
					setState(137);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(138);
					lambdaElems(1);
					}
					} 
				}
				setState(143);
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
	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FunxParser.LET, 0); }
		public LocalFunctionsContext localFunctions() {
			return getRuleContext(LocalFunctionsContext.class,0);
		}
		public TerminalNode IN() { return getToken(FunxParser.IN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(LET);
			setState(145);
			localFunctions();
			setState(146);
			match(IN);
			setState(147);
			statement();
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FunxParser.IF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode THEN() { return getToken(FunxParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(FunxParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(FunxParser.FI, 0); }
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(IF);
			setState(150);
			statement();
			setState(151);
			match(THEN);
			setState(152);
			statement();
			setState(153);
			match(ELSE);
			setState(154);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(FunxParser.BOOL, 0); }
		public NumLiteralContext numLiteral() {
			return getRuleContext(NumLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(BOOL);
				}
				break;
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				numLiteral();
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
	public static class NumLiteralContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(FunxParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(FunxParser.INT, 0); }
		public NumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumLiteralContext numLiteral() throws RecognitionException {
		NumLiteralContext _localctx = new NumLiteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return typeElems_sempred((TypeElemsContext)_localctx, predIndex);
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 10:
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
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lambdaElems_sempred(LambdaElemsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001%\b\u0001"+
		"\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"9\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005I\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006W\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007]\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007s\b\u0007\n\u0007\f\u0007v\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b~\b\b\u0001\t"+
		"\u0001\t\u0003\t\u0082\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u008c\b\n\n\n\f\n\u008f\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u00a0\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0000\u0003\n\u000e\u0014\u000f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000"+
		"\u0005\u0001\u0000!#\u0002\u0000  $$\u0001\u0000\u001b\u001e\u0002\u0000"+
		"\u001a\u001a\u001f\u001f\u0001\u0000\u0015\u0016\u00aa\u0000\u001e\u0001"+
		"\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0004+\u0001\u0000\u0000"+
		"\u0000\u0006:\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\nH\u0001"+
		"\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000\u0000"+
		"\u0000\u0010}\u0001\u0000\u0000\u0000\u0012\u007f\u0001\u0000\u0000\u0000"+
		"\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u0090\u0001\u0000\u0000\u0000"+
		"\u0018\u0095\u0001\u0000\u0000\u0000\u001a\u009f\u0001\u0000\u0000\u0000"+
		"\u001c\u00a1\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000"+
		"\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!(\u0003"+
		"\u0004\u0002\u0000\"$\u0005\u0001\u0000\u0000#%\u0003\u0004\u0002\u0000"+
		"$#\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&\"\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000+,\u0003\u0006\u0003\u0000,-\u0005\u0001\u0000"+
		"\u0000-/\u0005\u0013\u0000\u0000.0\u0003\u0014\n\u0000/.\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0005\'\u0000"+
		"\u000028\u0003\f\u0006\u000034\u0005\u0001\u0000\u000045\u0005\u0011\u0000"+
		"\u000056\u0003\b\u0004\u000067\u0005\u000f\u0000\u000079\u0001\u0000\u0000"+
		"\u000083\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u0005\u0001"+
		"\u0000\u0000\u0000:;\u0005\u0013\u0000\u0000;<\u0005&\u0000\u0000<=\u0003"+
		"\n\u0005\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005\u0001\u0000\u0000"+
		"?@\u0003\u0002\u0001\u0000@A\u0005\u0001\u0000\u0000A\t\u0001\u0000\u0000"+
		"\u0000BC\u0006\u0005\uffff\uffff\u0000CD\u0005*\u0000\u0000DE\u0003\n"+
		"\u0005\u0000EF\u0005+\u0000\u0000FI\u0001\u0000\u0000\u0000GI\u0005\u0012"+
		"\u0000\u0000HB\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000IO\u0001"+
		"\u0000\u0000\u0000JK\n\u0001\u0000\u0000KL\u0005)\u0000\u0000LN\u0003"+
		"\n\u0005\u0001MJ\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u000b\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000RW\u0003\u000e\u0007\u0000SW\u0003\u0012"+
		"\t\u0000TW\u0003\u0016\u000b\u0000UW\u0003\u0018\f\u0000VR\u0001\u0000"+
		"\u0000\u0000VS\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VU\u0001"+
		"\u0000\u0000\u0000W\r\u0001\u0000\u0000\u0000XY\u0006\u0007\uffff\uffff"+
		"\u0000Y]\u0003\u0010\b\u0000Z[\u0005\u0019\u0000\u0000[]\u0003\u000e\u0007"+
		"\u0007\\X\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]t\u0001\u0000"+
		"\u0000\u0000^_\n\b\u0000\u0000_s\u0003\u000e\u0007\t`a\n\u0006\u0000\u0000"+
		"ab\u0007\u0000\u0000\u0000bs\u0003\u000e\u0007\u0007cd\n\u0005\u0000\u0000"+
		"de\u0007\u0001\u0000\u0000es\u0003\u000e\u0007\u0006fg\n\u0004\u0000\u0000"+
		"gh\u0007\u0002\u0000\u0000hs\u0003\u000e\u0007\u0005ij\n\u0003\u0000\u0000"+
		"jk\u0007\u0003\u0000\u0000ks\u0003\u000e\u0007\u0004lm\n\u0002\u0000\u0000"+
		"mn\u0005\u0017\u0000\u0000ns\u0003\u000e\u0007\u0003op\n\u0001\u0000\u0000"+
		"pq\u0005\u0018\u0000\u0000qs\u0003\u000e\u0007\u0002r^\u0001\u0000\u0000"+
		"\u0000r`\u0001\u0000\u0000\u0000rc\u0001\u0000\u0000\u0000rf\u0001\u0000"+
		"\u0000\u0000ri\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000ro\u0001"+
		"\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wx\u0005*\u0000\u0000xy\u0003\f\u0006\u0000yz\u0005+\u0000"+
		"\u0000z~\u0001\u0000\u0000\u0000{~\u0003\u001a\r\u0000|~\u0005\u0013\u0000"+
		"\u0000}w\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}|\u0001\u0000"+
		"\u0000\u0000~\u0011\u0001\u0000\u0000\u0000\u007f\u0081\u0005%\u0000\u0000"+
		"\u0080\u0082\u0003\u0014\n\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005)\u0000\u0000\u0084\u0085\u0003\f\u0006\u0000\u0085\u0013"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0006\n\uffff\uffff\u0000\u0087\u0088"+
		"\u0005\u0013\u0000\u0000\u0088\u008d\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\n\u0001\u0000\u0000\u008a\u008c\u0003\u0014\n\u0001\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0015\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005"+
		"\u000e\u0000\u0000\u0091\u0092\u0003\b\u0004\u0000\u0092\u0093\u0005\r"+
		"\u0000\u0000\u0093\u0094\u0003\f\u0006\u0000\u0094\u0017\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\f\u0000\u0000\u0096\u0097\u0003\f\u0006\u0000"+
		"\u0097\u0098\u0005\u0010\u0000\u0000\u0098\u0099\u0003\f\u0006\u0000\u0099"+
		"\u009a\u0005\t\u0000\u0000\u009a\u009b\u0003\f\u0006\u0000\u009b\u009c"+
		"\u0005\u000b\u0000\u0000\u009c\u0019\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0005\u0014\u0000\u0000\u009e\u00a0\u0003\u001c\u000e\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u001b"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0007\u0004\u0000\u0000\u00a2\u001d"+
		"\u0001\u0000\u0000\u0000\u000e$(/8HOV\\rt}\u0081\u008d\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}