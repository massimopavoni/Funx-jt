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
		MAIN=15, MODULE=16, OUT=17, THEN=18, WITH=19, RESERVED_JAVA_KEYWORD=20, 
		TYPE=21, BOOLTYPE=22, INTTYPE=23, BOOL=24, INT=25, VARID=26, MODULEID=27, 
		And=28, Or=29, Not=30, EqualsEquals=31, GreaterThan=32, GreaterThanEquals=33, 
		LessThan=34, LessThanEquals=35, NotEquals=36, Add=37, Divide=38, Modulo=39, 
		Multiply=40, Subtract=41, Dollar=42, Dot=43, Backslash=44, Colon=45, Equals=46, 
		UnderScore=47, Arrow=48, OpenParen=49, CloseParen=50, OpenBracket=51, 
		CloseBracket=52, OpenBrace=53, CloseBrace=54;
	public static final int
		RULE_module = 0, RULE_declarations = 1, RULE_main = 2, RULE_declaration = 3, 
		RULE_declarationScheme = 4, RULE_with = 5, RULE_localDeclarations = 6, 
		RULE_typeElems = 7, RULE_statement = 8, RULE_expression = 9, RULE_primary = 10, 
		RULE_lambda = 11, RULE_lambdaParams = 12, RULE_let = 13, RULE_ifS = 14, 
		RULE_constant = 15, RULE_numConstant = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "declarations", "main", "declaration", "declarationScheme", 
			"with", "localDeclarations", "typeElems", "statement", "expression", 
			"primary", "lambda", "lambdaParams", "let", "ifS", "constant", "numConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'./'", "'/.'", "'//'", null, null, "'else'", 
			"'end'", "'fi'", "'if'", "'in'", "'let'", "'main'", "'module'", "'out'", 
			"'then'", "'with'", null, null, "'Bool'", "'Int'", null, null, null, 
			null, "'&&'", "'||'", "'!!'", "'=='", "'>'", "'>='", "'<'", "'<='", "'!='", 
			"'+'", "'/'", "'%'", "'*'", "'-'", "'$'", "'.'", "'\\'", "':'", "'='", 
			"'_'", "'->'", "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "CloseMultiComment", "OpenMultiComment", 
			"SingleComment", "COMMENT", "MULTICOMMENT", "ELSE", "END", "FI", "IF", 
			"IN", "LET", "MAIN", "MODULE", "OUT", "THEN", "WITH", "RESERVED_JAVA_KEYWORD", 
			"TYPE", "BOOLTYPE", "INTTYPE", "BOOL", "INT", "VARID", "MODULEID", "And", 
			"Or", "Not", "EqualsEquals", "GreaterThan", "GreaterThanEquals", "LessThan", 
			"LessThanEquals", "NotEquals", "Add", "Divide", "Modulo", "Multiply", 
			"Subtract", "Dollar", "Dot", "Backslash", "Colon", "Equals", "UnderScore", 
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
	public static class ModuleContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FunxParser.EOF, 0); }
		public TerminalNode MODULE() { return getToken(FunxParser.MODULE, 0); }
		public List<TerminalNode> MODULEID() { return getTokens(FunxParser.MODULEID); }
		public TerminalNode MODULEID(int i) {
			return getToken(FunxParser.MODULEID, i);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<TerminalNode> Dot() { return getTokens(FunxParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(FunxParser.Dot, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODULE) {
				{
				setState(34);
				match(MODULE);
				setState(35);
				match(MODULEID);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Dot) {
					{
					{
					setState(36);
					match(Dot);
					setState(37);
					match(MODULEID);
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(43);
					match(NEWLINE);
					}
					}
					setState(46); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
			}

			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MAIN) {
				{
				setState(50);
				main();
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(51);
					match(NEWLINE);
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
			}

			setState(58);
			declarations();
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
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			declaration();
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					match(NEWLINE);
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VARID) {
						{
						setState(63);
						declaration();
						}
					}

					}
					} 
				}
				setState(70);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Equals() { return getToken(FunxParser.Equals, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(FunxParser.MAIN, 0); }
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((MainContext)_localctx).id = match(MAIN);
			setState(72);
			match(Equals);
			setState(73);
			statement();
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(74);
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
	public static class DeclarationContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Equals() { return getToken(FunxParser.Equals, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode VARID() { return getToken(FunxParser.VARID, 0); }
		public DeclarationSchemeContext declarationScheme() {
			return getRuleContext(DeclarationSchemeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public LambdaParamsContext lambdaParams() {
			return getRuleContext(LambdaParamsContext.class,0);
		}
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(77);
				declarationScheme();
				setState(78);
				match(NEWLINE);
				}
				break;
			}
			setState(82);
			((DeclarationContext)_localctx).id = match(VARID);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARID) {
				{
				setState(83);
				lambdaParams();
				}
			}

			setState(86);
			match(Equals);
			setState(87);
			statement();
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(88);
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
	public static class DeclarationSchemeContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Colon() { return getToken(FunxParser.Colon, 0); }
		public TypeElemsContext typeElems() {
			return getRuleContext(TypeElemsContext.class,0);
		}
		public TerminalNode VARID() { return getToken(FunxParser.VARID, 0); }
		public DeclarationSchemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationScheme; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDeclarationScheme(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSchemeContext declarationScheme() throws RecognitionException {
		DeclarationSchemeContext _localctx = new DeclarationSchemeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationScheme);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((DeclarationSchemeContext)_localctx).id = match(VARID);
			setState(92);
			match(Colon);
			setState(93);
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
	public static class WithContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(FunxParser.NEWLINE, 0); }
		public TerminalNode WITH() { return getToken(FunxParser.WITH, 0); }
		public LocalDeclarationsContext localDeclarations() {
			return getRuleContext(LocalDeclarationsContext.class,0);
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
		enterRule(_localctx, 10, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(NEWLINE);
			setState(96);
			match(WITH);
			setState(97);
			localDeclarations();
			setState(98);
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
	public static class LocalDeclarationsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FunxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FunxParser.NEWLINE, i);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public LocalDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDeclarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLocalDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDeclarationsContext localDeclarations() throws RecognitionException {
		LocalDeclarationsContext _localctx = new LocalDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localDeclarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(NEWLINE);
			setState(101);
			declarations();
			setState(102);
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
	public static class NamedTypeContext extends TypeElemsContext {
		public TerminalNode TYPE() { return getToken(FunxParser.TYPE, 0); }
		public NamedTypeContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNamedType(this);
			else return visitor.visitChildren(this);
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
	public static class TypeVarContext extends TypeElemsContext {
		public TerminalNode VARID() { return getToken(FunxParser.VARID, 0); }
		public TypeVarContext(TypeElemsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitTypeVar(this);
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

	public final TypeElemsContext typeElems() throws RecognitionException {
		return typeElems(0);
	}

	private TypeElemsContext typeElems(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeElemsContext _localctx = new TypeElemsContext(_ctx, _parentState);
		TypeElemsContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_typeElems, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				{
				_localctx = new ParenTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(105);
				match(OpenParen);
				setState(106);
				typeElems(0);
				setState(107);
				match(CloseParen);
				}
				break;
			case VARID:
				{
				_localctx = new TypeVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(VARID);
				}
				break;
			case TYPE:
				{
				_localctx = new NamedTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(TYPE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrowTypeContext(new TypeElemsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeElems);
					setState(113);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(114);
					match(Arrow);
					setState(115);
					typeElems(1);
					}
					} 
				}
				setState(120);
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
	public static class LambdaStatementContext extends StatementContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambdaStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends StatementContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public LetStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public IfSContext ifS() {
			return getRuleContext(IfSContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case VARID:
			case Not:
			case OpenParen:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				expression(0);
				}
				break;
			case Backslash:
				_localctx = new LambdaStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				lambda();
				}
				break;
			case LET:
				_localctx = new LetStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				let();
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				ifS();
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
	public static class AppExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AppExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAppExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(FunxParser.Or, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EqualsEquals() { return getToken(FunxParser.EqualsEquals, 0); }
		public TerminalNode NotEquals() { return getToken(FunxParser.NotEquals, 0); }
		public EqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(FunxParser.And, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComposeExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Dot() { return getToken(FunxParser.Dot, 0); }
		public ComposeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitComposeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RightAppExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Dollar() { return getToken(FunxParser.Dollar, 0); }
		public RightAppExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitRightAppExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExpressionContext extends ExpressionContext {
		public Token bop;
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
		public CompExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitCompExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimExpressionContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitPrimExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivModMultExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Divide() { return getToken(FunxParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(FunxParser.Modulo, 0); }
		public TerminalNode Multiply() { return getToken(FunxParser.Multiply, 0); }
		public DivModMultExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitDivModMultExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExpressionContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(FunxParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(FunxParser.Subtract, 0); }
		public AddSubExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitAddSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public Token uop;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(FunxParser.Not, 0); }
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNotExpression(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case VARID:
			case OpenParen:
				{
				_localctx = new PrimExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(128);
				primary();
				}
				break;
			case Not:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				((NotExpressionContext)_localctx).uop = match(Not);
				setState(130);
				expression(4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(159);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AppExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(134);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ComposeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136);
						((ComposeExpressionContext)_localctx).bop = match(Dot);
						setState(137);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new DivModMultExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(139);
						((DivModMultExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1924145348608L) != 0)) ) {
							((DivModMultExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(140);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(142);
						((AddSubExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((AddSubExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(143);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new CompExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(145);
						((CompExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
							((CompExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(146);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(148);
						((EqExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EqualsEquals || _la==NotEquals) ) {
							((EqExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(149);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(151);
						((AndExpressionContext)_localctx).bop = match(And);
						setState(152);
						expression(3);
						}
						break;
					case 8:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(154);
						((OrExpressionContext)_localctx).bop = match(Or);
						setState(155);
						expression(2);
						}
						break;
					case 9:
						{
						_localctx = new RightAppExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(157);
						((RightAppExpressionContext)_localctx).bop = match(Dollar);
						setState(158);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class ParenPrimaryContext extends PrimaryContext {
		public TerminalNode OpenParen() { return getToken(FunxParser.OpenParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(FunxParser.CloseParen, 0); }
		public ParenPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitParenPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarPrimaryContext extends PrimaryContext {
		public TerminalNode VARID() { return getToken(FunxParser.VARID, 0); }
		public VarPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitVarPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstPrimaryContext extends PrimaryContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitConstPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primary);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenParen:
				_localctx = new ParenPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(OpenParen);
				setState(165);
				statement();
				setState(166);
				match(CloseParen);
				}
				break;
			case BOOL:
			case INT:
				_localctx = new ConstPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				constant();
				}
				break;
			case VARID:
				_localctx = new VarPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(VARID);
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
		public LambdaParamsContext lambdaParams() {
			return getRuleContext(LambdaParamsContext.class,0);
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
		enterRule(_localctx, 22, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(Backslash);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARID) {
				{
				setState(173);
				lambdaParams();
				}
			}

			setState(176);
			match(Arrow);
			setState(177);
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
	public static class LambdaParamsContext extends ParserRuleContext {
		public List<TerminalNode> VARID() { return getTokens(FunxParser.VARID); }
		public TerminalNode VARID(int i) {
			return getToken(FunxParser.VARID, i);
		}
		public LambdaParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitLambdaParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParamsContext lambdaParams() throws RecognitionException {
		LambdaParamsContext _localctx = new LambdaParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lambdaParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(179);
				match(VARID);
				}
				}
				setState(182); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARID );
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
	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FunxParser.LET, 0); }
		public LocalDeclarationsContext localDeclarations() {
			return getRuleContext(LocalDeclarationsContext.class,0);
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
		enterRule(_localctx, 26, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LET);
			setState(185);
			localDeclarations();
			setState(186);
			match(IN);
			setState(187);
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
	public static class IfSContext extends ParserRuleContext {
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
		public IfSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitIfS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfSContext ifS() throws RecognitionException {
		IfSContext _localctx = new IfSContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(IF);
			setState(190);
			statement();
			setState(191);
			match(THEN);
			setState(192);
			statement();
			setState(193);
			match(ELSE);
			setState(194);
			statement();
			setState(195);
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
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(FunxParser.BOOL, 0); }
		public NumConstantContext numConstant() {
			return getRuleContext(NumConstantContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(BOOL);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				numConstant();
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
	public static class NumConstantContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FunxParser.INT, 0); }
		public NumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numConstant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunxParserVisitor ) return ((FunxParserVisitor<? extends T>)visitor).visitNumConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumConstantContext numConstant() throws RecognitionException {
		NumConstantContext _localctx = new NumConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_numConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(INT);
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
			return typeElems_sempred((TypeElemsContext)_localctx, predIndex);
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
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
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u00cc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0004\u0000"+
		"-\b\u0000\u000b\u0000\f\u0000.\u0003\u00001\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u00005\b\u0000\u000b\u0000\f\u00006\u0003\u00009\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001A\b\u0001\u0005\u0001C\b\u0001\n\u0001\f\u0001F\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002L\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003Q\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003U\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003Z\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007p\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007u\b\u0007\n\u0007\f\u0007x\t"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b~\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0084\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00a0\b\t\n\t\f\t\u00a3\t\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ab\b\n\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00af\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0004\f\u00b5\b\f\u000b\f\f\f\u00b6\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00c8\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0002\u000e\u0012\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0004\u0001\u0000&(\u0002\u0000%%))\u0001\u0000 #\u0002"+
		"\u0000\u001f\u001f$$\u00da\u00000\u0001\u0000\u0000\u0000\u0002=\u0001"+
		"\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000"+
		"\u0000\b[\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000\u0000\fd\u0001"+
		"\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010}\u0001\u0000\u0000"+
		"\u0000\u0012\u0083\u0001\u0000\u0000\u0000\u0014\u00aa\u0001\u0000\u0000"+
		"\u0000\u0016\u00ac\u0001\u0000\u0000\u0000\u0018\u00b4\u0001\u0000\u0000"+
		"\u0000\u001a\u00b8\u0001\u0000\u0000\u0000\u001c\u00bd\u0001\u0000\u0000"+
		"\u0000\u001e\u00c7\u0001\u0000\u0000\u0000 \u00c9\u0001\u0000\u0000\u0000"+
		"\"#\u0005\u0010\u0000\u0000#(\u0005\u001b\u0000\u0000$%\u0005+\u0000\u0000"+
		"%\'\u0005\u001b\u0000\u0000&$\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000),\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000+-\u0005\u0001\u0000\u0000,+\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000"+
		"./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000\"\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000018\u0001\u0000\u0000\u000024\u0003\u0004"+
		"\u0002\u000035\u0005\u0001\u0000\u000043\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:;\u0003\u0002\u0001\u0000;<\u0005\u0000"+
		"\u0000\u0001<\u0001\u0001\u0000\u0000\u0000=D\u0003\u0006\u0003\u0000"+
		">@\u0005\u0001\u0000\u0000?A\u0003\u0006\u0003\u0000@?\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B>\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GH\u0005\u000f\u0000\u0000HI\u0005.\u0000\u0000IK\u0003\u0010\b"+
		"\u0000JL\u0003\n\u0005\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000L\u0005\u0001\u0000\u0000\u0000MN\u0003\b\u0004\u0000NO\u0005\u0001"+
		"\u0000\u0000OQ\u0001\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0005\u001a\u0000\u0000"+
		"SU\u0003\u0018\f\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VW\u0005.\u0000\u0000WY\u0003\u0010\b\u0000"+
		"XZ\u0003\n\u0005\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z\u0007\u0001\u0000\u0000\u0000[\\\u0005\u001a\u0000\u0000\\]\u0005-\u0000"+
		"\u0000]^\u0003\u000e\u0007\u0000^\t\u0001\u0000\u0000\u0000_`\u0005\u0001"+
		"\u0000\u0000`a\u0005\u0013\u0000\u0000ab\u0003\f\u0006\u0000bc\u0005\u0011"+
		"\u0000\u0000c\u000b\u0001\u0000\u0000\u0000de\u0005\u0001\u0000\u0000"+
		"ef\u0003\u0002\u0001\u0000fg\u0005\u0001\u0000\u0000g\r\u0001\u0000\u0000"+
		"\u0000hi\u0006\u0007\uffff\uffff\u0000ij\u00051\u0000\u0000jk\u0003\u000e"+
		"\u0007\u0000kl\u00052\u0000\u0000lp\u0001\u0000\u0000\u0000mp\u0005\u001a"+
		"\u0000\u0000np\u0005\u0015\u0000\u0000oh\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000pv\u0001\u0000\u0000\u0000"+
		"qr\n\u0001\u0000\u0000rs\u00050\u0000\u0000su\u0003\u000e\u0007\u0001"+
		"tq\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000w\u000f\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000y~\u0003\u0012\t\u0000z~\u0003\u0016\u000b\u0000{~\u0003"+
		"\u001a\r\u0000|~\u0003\u001c\u000e\u0000}y\u0001\u0000\u0000\u0000}z\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"~\u0011\u0001\u0000\u0000\u0000\u007f\u0080\u0006\t\uffff\uffff\u0000"+
		"\u0080\u0084\u0003\u0014\n\u0000\u0081\u0082\u0005\u001e\u0000\u0000\u0082"+
		"\u0084\u0003\u0012\t\u0004\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u00a1\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\n\n\u0000\u0000\u0086\u00a0\u0003\u0012\t\u000b\u0087\u0088\n\t\u0000"+
		"\u0000\u0088\u0089\u0005+\u0000\u0000\u0089\u00a0\u0003\u0012\t\t\u008a"+
		"\u008b\n\b\u0000\u0000\u008b\u008c\u0007\u0000\u0000\u0000\u008c\u00a0"+
		"\u0003\u0012\t\t\u008d\u008e\n\u0007\u0000\u0000\u008e\u008f\u0007\u0001"+
		"\u0000\u0000\u008f\u00a0\u0003\u0012\t\b\u0090\u0091\n\u0006\u0000\u0000"+
		"\u0091\u0092\u0007\u0002\u0000\u0000\u0092\u00a0\u0003\u0012\t\u0007\u0093"+
		"\u0094\n\u0005\u0000\u0000\u0094\u0095\u0007\u0003\u0000\u0000\u0095\u00a0"+
		"\u0003\u0012\t\u0006\u0096\u0097\n\u0003\u0000\u0000\u0097\u0098\u0005"+
		"\u001c\u0000\u0000\u0098\u00a0\u0003\u0012\t\u0003\u0099\u009a\n\u0002"+
		"\u0000\u0000\u009a\u009b\u0005\u001d\u0000\u0000\u009b\u00a0\u0003\u0012"+
		"\t\u0002\u009c\u009d\n\u0001\u0000\u0000\u009d\u009e\u0005*\u0000\u0000"+
		"\u009e\u00a0\u0003\u0012\t\u0001\u009f\u0085\u0001\u0000\u0000\u0000\u009f"+
		"\u0087\u0001\u0000\u0000\u0000\u009f\u008a\u0001\u0000\u0000\u0000\u009f"+
		"\u008d\u0001\u0000\u0000\u0000\u009f\u0090\u0001\u0000\u0000\u0000\u009f"+
		"\u0093\u0001\u0000\u0000\u0000\u009f\u0096\u0001\u0000\u0000\u0000\u009f"+
		"\u0099\u0001\u0000\u0000\u0000\u009f\u009c\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u0013\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5\u00051\u0000\u0000\u00a5\u00a6"+
		"\u0003\u0010\b\u0000\u00a6\u00a7\u00052\u0000\u0000\u00a7\u00ab\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0003\u001e\u000f\u0000\u00a9\u00ab\u0005"+
		"\u001a\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u0015\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ae\u0005,\u0000\u0000\u00ad\u00af\u0003\u0018"+
		"\f\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u00050\u0000\u0000"+
		"\u00b1\u00b2\u0003\u0010\b\u0000\u00b2\u0017\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b5\u0005\u001a\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u0019\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005\u000e\u0000\u0000\u00b9\u00ba\u0003\f\u0006\u0000\u00ba\u00bb"+
		"\u0005\r\u0000\u0000\u00bb\u00bc\u0003\u0010\b\u0000\u00bc\u001b\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005\f\u0000\u0000\u00be\u00bf\u0003\u0010"+
		"\b\u0000\u00bf\u00c0\u0005\u0012\u0000\u0000\u00c0\u00c1\u0003\u0010\b"+
		"\u0000\u00c1\u00c2\u0005\t\u0000\u0000\u00c2\u00c3\u0003\u0010\b\u0000"+
		"\u00c3\u00c4\u0005\u000b\u0000\u0000\u00c4\u001d\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0005\u0018\u0000\u0000\u00c6\u00c8\u0003 \u0010\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u001f\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0019\u0000\u0000\u00ca"+
		"!\u0001\u0000\u0000\u0000\u0015(.068@DKPTYov}\u0083\u009f\u00a1\u00aa"+
		"\u00ae\u00b6\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}