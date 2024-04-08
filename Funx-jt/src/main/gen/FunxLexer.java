// Generated from /home/damax/Desktop/Potential-thesis-prof-Padovani/Funx-jt/src/main/antlr/FunxLexer.g4 by ANTLR 4.13.1
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
		NEWLINE=1, TAB=2, WS=3, COMMENT=4, MULTICOMMENT=5, ELSE=6, END=7, IF=8, 
		IN=9, LET=10, THEN=11, WITH=12, FUNID=13, BOOLEAN=14, DECIMAL=15, EXPONENT=16, 
		FLOAT=17, Backslash=18, CloseMultiComment=19, Colon=20, Equals=21, OpenMultiComment=22, 
		SemiColon=23, SingleComment=24, UnderScore=25, DotArrow=26, OpenParen=27, 
		CloseParen=28, OpenBracket=29, CloseBracket=30, OpenBrace=31, CloseBrace=32, 
		OpenJavaBrace=33, CloseJavaBrace=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LALPHA", "UALPHA", "ALPHA", "ALPHA_", "DIGIT", "NEWLINE", "TAB", "WS", 
			"COMMENT", "MULTICOMMENT", "ELSE", "END", "IF", "IN", "LET", "THEN", 
			"WITH", "FUNID", "BOOLEAN", "DECIMAL", "EXPONENT", "FLOAT", "Backslash", 
			"CloseMultiComment", "Colon", "Equals", "OpenMultiComment", "SemiColon", 
			"SingleComment", "UnderScore", "DotArrow", "OpenParen", "CloseParen", 
			"OpenBracket", "CloseBracket", "OpenBrace", "CloseBrace", "OpenJavaBrace", 
			"CloseJavaBrace"
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
		"\u0004\u0000\"\u00f6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"&\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002V\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003Z\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0003\u0005_\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005c\b\u0005\u0001\u0006\u0004\u0006f\b\u0006\u000b\u0006"+
		"\f\u0006g\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007m\b\u0007\u000b"+
		"\u0007\f\u0007n\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bu\b\b\n"+
		"\b\f\bx\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t~\b\t\n\t\f\t\u0081"+
		"\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00a7\b\u0011\n\u0011\f\u0011\u00aa\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b5\b\u0012\u0001\u0013\u0004"+
		"\u0013\u00b8\b\u0013\u000b\u0013\f\u0013\u00b9\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00be\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u00c6\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u00cb\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"&\u0001&\u0001&\u0001&\u0001\u007f\u0000\'\u0001\u0000\u0003\u0000\u0005"+
		"\u0000\u0007\u0000\t\u0000\u000b\u0001\r\u0002\u000f\u0003\u0011\u0004"+
		"\u0013\u0005\u0015\u0006\u0017\u0007\u0019\b\u001b\t\u001d\n\u001f\u000b"+
		"!\f#\r%\u000e\'\u000f)\u0010+\u0011-\u0012/\u00131\u00143\u00155\u0016"+
		"7\u00179\u0018;\u0019=\u001a?\u001bA\u001cC\u001dE\u001eG\u001fI K!M\""+
		"\u0001\u0000\b\u0001\u0000az\u0001\u0000AZ\u0001\u000009\u0001\u0000\t"+
		"\t\b\u0000  \u00a0\u00a0\u1680\u1680\u2000\u2000\u200a\u200a\u202f\u202f"+
		"\u205f\u205f\u3000\u3000\u0002\u0000\n\n\r\r\u0002\u0000EEee\u0002\u0000"+
		"++--\u00ff\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C"+
		"\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000"+
		"\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000"+
		"\u0000M\u0001\u0000\u0000\u0000\u0001O\u0001\u0000\u0000\u0000\u0003Q"+
		"\u0001\u0000\u0000\u0000\u0005U\u0001\u0000\u0000\u0000\u0007Y\u0001\u0000"+
		"\u0000\u0000\t[\u0001\u0000\u0000\u0000\u000bb\u0001\u0000\u0000\u0000"+
		"\re\u0001\u0000\u0000\u0000\u000fl\u0001\u0000\u0000\u0000\u0011r\u0001"+
		"\u0000\u0000\u0000\u0013{\u0001\u0000\u0000\u0000\u0015\u0086\u0001\u0000"+
		"\u0000\u0000\u0017\u008b\u0001\u0000\u0000\u0000\u0019\u008f\u0001\u0000"+
		"\u0000\u0000\u001b\u0092\u0001\u0000\u0000\u0000\u001d\u0095\u0001\u0000"+
		"\u0000\u0000\u001f\u0099\u0001\u0000\u0000\u0000!\u009e\u0001\u0000\u0000"+
		"\u0000#\u00a3\u0001\u0000\u0000\u0000%\u00b4\u0001\u0000\u0000\u0000\'"+
		"\u00b7\u0001\u0000\u0000\u0000)\u00bb\u0001\u0000\u0000\u0000+\u00ca\u0001"+
		"\u0000\u0000\u0000-\u00cc\u0001\u0000\u0000\u0000/\u00ce\u0001\u0000\u0000"+
		"\u00001\u00d1\u0001\u0000\u0000\u00003\u00d3\u0001\u0000\u0000\u00005"+
		"\u00d5\u0001\u0000\u0000\u00007\u00d8\u0001\u0000\u0000\u00009\u00da\u0001"+
		"\u0000\u0000\u0000;\u00dd\u0001\u0000\u0000\u0000=\u00df\u0001\u0000\u0000"+
		"\u0000?\u00e2\u0001\u0000\u0000\u0000A\u00e4\u0001\u0000\u0000\u0000C"+
		"\u00e6\u0001\u0000\u0000\u0000E\u00e8\u0001\u0000\u0000\u0000G\u00ea\u0001"+
		"\u0000\u0000\u0000I\u00ec\u0001\u0000\u0000\u0000K\u00ee\u0001\u0000\u0000"+
		"\u0000M\u00f2\u0001\u0000\u0000\u0000OP\u0007\u0000\u0000\u0000P\u0002"+
		"\u0001\u0000\u0000\u0000QR\u0007\u0001\u0000\u0000R\u0004\u0001\u0000"+
		"\u0000\u0000SV\u0003\u0001\u0000\u0000TV\u0003\u0003\u0001\u0000US\u0001"+
		"\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0006\u0001\u0000\u0000"+
		"\u0000WZ\u0003\u0005\u0002\u0000XZ\u0003;\u001d\u0000YW\u0001\u0000\u0000"+
		"\u0000YX\u0001\u0000\u0000\u0000Z\b\u0001\u0000\u0000\u0000[\\\u0007\u0002"+
		"\u0000\u0000\\\n\u0001\u0000\u0000\u0000]_\u0005\r\u0000\u0000^]\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`c\u0005\n\u0000\u0000ac\u0005\r\u0000\u0000b^\u0001\u0000\u0000\u0000"+
		"ba\u0001\u0000\u0000\u0000c\f\u0001\u0000\u0000\u0000df\u0007\u0003\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0006"+
		"\u0006\u0000\u0000j\u000e\u0001\u0000\u0000\u0000km\u0007\u0004\u0000"+
		"\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0006"+
		"\u0007\u0000\u0000q\u0010\u0001\u0000\u0000\u0000rv\u00039\u001c\u0000"+
		"su\b\u0005\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000yz\u0006\b\u0000\u0000z\u0012\u0001\u0000"+
		"\u0000\u0000{\u007f\u00035\u001a\u0000|~\t\u0000\u0000\u0000}|\u0001\u0000"+
		"\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0003/\u0017\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0006\t\u0000\u0000\u0085\u0014"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005e\u0000\u0000\u0087\u0088\u0005"+
		"l\u0000\u0000\u0088\u0089\u0005s\u0000\u0000\u0089\u008a\u0005e\u0000"+
		"\u0000\u008a\u0016\u0001\u0000\u0000\u0000\u008b\u008c\u0005e\u0000\u0000"+
		"\u008c\u008d\u0005n\u0000\u0000\u008d\u008e\u0005d\u0000\u0000\u008e\u0018"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005i\u0000\u0000\u0090\u0091\u0005"+
		"f\u0000\u0000\u0091\u001a\u0001\u0000\u0000\u0000\u0092\u0093\u0005i\u0000"+
		"\u0000\u0093\u0094\u0005n\u0000\u0000\u0094\u001c\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0005l\u0000\u0000\u0096\u0097\u0005e\u0000\u0000\u0097\u0098"+
		"\u0005t\u0000\u0000\u0098\u001e\u0001\u0000\u0000\u0000\u0099\u009a\u0005"+
		"t\u0000\u0000\u009a\u009b\u0005h\u0000\u0000\u009b\u009c\u0005e\u0000"+
		"\u0000\u009c\u009d\u0005n\u0000\u0000\u009d \u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005w\u0000\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0\u00a1\u0005"+
		"t\u0000\u0000\u00a1\u00a2\u0005h\u0000\u0000\u00a2\"\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a8\u0003\u0001\u0000\u0000\u00a4\u00a7\u0003\u0007\u0003"+
		"\u0000\u00a5\u00a7\u0003\t\u0004\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9$\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0005F\u0000\u0000\u00ac\u00ad\u0005a\u0000\u0000\u00ad\u00ae\u0005"+
		"l\u0000\u0000\u00ae\u00af\u0005s\u0000\u0000\u00af\u00b5\u0005e\u0000"+
		"\u0000\u00b0\u00b1\u0005T\u0000\u0000\u00b1\u00b2\u0005r\u0000\u0000\u00b2"+
		"\u00b3\u0005u\u0000\u0000\u00b3\u00b5\u0005e\u0000\u0000\u00b4\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b5&\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b8\u0003\t\u0004\u0000\u00b7\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba(\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0007\u0006\u0000\u0000\u00bc\u00be\u0007\u0007\u0000\u0000"+
		"\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003\'\u0013\u0000\u00c0"+
		"*\u0001\u0000\u0000\u0000\u00c1\u00c2\u0003\'\u0013\u0000\u00c2\u00c3"+
		"\u0005.\u0000\u0000\u00c3\u00c5\u0003\'\u0013\u0000\u00c4\u00c6\u0003"+
		")\u0014\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00cb\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003\'\u0013"+
		"\u0000\u00c8\u00c9\u0003)\u0014\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000"+
		"\u00ca\u00c1\u0001\u0000\u0000\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000"+
		"\u00cb,\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\\\u0000\u0000\u00cd"+
		".\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005.\u0000\u0000\u00cf\u00d0\u0005"+
		"/\u0000\u0000\u00d00\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005:\u0000"+
		"\u0000\u00d22\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005=\u0000\u0000\u00d4"+
		"4\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005/\u0000\u0000\u00d6\u00d7\u0005"+
		".\u0000\u0000\u00d76\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005;\u0000"+
		"\u0000\u00d98\u0001\u0000\u0000\u0000\u00da\u00db\u0005/\u0000\u0000\u00db"+
		"\u00dc\u0005/\u0000\u0000\u00dc:\u0001\u0000\u0000\u0000\u00dd\u00de\u0005"+
		"_\u0000\u0000\u00de<\u0001\u0000\u0000\u0000\u00df\u00e0\u0005.\u0000"+
		"\u0000\u00e0\u00e1\u0005>\u0000\u0000\u00e1>\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005(\u0000\u0000\u00e3@\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005"+
		")\u0000\u0000\u00e5B\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005[\u0000"+
		"\u0000\u00e7D\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005]\u0000\u0000\u00e9"+
		"F\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005{\u0000\u0000\u00ebH\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0005}\u0000\u0000\u00edJ\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005{\u0000\u0000\u00ef\u00f0\u0005{\u0000\u0000\u00f0"+
		"\u00f1\u0005#\u0000\u0000\u00f1L\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005"+
		"#\u0000\u0000\u00f3\u00f4\u0005}\u0000\u0000\u00f4\u00f5\u0005}\u0000"+
		"\u0000\u00f5N\u0001\u0000\u0000\u0000\u0010\u0000UY^bgnv\u007f\u00a6\u00a8"+
		"\u00b4\u00b9\u00bd\u00c5\u00ca\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}