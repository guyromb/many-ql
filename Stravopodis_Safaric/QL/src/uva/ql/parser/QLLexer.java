// Generated from QL.g4 by ANTLR 4.5

	package uva.ql.parser;
	import uva.ql.ast.expressions.*;
	import uva.ql.ast.expressions.literals.*;
	import uva.ql.ast.expressions.math.*;
	import uva.ql.ast.expressions.logic.*;
	import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		BooleanLiteral=10, Identifier=11, Integer=12, Money=13, WS=14, ID_LETTER=15, 
		DIGIT=16, STRING=17, LINE_COMMENT=18, COMMENT=19, MUL=20, DIV=21, ADD=22, 
		SUB=23, LP=24, RP=25, LC=26, RC=27, LESS=28, LESS_EQUAL=29, GREATER=30, 
		GREATER_EQUAL=31, EQUAL=32, LOG_AND=33, LOG_OR=34, NOT_EQUAL=35, NL=36, 
		EXP=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"BooleanLiteral", "Identifier", "Integer", "Money", "WS", "ID_LETTER", 
		"DIGIT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", 
		"SUB", "LP", "RP", "LC", "RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", 
		"EQUAL", "LOG_AND", "LOG_OR", "NOT_EQUAL", "NL", "EXP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'question'", "';'", "':'", "'if'", "'boolean'", "'money'", 
		"'string'", "'integer'", null, null, null, null, null, null, null, null, 
		null, null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'&&'", "'||'", "'!='", null, "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "BooleanLiteral", 
		"Identifier", "Integer", "Money", "WS", "ID_LETTER", "DIGIT", "STRING", 
		"LINE_COMMENT", "COMMENT", "MUL", "DIV", "ADD", "SUB", "LP", "RP", "LC", 
		"RC", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", "EQUAL", "LOG_AND", 
		"LOG_OR", "NOT_EQUAL", "NL", "EXP"
	};
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


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u0109\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u008b\n\13\3\f\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093\13"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009c\n\r\3\16\3\16\3\17\3\17\3\17"+
		"\5\17\u00a3\n\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\7\21\u00ac\n\21\f"+
		"\21\16\21\u00af\13\21\5\21\u00b1\n\21\3\22\3\22\3\22\7\22\u00b6\n\22\f"+
		"\22\16\22\u00b9\13\22\3\22\3\22\3\23\3\23\3\23\5\23\u00c0\n\23\3\24\3"+
		"\24\3\24\3\24\7\24\u00c6\n\24\f\24\16\24\u00c9\13\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\7\25\u00d3\n\25\f\25\16\25\u00d6\13\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\5&\u0104\n&\3&\3&\3\'\3\'\5\u00b7"+
		"\u00c7\u00d4\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\2\'\24)\25+\26-\27/\30\61\31\63\32\65\33"+
		"\67\349\35;\36=\37? A!C\"E#G$I%K&M\'\3\2\5\5\2C\\aac|\3\2\63;\3\2\62;"+
		"\u0115\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5T\3\2\2\2\7]\3\2\2\2\t_\3"+
		"\2\2\2\13a\3\2\2\2\rd\3\2\2\2\17l\3\2\2\2\21r\3\2\2\2\23y\3\2\2\2\25\u008a"+
		"\3\2\2\2\27\u008c\3\2\2\2\31\u009b\3\2\2\2\33\u009d\3\2\2\2\35\u00a2\3"+
		"\2\2\2\37\u00a6\3\2\2\2!\u00b0\3\2\2\2#\u00b2\3\2\2\2%\u00bf\3\2\2\2\'"+
		"\u00c1\3\2\2\2)\u00ce\3\2\2\2+\u00dc\3\2\2\2-\u00de\3\2\2\2/\u00e0\3\2"+
		"\2\2\61\u00e2\3\2\2\2\63\u00e4\3\2\2\2\65\u00e6\3\2\2\2\67\u00e8\3\2\2"+
		"\29\u00ea\3\2\2\2;\u00ec\3\2\2\2=\u00ee\3\2\2\2?\u00f1\3\2\2\2A\u00f3"+
		"\3\2\2\2C\u00f6\3\2\2\2E\u00f9\3\2\2\2G\u00fc\3\2\2\2I\u00ff\3\2\2\2K"+
		"\u0103\3\2\2\2M\u0107\3\2\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2RS\7o\2\2S\4\3"+
		"\2\2\2TU\7s\2\2UV\7w\2\2VW\7g\2\2WX\7u\2\2XY\7v\2\2YZ\7k\2\2Z[\7q\2\2"+
		"[\\\7p\2\2\\\6\3\2\2\2]^\7=\2\2^\b\3\2\2\2_`\7<\2\2`\n\3\2\2\2ab\7k\2"+
		"\2bc\7h\2\2c\f\3\2\2\2de\7d\2\2ef\7q\2\2fg\7q\2\2gh\7n\2\2hi\7g\2\2ij"+
		"\7c\2\2jk\7p\2\2k\16\3\2\2\2lm\7o\2\2mn\7q\2\2no\7p\2\2op\7g\2\2pq\7{"+
		"\2\2q\20\3\2\2\2rs\7u\2\2st\7v\2\2tu\7t\2\2uv\7k\2\2vw\7p\2\2wx\7i\2\2"+
		"x\22\3\2\2\2yz\7k\2\2z{\7p\2\2{|\7v\2\2|}\7g\2\2}~\7i\2\2~\177\7g\2\2"+
		"\177\u0080\7t\2\2\u0080\24\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7t\2"+
		"\2\u0083\u0084\7w\2\2\u0084\u008b\7g\2\2\u0085\u0086\7h\2\2\u0086\u0087"+
		"\7c\2\2\u0087\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089\u008b\7g\2\2\u008a"+
		"\u0081\3\2\2\2\u008a\u0085\3\2\2\2\u008b\26\3\2\2\2\u008c\u0091\5\37\20"+
		"\2\u008d\u0090\5\37\20\2\u008e\u0090\5!\21\2\u008f\u008d\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\30\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u009c\5!\21\2\u0095\u0096"+
		"\7*\2\2\u0096\u0097\7/\2\2\u0097\u0098\3\2\2\2\u0098\u0099\5!\21\2\u0099"+
		"\u009a\7+\2\2\u009a\u009c\3\2\2\2\u009b\u0094\3\2\2\2\u009b\u0095\3\2"+
		"\2\2\u009c\32\3\2\2\2\u009d\u009e\5\31\r\2\u009e\34\3\2\2\2\u009f\u00a3"+
		"\7\"\2\2\u00a0\u00a3\5K&\2\u00a1\u00a3\7\13\2\2\u00a2\u009f\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\17"+
		"\2\2\u00a5\36\3\2\2\2\u00a6\u00a7\t\2\2\2\u00a7 \3\2\2\2\u00a8\u00b1\7"+
		"\62\2\2\u00a9\u00ad\t\3\2\2\u00aa\u00ac\t\4\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b0\u00a9\3\2\2\2\u00b1"+
		"\"\3\2\2\2\u00b2\u00b7\7$\2\2\u00b3\u00b6\5%\23\2\u00b4\u00b6\13\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bb\7$\2\2\u00bb$\3\2\2\2\u00bc\u00c0\7^\2\2\u00bd\u00be\7^\2\2\u00be"+
		"\u00c0\7^\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0&\3\2\2\2\u00c1"+
		"\u00c2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6\13"+
		"\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\f"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\24\2\2\u00cd(\3\2\2\2\u00ce\u00cf"+
		"\7\61\2\2\u00cf\u00d0\7,\2\2\u00d0\u00d4\3\2\2\2\u00d1\u00d3\13\2\2\2"+
		"\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7,\2\2\u00d8"+
		"\u00d9\7\61\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b\25\2\2\u00db*\3\2\2"+
		"\2\u00dc\u00dd\7,\2\2\u00dd,\3\2\2\2\u00de\u00df\7\61\2\2\u00df.\3\2\2"+
		"\2\u00e0\u00e1\7-\2\2\u00e1\60\3\2\2\2\u00e2\u00e3\7/\2\2\u00e3\62\3\2"+
		"\2\2\u00e4\u00e5\7*\2\2\u00e5\64\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7\66\3"+
		"\2\2\2\u00e8\u00e9\7}\2\2\u00e98\3\2\2\2\u00ea\u00eb\7\177\2\2\u00eb:"+
		"\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed<\3\2\2\2\u00ee\u00ef\7>\2\2\u00ef\u00f0"+
		"\7?\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7@\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7"+
		"@\2\2\u00f4\u00f5\7?\2\2\u00f5B\3\2\2\2\u00f6\u00f7\7?\2\2\u00f7\u00f8"+
		"\7?\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7(\2\2\u00fa\u00fb\7(\2\2\u00fbF\3"+
		"\2\2\2\u00fc\u00fd\7~\2\2\u00fd\u00fe\7~\2\2\u00feH\3\2\2\2\u00ff\u0100"+
		"\7#\2\2\u0100\u0101\7?\2\2\u0101J\3\2\2\2\u0102\u0104\7\17\2\2\u0103\u0102"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7\f\2\2\u0106"+
		"L\3\2\2\2\u0107\u0108\7`\2\2\u0108N\3\2\2\2\20\2\u008a\u008f\u0091\u009b"+
		"\u00a2\u00ad\u00b0\u00b5\u00b7\u00bf\u00c7\u00d4\u0103\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}