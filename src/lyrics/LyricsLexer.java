// Generated from Lyrics.g4 by ANTLR 4.5.1

package lyrics;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LyricsLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    WORD=1, UNION_OPER=2, DOUBHYPHEN=3, HYPHEN=4, STARS=5, EXTENDERS=6, 
    PIPE=7, WHITESPACE=8, LINESPACE=9;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "WORD", "UNION_OPER", "DOUBHYPHEN", "HYPHEN", "STARS", "EXTENDERS", 
    "PIPE", "WHITESPACE", "LINESPACE"
  };

  private static final String[] _LITERAL_NAMES = {
    null, null, null, "'--'", "'-'", null, null, "'|'", "' '"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, "WORD", "UNION_OPER", "DOUBHYPHEN", "HYPHEN", "STARS", "EXTENDERS", 
    "PIPE", "WHITESPACE", "LINESPACE"
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


      // This method makes the lexer or parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          removeErrorListeners();
          addErrorListener(new ExceptionThrowingErrorListener());
      }

      private static class ExceptionThrowingErrorListener extends BaseErrorListener {
          @Override
          public void syntaxError(Recognizer<?, ?> recognizer,
                  Object offendingSymbol, int line, int charPositionInLine,
                  String msg, RecognitionException e) {
              throw new RuntimeException(msg);
          }
      }


  public LyricsLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Lyrics.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\139\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
      "\2\6\2\27\n\2\r\2\16\2\30\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\5\3"+
      "\5\3\6\6\6&\n\6\r\6\16\6\'\3\7\6\7+\n\7\r\7\16\7,\3\b\3\b\3\t\3\t"+
      "\3\n\6\n\64\n\n\r\n\16\n\65\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r"+
      "\b\17\t\21\n\23\13\3\2\4\n\2##)+..\60\60\62=AAC\\c|\4\2\13\f\17\17"+
      "=\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
      "\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\26\3\2\2\2\5\35"+
      "\3\2\2\2\7\37\3\2\2\2\t\"\3\2\2\2\13%\3\2\2\2\r*\3\2\2\2\17.\3\2\2"+
      "\2\21\60\3\2\2\2\23\63\3\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3"+
      "\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\4\3\2\2\2\32\36\7\u0080\2\2"+
      "\33\34\7^\2\2\34\36\7/\2\2\35\32\3\2\2\2\35\33\3\2\2\2\36\6\3\2\2"+
      "\2\37 \7/\2\2 !\7/\2\2!\b\3\2\2\2\"#\7/\2\2#\n\3\2\2\2$&\7,\2\2%$"+
      "\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\f\3\2\2\2)+\7a\2\2*)\3"+
      "\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\16\3\2\2\2./\7~\2\2/\20\3\2"+
      "\2\2\60\61\7\"\2\2\61\22\3\2\2\2\62\64\t\3\2\2\63\62\3\2\2\2\64\65"+
      "\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\b\n\2\28\24"+
      "\3\2\2\2\t\2\26\30\35\',\65\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}