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
		RULE_localFunctions = 4, RULE_typeElems = 5, RULE_typeTerm = 6, RULE_expression = 7, 
		RULE_parenOrFun = 8, RULE_applicationEx = 9, RULE_multiApplication = 10, 
		RULE_literal = 11, RULE_numLiteral = 12, RULE_lambdaEx = 13, RULE_lambdaElems = 14, 
		RULE_letEx = 15, RULE_ifEx = 16, RULE_boolEx = 17, RULE_boolOr = 18, RULE_boolTerm = 19, 
		RULE_boolAnd = 20, RULE_boolFactor = 21, RULE_boolPrimary = 22, RULE_comparison = 23, 
		RULE_arithmeticEx = 24, RULE_addSub = 25, RULE_arithmeticTerm = 26, RULE_divModMult = 27, 
		RULE_arithmeticFactor = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functions", "function", "functionType", "localFunctions", 
			"typeElems", "typeTerm", "expression", "parenOrFun", "applicationEx", 
			"multiApplication", "literal", "numLiteral", "lambdaEx", "lambdaElems", 
			"letEx", "ifEx", "boolEx", "boolOr", "boolTerm", "boolAnd", "boolFactor", 
			"boolPrimary", "comparison", "arithmeticEx", "addSub", "arithmeticTerm", 
			"divModMult", "arithmeticFactor"
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
			setState(58);
			functions();
			setState(59);
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
			setState(61);
			function();
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					match(NEWLINE);
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FUNID) {
						{
						setState(63);
						function();
						}
					}

					}
					} 
				}
				setState(70);
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
			setState(71);
			functionType();
			setState(72);
			match(NEWLINE);
			setState(73);
			match(FUNID);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(74);
				lambdaElems();
				}
			}

			setState(77);
			match(Equals);
			setState(78);
			expression();
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(79);
				match(NEWLINE);
				setState(80);
				match(WITH);
				setState(81);
				localFunctions();
				setState(82);
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
			setState(86);
			match(FUNID);
			setState(87);
			match(Colon);
			setState(88);
			typeElems();
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
			setState(90);
			match(NEWLINE);
			setState(91);
			functions();
			setState(92);
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
		public TypeTermContext typeTerm() {
			return getRuleContext(TypeTermContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(FunxParser.Arrow, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public TypeElemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeElems; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitTypeElems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeElemsContext typeElems() throws RecognitionException {
		TypeElemsContext _localctx = new TypeElemsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeElems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			typeTerm();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Arrow) {
				{
				setState(95);
				match(Arrow);
				setState(96);
				typeElems();
				}
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
		enterRule(_localctx, 12, RULE_typeTerm);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				_localctx = new ParenTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(OpenParen);
				setState(100);
				typeElems();
				setState(101);
				match(CloseParen);
				}
				break;
			case TYPE:
				_localctx = new TypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				ifEx();
				}
				break;
			case 2:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				letEx();
				}
				break;
			case 3:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				lambdaEx();
				}
				break;
			case 4:
				_localctx = new AppContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				applicationEx();
				}
				break;
			case 5:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				boolEx();
				}
				break;
			case 6:
				_localctx = new ArithContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
				arithmeticEx();
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
	public static class ParenOrFunContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public TerminalNode FUNID() { return getToken(FunxParser.FUNID, 0); }
		public ParenOrFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenOrFun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenOrFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenOrFunContext parenOrFun() throws RecognitionException {
		ParenOrFunContext _localctx = new ParenOrFunContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parenOrFun);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(OpenParen);
				setState(115);
				expression();
				setState(116);
				match(CloseParen);
				}
				break;
			case FUNID:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
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
	public static class ApplicationExContext extends ParserRuleContext {
		public ParenOrFunContext parenOrFun() {
			return getRuleContext(ParenOrFunContext.class,0);
		}
		public MultiApplicationContext multiApplication() {
			return getRuleContext(MultiApplicationContext.class,0);
		}
		public ApplicationExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applicationEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitApplicationEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationExContext applicationEx() throws RecognitionException {
		ApplicationExContext _localctx = new ApplicationExContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_applicationEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			parenOrFun();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398054375424L) != 0)) {
				{
				setState(122);
				multiApplication();
				}
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
	public static class MultiApplicationContext extends ParserRuleContext {
		public ParenOrFunContext parenOrFun() {
			return getRuleContext(ParenOrFunContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public MultiApplicationContext multiApplication() {
			return getRuleContext(MultiApplicationContext.class,0);
		}
		public MultiApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiApplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMultiApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiApplicationContext multiApplication() throws RecognitionException {
		MultiApplicationContext _localctx = new MultiApplicationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiApplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case OpenParen:
				{
				setState(125);
				parenOrFun();
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				{
				setState(126);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398054375424L) != 0)) {
				{
				setState(129);
				multiApplication();
				}
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
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(BOOL);
				}
				break;
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
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
		enterRule(_localctx, 24, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
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
		enterRule(_localctx, 26, RULE_lambdaEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(Backslash);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNID) {
				{
				setState(139);
				lambdaElems();
				}
			}

			setState(142);
			match(Arrow);
			setState(143);
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
		public List<TerminalNode> FUNID() { return getTokens(FunxParser.FUNID); }
		public TerminalNode FUNID(int i) {
			return getToken(FunxParser.FUNID, i);
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
		LambdaElemsContext _localctx = new LambdaElemsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lambdaElems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				match(FUNID);
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNID );
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
			setState(150);
			match(LET);
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
				{
				setState(151);
				function();
				}
				break;
			case NEWLINE:
				{
				setState(152);
				localFunctions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(155);
			match(IN);
			setState(156);
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
			setState(158);
			match(IF);
			setState(159);
			expression();
			setState(160);
			match(THEN);
			setState(161);
			expression();
			setState(162);
			match(ELSE);
			setState(163);
			expression();
			setState(164);
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
		public BoolTermContext boolTerm() {
			return getRuleContext(BoolTermContext.class,0);
		}
		public BoolOrContext boolOr() {
			return getRuleContext(BoolOrContext.class,0);
		}
		public BoolExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBoolEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExContext boolEx() throws RecognitionException {
		BoolExContext _localctx = new BoolExContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_boolEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			boolTerm();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Or) {
				{
				setState(167);
				boolOr();
				}
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
	public static class BoolOrContext extends ParserRuleContext {
		public TerminalNode Or() { return getToken(FunxParser.Or, 0); }
		public BoolTermContext boolTerm() {
			return getRuleContext(BoolTermContext.class,0);
		}
		public BoolOrContext boolOr() {
			return getRuleContext(BoolOrContext.class,0);
		}
		public BoolOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBoolOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOrContext boolOr() throws RecognitionException {
		BoolOrContext _localctx = new BoolOrContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Or);
			setState(171);
			boolTerm();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Or) {
				{
				setState(172);
				boolOr();
				}
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
	public static class BoolTermContext extends ParserRuleContext {
		public BoolFactorContext boolFactor() {
			return getRuleContext(BoolFactorContext.class,0);
		}
		public BoolAndContext boolAnd() {
			return getRuleContext(BoolAndContext.class,0);
		}
		public BoolTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBoolTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolTermContext boolTerm() throws RecognitionException {
		BoolTermContext _localctx = new BoolTermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_boolTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			boolFactor();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(176);
				boolAnd();
				}
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
	public static class BoolAndContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(FunxParser.And, 0); }
		public BoolFactorContext boolFactor() {
			return getRuleContext(BoolFactorContext.class,0);
		}
		public BoolAndContext boolAnd() {
			return getRuleContext(BoolAndContext.class,0);
		}
		public BoolAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitBoolAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolAndContext boolAnd() throws RecognitionException {
		BoolAndContext _localctx = new BoolAndContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_boolAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(And);
			setState(180);
			boolFactor();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(181);
				boolAnd();
				}
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
	public static class BoolFactorContext extends ParserRuleContext {
		public BoolFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolFactor; }
	 
		public BoolFactorContext() { }
		public void copyFrom(BoolFactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotBoolContext extends BoolFactorContext {
		public TerminalNode Not() { return getToken(FunxParser.Not, 0); }
		public BoolPrimaryContext boolPrimary() {
			return getRuleContext(BoolPrimaryContext.class,0);
		}
		public NotBoolContext(BoolFactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNotBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleBoolContext extends BoolFactorContext {
		public BoolPrimaryContext boolPrimary() {
			return getRuleContext(BoolPrimaryContext.class,0);
		}
		public SimpleBoolContext(BoolFactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitSimpleBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolFactorContext boolFactor() throws RecognitionException {
		BoolFactorContext _localctx = new BoolFactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolFactor);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case BOOL:
			case FLOAT:
			case INT:
			case OpenParen:
				_localctx = new SimpleBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				boolPrimary();
				}
				break;
			case Not:
				_localctx = new NotBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(Not);
				setState(186);
				boolPrimary();
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
	public static class BoolPrimaryContext extends ParserRuleContext {
		public BoolPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolPrimary; }
	 
		public BoolPrimaryContext() { }
		public void copyFrom(BoolPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitBoolContext extends BoolPrimaryContext {
		public TerminalNode BOOL() { return getToken(FunxParser.BOOL, 0); }
		public LitBoolContext(BoolPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppParenBoolContext extends BoolPrimaryContext {
		public ParenOrFunContext parenOrFun() {
			return getRuleContext(ParenOrFunContext.class,0);
		}
		public AppParenBoolContext(BoolPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAppParenBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompBoolContext extends BoolPrimaryContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public CompBoolContext(BoolPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitCompBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolPrimaryContext boolPrimary() throws RecognitionException {
		BoolPrimaryContext _localctx = new BoolPrimaryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_boolPrimary);
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new LitBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(BOOL);
				}
				break;
			case 2:
				_localctx = new CompBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				comparison();
				}
				break;
			case 3:
				_localctx = new AppParenBoolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				parenOrFun();
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
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
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
		enterRule(_localctx, 46, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case OpenParen:
				{
				setState(194);
				applicationEx();
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				{
				setState(195);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(198);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNID:
			case OpenParen:
				{
				setState(199);
				applicationEx();
				}
				break;
			case BOOL:
			case FLOAT:
			case INT:
				{
				setState(200);
				literal();
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
		public ArithmeticTermContext arithmeticTerm() {
			return getRuleContext(ArithmeticTermContext.class,0);
		}
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public ArithmeticExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticEx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitArithmeticEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExContext arithmeticEx() throws RecognitionException {
		ArithmeticExContext _localctx = new ArithmeticExContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arithmeticEx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			arithmeticTerm();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Add || _la==Subtract) {
				{
				setState(204);
				addSub();
				}
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
	public static class AddSubContext extends ParserRuleContext {
		public ArithmeticTermContext arithmeticTerm() {
			return getRuleContext(ArithmeticTermContext.class,0);
		}
		public TerminalNode Add() { return getToken(FunxParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(FunxParser.Subtract, 0); }
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public AddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubContext addSub() throws RecognitionException {
		AddSubContext _localctx = new AddSubContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_addSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_la = _input.LA(1);
			if ( !(_la==Add || _la==Subtract) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(208);
			arithmeticTerm();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Add || _la==Subtract) {
				{
				setState(209);
				addSub();
				}
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
	public static class ArithmeticTermContext extends ParserRuleContext {
		public ArithmeticFactorContext arithmeticFactor() {
			return getRuleContext(ArithmeticFactorContext.class,0);
		}
		public DivModMultContext divModMult() {
			return getRuleContext(DivModMultContext.class,0);
		}
		public ArithmeticTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitArithmeticTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticTermContext arithmeticTerm() throws RecognitionException {
		ArithmeticTermContext _localctx = new ArithmeticTermContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arithmeticTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			arithmeticFactor();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) {
				{
				setState(213);
				divModMult();
				}
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
	public static class DivModMultContext extends ParserRuleContext {
		public ArithmeticFactorContext arithmeticFactor() {
			return getRuleContext(ArithmeticFactorContext.class,0);
		}
		public TerminalNode Divide() { return getToken(FunxParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(FunxParser.Modulo, 0); }
		public TerminalNode Multiply() { return getToken(FunxParser.Multiply, 0); }
		public DivModMultContext divModMult() {
			return getRuleContext(DivModMultContext.class,0);
		}
		public DivModMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divModMult; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDivModMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivModMultContext divModMult() throws RecognitionException {
		DivModMultContext _localctx = new DivModMultContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_divModMult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(217);
			arithmeticFactor();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) {
				{
				setState(218);
				divModMult();
				}
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
	public static class ArithmeticFactorContext extends ParserRuleContext {
		public ArithmeticFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticFactor; }
	 
		public ArithmeticFactorContext() { }
		public void copyFrom(ArithmeticFactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppParenArithContext extends ArithmeticFactorContext {
		public ParenOrFunContext parenOrFun() {
			return getRuleContext(ParenOrFunContext.class,0);
		}
		public AppParenArithContext(ArithmeticFactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAppParenArith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitArithContext extends ArithmeticFactorContext {
		public NumLiteralContext numLiteral() {
			return getRuleContext(NumLiteralContext.class,0);
		}
		public LitArithContext(ArithmeticFactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLitArith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticFactorContext arithmeticFactor() throws RecognitionException {
		ArithmeticFactorContext _localctx = new ArithmeticFactorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arithmeticFactor);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
				_localctx = new LitArithContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				numLiteral();
				}
				break;
			case FUNID:
			case OpenParen:
				_localctx = new AppParenArithContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				parenOrFun();
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

	public static final String _serializedATN =
		"\u0004\u0001/\u00e2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001A\b\u0001\u0005\u0001C\b\u0001\n\u0001"+
		"\f\u0001F\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002L\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002U\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005b\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006i\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007q\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\bx\b\b\u0001\t\u0001\t\u0003\t|\b\t\u0001\n\u0001\n\u0003\n\u0080\b\n"+
		"\u0001\n\u0003\n\u0083\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u0087\b"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u008d\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0004\u000e\u0093\b\u000e\u000b\u000e\f\u000e\u0094"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u009a\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00a9\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00ae\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u00b2\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00b7\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00bc\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u00c1\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u00c5"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00ca\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u00ce\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u00d3\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u00d7\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00dc\b"+
		"\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u00e0\b\u001c\u0001\u001c\u0000"+
		"\u0000\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0004\u0001\u0000\u0015\u0016"+
		"\u0001\u0000\u001a\u001f\u0002\u0000  $$\u0001\u0000!#\u00e5\u0000:\u0001"+
		"\u0000\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000"+
		"\u0000\u0006V\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\n^\u0001"+
		"\u0000\u0000\u0000\fh\u0001\u0000\u0000\u0000\u000ep\u0001\u0000\u0000"+
		"\u0000\u0010w\u0001\u0000\u0000\u0000\u0012y\u0001\u0000\u0000\u0000\u0014"+
		"\u007f\u0001\u0000\u0000\u0000\u0016\u0086\u0001\u0000\u0000\u0000\u0018"+
		"\u0088\u0001\u0000\u0000\u0000\u001a\u008a\u0001\u0000\u0000\u0000\u001c"+
		"\u0092\u0001\u0000\u0000\u0000\u001e\u0096\u0001\u0000\u0000\u0000 \u009e"+
		"\u0001\u0000\u0000\u0000\"\u00a6\u0001\u0000\u0000\u0000$\u00aa\u0001"+
		"\u0000\u0000\u0000&\u00af\u0001\u0000\u0000\u0000(\u00b3\u0001\u0000\u0000"+
		"\u0000*\u00bb\u0001\u0000\u0000\u0000,\u00c0\u0001\u0000\u0000\u0000."+
		"\u00c4\u0001\u0000\u0000\u00000\u00cb\u0001\u0000\u0000\u00002\u00cf\u0001"+
		"\u0000\u0000\u00004\u00d4\u0001\u0000\u0000\u00006\u00d8\u0001\u0000\u0000"+
		"\u00008\u00df\u0001\u0000\u0000\u0000:;\u0003\u0002\u0001\u0000;<\u0005"+
		"\u0000\u0000\u0001<\u0001\u0001\u0000\u0000\u0000=D\u0003\u0004\u0002"+
		"\u0000>@\u0005\u0001\u0000\u0000?A\u0003\u0004\u0002\u0000@?\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B>\u0001"+
		"\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000GH\u0003\u0006\u0003\u0000HI\u0005\u0001\u0000\u0000IK\u0005"+
		"\u0013\u0000\u0000JL\u0003\u001c\u000e\u0000KJ\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005\'\u0000\u0000"+
		"NT\u0003\u000e\u0007\u0000OP\u0005\u0001\u0000\u0000PQ\u0005\u0011\u0000"+
		"\u0000QR\u0003\b\u0004\u0000RS\u0005\u000f\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TO\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0005\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0013\u0000\u0000WX\u0005&\u0000\u0000XY\u0003"+
		"\n\u0005\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005\u0001\u0000\u0000"+
		"[\\\u0003\u0002\u0001\u0000\\]\u0005\u0001\u0000\u0000]\t\u0001\u0000"+
		"\u0000\u0000^a\u0003\f\u0006\u0000_`\u0005)\u0000\u0000`b\u0003\n\u0005"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u000b\u0001"+
		"\u0000\u0000\u0000cd\u0005*\u0000\u0000de\u0003\n\u0005\u0000ef\u0005"+
		"+\u0000\u0000fi\u0001\u0000\u0000\u0000gi\u0005\u0012\u0000\u0000hc\u0001"+
		"\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\r\u0001\u0000\u0000\u0000"+
		"jq\u0003 \u0010\u0000kq\u0003\u001e\u000f\u0000lq\u0003\u001a\r\u0000"+
		"mq\u0003\u0012\t\u0000nq\u0003\"\u0011\u0000oq\u00030\u0018\u0000pj\u0001"+
		"\u0000\u0000\u0000pk\u0001\u0000\u0000\u0000pl\u0001\u0000\u0000\u0000"+
		"pm\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000q\u000f\u0001\u0000\u0000\u0000rs\u0005*\u0000\u0000st\u0003\u000e"+
		"\u0007\u0000tu\u0005+\u0000\u0000ux\u0001\u0000\u0000\u0000vx\u0005\u0013"+
		"\u0000\u0000wr\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\u0011"+
		"\u0001\u0000\u0000\u0000y{\u0003\u0010\b\u0000z|\u0003\u0014\n\u0000{"+
		"z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0013\u0001\u0000"+
		"\u0000\u0000}\u0080\u0003\u0010\b\u0000~\u0080\u0003\u0016\u000b\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0001\u0000\u0000\u0000\u0081\u0083\u0003\u0014\n\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0015\u0001"+
		"\u0000\u0000\u0000\u0084\u0087\u0005\u0014\u0000\u0000\u0085\u0087\u0003"+
		"\u0018\f\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0085\u0001\u0000"+
		"\u0000\u0000\u0087\u0017\u0001\u0000\u0000\u0000\u0088\u0089\u0007\u0000"+
		"\u0000\u0000\u0089\u0019\u0001\u0000\u0000\u0000\u008a\u008c\u0005%\u0000"+
		"\u0000\u008b\u008d\u0003\u001c\u000e\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005)\u0000\u0000\u008f\u0090\u0003\u000e\u0007\u0000"+
		"\u0090\u001b\u0001\u0000\u0000\u0000\u0091\u0093\u0005\u0013\u0000\u0000"+
		"\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u001d\u0001\u0000\u0000\u0000\u0096\u0099\u0005\u000e\u0000\u0000"+
		"\u0097\u009a\u0003\u0004\u0002\u0000\u0098\u009a\u0003\b\u0004\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\r\u0000\u0000\u009c\u009d"+
		"\u0003\u000e\u0007\u0000\u009d\u001f\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005\f\u0000\u0000\u009f\u00a0\u0003\u000e\u0007\u0000\u00a0\u00a1\u0005"+
		"\u0010\u0000\u0000\u00a1\u00a2\u0003\u000e\u0007\u0000\u00a2\u00a3\u0005"+
		"\t\u0000\u0000\u00a3\u00a4\u0003\u000e\u0007\u0000\u00a4\u00a5\u0005\u000b"+
		"\u0000\u0000\u00a5!\u0001\u0000\u0000\u0000\u00a6\u00a8\u0003&\u0013\u0000"+
		"\u00a7\u00a9\u0003$\u0012\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9#\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0005\u0018\u0000\u0000\u00ab\u00ad\u0003&\u0013\u0000\u00ac\u00ae\u0003"+
		"$\u0012\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae%\u0001\u0000\u0000\u0000\u00af\u00b1\u0003*\u0015\u0000"+
		"\u00b0\u00b2\u0003(\u0014\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\'\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0005\u0017\u0000\u0000\u00b4\u00b6\u0003*\u0015\u0000\u00b5\u00b7\u0003"+
		"(\u0014\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7)\u0001\u0000\u0000\u0000\u00b8\u00bc\u0003,\u0016\u0000"+
		"\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bc\u0003,\u0016\u0000\u00bb"+
		"\u00b8\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc"+
		"+\u0001\u0000\u0000\u0000\u00bd\u00c1\u0005\u0014\u0000\u0000\u00be\u00c1"+
		"\u0003.\u0017\u0000\u00bf\u00c1\u0003\u0010\b\u0000\u00c0\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c1-\u0001\u0000\u0000\u0000\u00c2\u00c5\u0003\u0012"+
		"\t\u0000\u00c3\u00c5\u0003\u0016\u000b\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c9\u0007\u0001\u0000\u0000\u00c7\u00ca\u0003\u0012\t\u0000"+
		"\u00c8\u00ca\u0003\u0016\u000b\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca/\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cd\u00034\u001a\u0000\u00cc\u00ce\u00032\u0019\u0000\u00cd\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce1\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0007\u0002\u0000\u0000\u00d0\u00d2\u00034\u001a"+
		"\u0000\u00d1\u00d3\u00032\u0019\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d33\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d6\u00038\u001c\u0000\u00d5\u00d7\u00036\u001b\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d75\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0007\u0003\u0000\u0000\u00d9\u00db\u00038\u001c"+
		"\u0000\u00da\u00dc\u00036\u001b\u0000\u00db\u00da\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc7\u0001\u0000\u0000\u0000\u00dd"+
		"\u00e0\u0003\u0018\f\u0000\u00de\u00e0\u0003\u0010\b\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e09\u0001"+
		"\u0000\u0000\u0000\u001c@DKTahpw{\u007f\u0082\u0086\u008c\u0094\u0099"+
		"\u00a8\u00ad\u00b1\u00b6\u00bb\u00c0\u00c4\u00c9\u00cd\u00d2\u00d6\u00db"+
		"\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}