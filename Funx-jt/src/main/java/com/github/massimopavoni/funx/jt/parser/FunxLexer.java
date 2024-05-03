// Generated from FunxLexer.g4 by ANTLR 4.13.1
package com.github.massimopavoni.funx.jt.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FunxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, TAB=2, WS=3, CloseMultiComment=4, OpenMultiComment=5, SingleComment=6, 
		COMMENT=7, MULTICOMMENT=8, ELSE=9, END=10, FI=11, IF=12, IN=13, LET=14, 
		OUT=15, THEN=16, WITH=17, VARID=18, TYPE=19, BOOLTYPE=20, INTTYPE=21, 
		BOOL=22, INT=23, And=24, Or=25, Not=26, EqualsEquals=27, GreaterThan=28, 
		GreaterThanEquals=29, LessThan=30, LessThanEquals=31, NotEquals=32, Add=33, 
		Divide=34, Modulo=35, Multiply=36, Subtract=37, Backslash=38, Colon=39, 
		Equals=40, UnderScore=41, Arrow=42, OpenParen=43, CloseParen=44, OpenBracket=45, 
		CloseBracket=46, OpenBrace=47, CloseBrace=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LALPHA", "UALPHA", "ALPHA", "ALPHA_", "DIGIT", "DECIMAL", "NEWLINE", 
			"TAB", "WS", "CloseMultiComment", "OpenMultiComment", "SingleComment", 
			"COMMENT", "MULTICOMMENT", "ELSE", "END", "FI", "IF", "IN", "LET", "OUT", 
			"THEN", "WITH", "VARID", "TYPE", "BOOLTYPE", "INTTYPE", "BOOL", "INT", 
			"And", "Or", "Not", "EqualsEquals", "GreaterThan", "GreaterThanEquals", 
			"LessThan", "LessThanEquals", "NotEquals", "Add", "Divide", "Modulo", 
			"Multiply", "Subtract", "Backslash", "Colon", "Equals", "UnderScore", 
			"Arrow", "OpenParen", "CloseParen", "OpenBracket", "CloseBracket", "OpenBrace", 
			"CloseBrace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'./'", "'/.'", "'//'", null, null, "'else'", 
			"'end'", "'fi'", "'if'", "'in'", "'let'", "'out'", "'then'", "'with'", 
			null, null, "'Bool'", "'Int'", null, null, "'&&'", "'||'", "'!!'", "'=='", 
			"'>'", "'>='", "'<'", "'<='", "'!='", "'+'", "'/'", "'%'", "'*'", "'-'", 
			"'\\'", "':'", "'='", "'_'", "'->'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "CloseMultiComment", "OpenMultiComment", 
			"SingleComment", "COMMENT", "MULTICOMMENT", "ELSE", "END", "FI", "IF", 
			"IN", "LET", "OUT", "THEN", "WITH", "VARID", "TYPE", "BOOLTYPE", "INTTYPE", 
			"BOOL", "INT", "And", "Or", "Not", "EqualsEquals", "GreaterThan", "GreaterThanEquals", 
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


	public FunxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FunxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u00000\u0138\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002t\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003x\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0004\u0005}\b\u0005\u000b\u0005\f\u0005"+
		"~\u0001\u0006\u0003\u0006\u0082\b\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u0086\b\u0006\u0001\u0007\u0004\u0007\u0089\b\u0007\u000b\u0007"+
		"\f\u0007\u008a\u0001\u0007\u0001\u0007\u0001\b\u0004\b\u0090\b\b\u000b"+
		"\b\f\b\u0091\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\f\u00a1\b"+
		"\f\n\f\f\f\u00a4\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u00aa\b\r"+
		"\n\r\f\r\u00ad\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u00da\b\u0017\n\u0017\f\u0017\u00dd\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u00e1\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00f5\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u00fd\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		")\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001"+
		".\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00011\u00011\u00012\u0001"+
		"2\u00013\u00013\u00014\u00014\u00015\u00015\u0001\u00ab\u00006\u0001\u0000"+
		"\u0003\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b\u0000\r\u0001\u000f"+
		"\u0002\u0011\u0003\u0013\u0004\u0015\u0005\u0017\u0006\u0019\u0007\u001b"+
		"\b\u001d\t\u001f\n!\u000b#\f%\r\'\u000e)\u000f+\u0010-\u0011/\u00121\u0013"+
		"3\u00145\u00157\u00169\u0017;\u0018=\u0019?\u001aA\u001bC\u001cE\u001d"+
		"G\u001eI\u001fK M!O\"Q#S$U%W&Y\'[(])_*a+c,e-g.i/k0\u0001\u0000\u0006\u0001"+
		"\u0000az\u0001\u0000AZ\u0001\u000009\u0001\u0000\t\t\b\u0000  \u00a0\u00a0"+
		"\u1680\u1680\u2000\u2000\u200a\u200a\u202f\u202f\u205f\u205f\u3000\u3000"+
		"\u0002\u0000\n\n\r\r\u013f\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000"+
		"I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001"+
		"\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000"+
		"\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000"+
		"W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001"+
		"\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000"+
		"\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000"+
		"e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001"+
		"\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0001m\u0001\u0000\u0000"+
		"\u0000\u0003o\u0001\u0000\u0000\u0000\u0005s\u0001\u0000\u0000\u0000\u0007"+
		"w\u0001\u0000\u0000\u0000\ty\u0001\u0000\u0000\u0000\u000b|\u0001\u0000"+
		"\u0000\u0000\r\u0085\u0001\u0000\u0000\u0000\u000f\u0088\u0001\u0000\u0000"+
		"\u0000\u0011\u008f\u0001\u0000\u0000\u0000\u0013\u0095\u0001\u0000\u0000"+
		"\u0000\u0015\u0098\u0001\u0000\u0000\u0000\u0017\u009b\u0001\u0000\u0000"+
		"\u0000\u0019\u009e\u0001\u0000\u0000\u0000\u001b\u00a7\u0001\u0000\u0000"+
		"\u0000\u001d\u00b2\u0001\u0000\u0000\u0000\u001f\u00b7\u0001\u0000\u0000"+
		"\u0000!\u00bb\u0001\u0000\u0000\u0000#\u00be\u0001\u0000\u0000\u0000%"+
		"\u00c1\u0001\u0000\u0000\u0000\'\u00c4\u0001\u0000\u0000\u0000)\u00c8"+
		"\u0001\u0000\u0000\u0000+\u00cc\u0001\u0000\u0000\u0000-\u00d1\u0001\u0000"+
		"\u0000\u0000/\u00d6\u0001\u0000\u0000\u00001\u00e0\u0001\u0000\u0000\u0000"+
		"3\u00e2\u0001\u0000\u0000\u00005\u00e7\u0001\u0000\u0000\u00007\u00f4"+
		"\u0001\u0000\u0000\u00009\u00fc\u0001\u0000\u0000\u0000;\u00fe\u0001\u0000"+
		"\u0000\u0000=\u0101\u0001\u0000\u0000\u0000?\u0104\u0001\u0000\u0000\u0000"+
		"A\u0107\u0001\u0000\u0000\u0000C\u010a\u0001\u0000\u0000\u0000E\u010c"+
		"\u0001\u0000\u0000\u0000G\u010f\u0001\u0000\u0000\u0000I\u0111\u0001\u0000"+
		"\u0000\u0000K\u0114\u0001\u0000\u0000\u0000M\u0117\u0001\u0000\u0000\u0000"+
		"O\u0119\u0001\u0000\u0000\u0000Q\u011b\u0001\u0000\u0000\u0000S\u011d"+
		"\u0001\u0000\u0000\u0000U\u011f\u0001\u0000\u0000\u0000W\u0121\u0001\u0000"+
		"\u0000\u0000Y\u0123\u0001\u0000\u0000\u0000[\u0125\u0001\u0000\u0000\u0000"+
		"]\u0127\u0001\u0000\u0000\u0000_\u0129\u0001\u0000\u0000\u0000a\u012c"+
		"\u0001\u0000\u0000\u0000c\u012e\u0001\u0000\u0000\u0000e\u0130\u0001\u0000"+
		"\u0000\u0000g\u0132\u0001\u0000\u0000\u0000i\u0134\u0001\u0000\u0000\u0000"+
		"k\u0136\u0001\u0000\u0000\u0000mn\u0007\u0000\u0000\u0000n\u0002\u0001"+
		"\u0000\u0000\u0000op\u0007\u0001\u0000\u0000p\u0004\u0001\u0000\u0000"+
		"\u0000qt\u0003\u0001\u0000\u0000rt\u0003\u0003\u0001\u0000sq\u0001\u0000"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0006\u0001\u0000\u0000\u0000"+
		"ux\u0003\u0005\u0002\u0000vx\u0003].\u0000wu\u0001\u0000\u0000\u0000w"+
		"v\u0001\u0000\u0000\u0000x\b\u0001\u0000\u0000\u0000yz\u0007\u0002\u0000"+
		"\u0000z\n\u0001\u0000\u0000\u0000{}\u0003\t\u0004\u0000|{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\f\u0001\u0000\u0000\u0000\u0080\u0082\u0005"+
		"\r\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0086\u0005\n\u0000"+
		"\u0000\u0084\u0086\u0005\r\u0000\u0000\u0085\u0081\u0001\u0000\u0000\u0000"+
		"\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u000e\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0007\u0003\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0006\u0007\u0000\u0000\u008d\u0010\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0007\u0004\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0006\b\u0000\u0000\u0094\u0012\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0005.\u0000\u0000\u0096\u0097\u0005/\u0000\u0000\u0097\u0014\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0005/\u0000\u0000\u0099\u009a\u0005.\u0000"+
		"\u0000\u009a\u0016\u0001\u0000\u0000\u0000\u009b\u009c\u0005/\u0000\u0000"+
		"\u009c\u009d\u0005/\u0000\u0000\u009d\u0018\u0001\u0000\u0000\u0000\u009e"+
		"\u00a2\u0003\u0017\u000b\u0000\u009f\u00a1\b\u0005\u0000\u0000\u00a0\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0006\f\u0000\u0000\u00a6\u001a\u0001\u0000\u0000\u0000\u00a7\u00ab\u0003"+
		"\u0015\n\u0000\u00a8\u00aa\t\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0003\u0013"+
		"\t\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\r\u0000"+
		"\u0000\u00b1\u001c\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005e\u0000\u0000"+
		"\u00b3\u00b4\u0005l\u0000\u0000\u00b4\u00b5\u0005s\u0000\u0000\u00b5\u00b6"+
		"\u0005e\u0000\u0000\u00b6\u001e\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"+
		"e\u0000\u0000\u00b8\u00b9\u0005n\u0000\u0000\u00b9\u00ba\u0005d\u0000"+
		"\u0000\u00ba \u0001\u0000\u0000\u0000\u00bb\u00bc\u0005f\u0000\u0000\u00bc"+
		"\u00bd\u0005i\u0000\u0000\u00bd\"\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0005i\u0000\u0000\u00bf\u00c0\u0005f\u0000\u0000\u00c0$\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005i\u0000\u0000\u00c2\u00c3\u0005n\u0000\u0000"+
		"\u00c3&\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005l\u0000\u0000\u00c5\u00c6"+
		"\u0005e\u0000\u0000\u00c6\u00c7\u0005t\u0000\u0000\u00c7(\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0005o\u0000\u0000\u00c9\u00ca\u0005u\u0000\u0000"+
		"\u00ca\u00cb\u0005t\u0000\u0000\u00cb*\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0005t\u0000\u0000\u00cd\u00ce\u0005h\u0000\u0000\u00ce\u00cf\u0005e"+
		"\u0000\u0000\u00cf\u00d0\u0005n\u0000\u0000\u00d0,\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005w\u0000\u0000\u00d2\u00d3\u0005i\u0000\u0000\u00d3\u00d4"+
		"\u0005t\u0000\u0000\u00d4\u00d5\u0005h\u0000\u0000\u00d5.\u0001\u0000"+
		"\u0000\u0000\u00d6\u00db\u0003\u0001\u0000\u0000\u00d7\u00da\u0003\u0007"+
		"\u0003\u0000\u00d8\u00da\u0003\t\u0004\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000"+
		"\u0000\u00dc0\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00e1\u00033\u0019\u0000\u00df\u00e1\u00035\u001a\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e12\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005B\u0000\u0000\u00e3\u00e4\u0005o\u0000"+
		"\u0000\u00e4\u00e5\u0005o\u0000\u0000\u00e5\u00e6\u0005l\u0000\u0000\u00e6"+
		"4\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005I\u0000\u0000\u00e8\u00e9\u0005"+
		"n\u0000\u0000\u00e9\u00ea\u0005t\u0000\u0000\u00ea6\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0005F\u0000\u0000\u00ec\u00ed\u0005a\u0000\u0000\u00ed"+
		"\u00ee\u0005l\u0000\u0000\u00ee\u00ef\u0005s\u0000\u0000\u00ef\u00f5\u0005"+
		"e\u0000\u0000\u00f0\u00f1\u0005T\u0000\u0000\u00f1\u00f2\u0005r\u0000"+
		"\u0000\u00f2\u00f3\u0005u\u0000\u0000\u00f3\u00f5\u0005e\u0000\u0000\u00f4"+
		"\u00eb\u0001\u0000\u0000\u0000\u00f4\u00f0\u0001\u0000\u0000\u0000\u00f5"+
		"8\u0001\u0000\u0000\u0000\u00f6\u00fd\u0003\u000b\u0005\u0000\u00f7\u00f8"+
		"\u0003a0\u0000\u00f8\u00f9\u0005-\u0000\u0000\u00f9\u00fa\u0003\u000b"+
		"\u0005\u0000\u00fa\u00fb\u0003c1\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fc\u00f6\u0001\u0000\u0000\u0000\u00fc\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fd:\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005&\u0000\u0000\u00ff\u0100"+
		"\u0005&\u0000\u0000\u0100<\u0001\u0000\u0000\u0000\u0101\u0102\u0005|"+
		"\u0000\u0000\u0102\u0103\u0005|\u0000\u0000\u0103>\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005!\u0000\u0000\u0105\u0106\u0005!\u0000\u0000\u0106@"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0005=\u0000\u0000\u0108\u0109\u0005"+
		"=\u0000\u0000\u0109B\u0001\u0000\u0000\u0000\u010a\u010b\u0005>\u0000"+
		"\u0000\u010bD\u0001\u0000\u0000\u0000\u010c\u010d\u0005>\u0000\u0000\u010d"+
		"\u010e\u0005=\u0000\u0000\u010eF\u0001\u0000\u0000\u0000\u010f\u0110\u0005"+
		"<\u0000\u0000\u0110H\u0001\u0000\u0000\u0000\u0111\u0112\u0005<\u0000"+
		"\u0000\u0112\u0113\u0005=\u0000\u0000\u0113J\u0001\u0000\u0000\u0000\u0114"+
		"\u0115\u0005!\u0000\u0000\u0115\u0116\u0005=\u0000\u0000\u0116L\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0005+\u0000\u0000\u0118N\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0005/\u0000\u0000\u011aP\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u0005%\u0000\u0000\u011cR\u0001\u0000\u0000\u0000\u011d\u011e\u0005"+
		"*\u0000\u0000\u011eT\u0001\u0000\u0000\u0000\u011f\u0120\u0005-\u0000"+
		"\u0000\u0120V\u0001\u0000\u0000\u0000\u0121\u0122\u0005\\\u0000\u0000"+
		"\u0122X\u0001\u0000\u0000\u0000\u0123\u0124\u0005:\u0000\u0000\u0124Z"+
		"\u0001\u0000\u0000\u0000\u0125\u0126\u0005=\u0000\u0000\u0126\\\u0001"+
		"\u0000\u0000\u0000\u0127\u0128\u0005_\u0000\u0000\u0128^\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0005-\u0000\u0000\u012a\u012b\u0005>\u0000\u0000\u012b"+
		"`\u0001\u0000\u0000\u0000\u012c\u012d\u0005(\u0000\u0000\u012db\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0005)\u0000\u0000\u012fd\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0005[\u0000\u0000\u0131f\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0005]\u0000\u0000\u0133h\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"{\u0000\u0000\u0135j\u0001\u0000\u0000\u0000\u0136\u0137\u0005}\u0000"+
		"\u0000\u0137l\u0001\u0000\u0000\u0000\u000f\u0000sw~\u0081\u0085\u008a"+
		"\u0091\u00a2\u00ab\u00d9\u00db\u00e0\u00f4\u00fc\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}