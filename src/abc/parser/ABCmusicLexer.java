// Generated from ABCmusic.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ABCmusicLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, EOL=2, WHITESPACE=3, INDEX=4, TITLE=5, COMPOSER=6, LENGTH=7, 
    METER=8, TEMPO=9, VOICE=10, KEY=11;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "TEXT", "DIGIT", "FRACTION", "EOL", "WHITESPACE", "INDEX", "TITLE", 
    "COMPOSER", "LENGTH", "METER", "TEMPO", "VOICE", "KEY"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'+'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, "EOL", "WHITESPACE", "INDEX", "TITLE", "COMPOSER", "LENGTH", 
    "METER", "TEMPO", "VOICE", "KEY"
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


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }


  public ABCmusicLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "ABCmusic.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\u00cf\b\1\4\2"+
      "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
      "\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\6\3#"+
      "\n\3\r\3\16\3$\3\4\6\4(\n\4\r\4\16\4)\3\5\3\5\3\5\3\5\3\6\5\6\61\n"+
      "\6\3\6\6\6\64\n\6\r\6\16\6\65\3\7\6\79\n\7\r\7\16\7:\3\7\3\7\3\b\3"+
      "\b\3\b\3\b\7\bC\n\b\f\b\16\bF\13\b\3\b\3\b\7\bJ\n\b\f\b\16\bM\13\b"+
      "\3\b\3\b\3\t\3\t\3\t\3\t\7\tU\n\t\f\t\16\tX\13\t\3\t\3\t\7\t\\\n\t"+
      "\f\t\16\t_\13\t\3\t\3\t\3\n\3\n\3\n\3\n\7\ng\n\n\f\n\16\nj\13\n\3"+
      "\n\3\n\7\nn\n\n\f\n\16\nq\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13y\n"+
      "\13\f\13\16\13|\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0085\n\f"+
      "\f\f\16\f\u0088\13\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\f\7\f\u0091\n"+
      "\f\f\f\16\f\u0094\13\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u009c\n\r\f\r\16"+
      "\r\u009f\13\r\3\r\3\r\3\r\3\r\7\r\u00a5\n\r\f\r\16\r\u00a8\13\r\3"+
      "\r\3\r\3\16\3\16\3\16\3\16\7\16\u00b0\n\16\f\16\16\16\u00b3\13\16"+
      "\3\16\3\16\7\16\u00b7\n\16\f\16\16\16\u00ba\13\16\3\16\3\16\3\17\3"+
      "\17\3\17\3\17\7\17\u00c2\n\17\f\17\16\17\u00c5\13\17\3\17\3\17\7\17"+
      "\u00c9\n\17\f\17\16\17\u00cc\13\17\3\17\3\17\2\2\20\3\3\5\2\7\2\t"+
      "\2\13\4\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\3\2\5\4\2\f\f"+
      "\17\17\3\2\62;\4\2\13\13\"\"\u00e1\2\3\3\2\2\2\2\13\3\2\2\2\2\r\3"+
      "\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
      "\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5\"\3\2"+
      "\2\2\7\'\3\2\2\2\t+\3\2\2\2\13\63\3\2\2\2\r8\3\2\2\2\17>\3\2\2\2\21"+
      "P\3\2\2\2\23b\3\2\2\2\25t\3\2\2\2\27\u0080\3\2\2\2\31\u0097\3\2\2"+
      "\2\33\u00ab\3\2\2\2\35\u00bd\3\2\2\2\37 \7-\2\2 \4\3\2\2\2!#\n\2\2"+
      "\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\6\3\2\2\2&(\t\3\2\2"+
      "\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\b\3\2\2\2+,\5\7\4\2,-"+
      "\7\61\2\2-.\5\7\4\2.\n\3\2\2\2/\61\7\17\2\2\60/\3\2\2\2\60\61\3\2"+
      "\2\2\61\62\3\2\2\2\62\64\7\f\2\2\63\60\3\2\2\2\64\65\3\2\2\2\65\63"+
      "\3\2\2\2\65\66\3\2\2\2\66\f\3\2\2\2\679\t\4\2\28\67\3\2\2\29:\3\2"+
      "\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\b\7\2\2=\16\3\2\2\2>?\7Z\2\2"+
      "?@\7<\2\2@D\3\2\2\2AC\7\"\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2"+
      "\2\2EG\3\2\2\2FD\3\2\2\2GK\5\7\4\2HJ\7\"\2\2IH\3\2\2\2JM\3\2\2\2K"+
      "I\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\5\13\6\2O\20\3\2\2\2PQ\7"+
      "V\2\2QR\7<\2\2RV\3\2\2\2SU\7\"\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2V"+
      "W\3\2\2\2WY\3\2\2\2XV\3\2\2\2Y]\5\5\3\2Z\\\7\"\2\2[Z\3\2\2\2\\_\3"+
      "\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\5\13\6\2a\22\3\2"+
      "\2\2bc\7E\2\2cd\7<\2\2dh\3\2\2\2eg\7\"\2\2fe\3\2\2\2gj\3\2\2\2hf\3"+
      "\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2ko\5\5\3\2ln\7\"\2\2ml\3\2\2\2"+
      "nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\5\13\6\2s\24"+
      "\3\2\2\2tu\7N\2\2uv\7<\2\2vz\3\2\2\2wy\7\"\2\2xw\3\2\2\2y|\3\2\2\2"+
      "zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\5\t\5\2~\177\5\13\6\2\177"+
      "\26\3\2\2\2\u0080\u0081\7O\2\2\u0081\u0082\7<\2\2\u0082\u0086\3\2"+
      "\2\2\u0083\u0085\7\"\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
      "\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008d\3\2\2\2\u0088\u0086"+
      "\3\2\2\2\u0089\u008e\7E\2\2\u008a\u008b\7E\2\2\u008b\u008e\7~\2\2"+
      "\u008c\u008e\5\t\5\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
      "\u008c\3\2\2\2\u008e\u0092\3\2\2\2\u008f\u0091\7\"\2\2\u0090\u008f"+
      "\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2"+
      "\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\5\13\6\2\u0096"+
      "\30\3\2\2\2\u0097\u0098\7S\2\2\u0098\u0099\7<\2\2\u0099\u009d\3\2"+
      "\2\2\u009a\u009c\7\"\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
      "\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d"+
      "\3\2\2\2\u00a0\u00a1\5\t\5\2\u00a1\u00a2\7?\2\2\u00a2\u00a6\5\7\4"+
      "\2\u00a3\u00a5\7\"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
      "\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6"+
      "\3\2\2\2\u00a9\u00aa\5\13\6\2\u00aa\32\3\2\2\2\u00ab\u00ac\7X\2\2"+
      "\u00ac\u00ad\7<\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\7\"\2\2\u00af"+
      "\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
      "\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b8\5\5\3"+
      "\2\u00b5\u00b7\7\"\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
      "\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8"+
      "\3\2\2\2\u00bb\u00bc\5\13\6\2\u00bc\34\3\2\2\2\u00bd\u00be\7M\2\2"+
      "\u00be\u00bf\7<\2\2\u00bf\u00c3\3\2\2\2\u00c0\u00c2\7\"\2\2\u00c1"+
      "\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
      "\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00ca\5\5\3"+
      "\2\u00c7\u00c9\7\"\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
      "\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca"+
      "\3\2\2\2\u00cd\u00ce\5\13\6\2\u00ce\36\3\2\2\2\30\2$)\60\65:DKV]h"+
      "oz\u0086\u008d\u0092\u009d\u00a6\u00b1\u00b8\u00c3\u00ca\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}