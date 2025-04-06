// Generated from Lyrics.g4 by ANTLR 4.5.1

package lyrics;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LyricsParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    WORD=1, UNION_OPER=2, DOUBHYPHEN=3, HYPHEN=4, STARS=5, EXTENDERS=6, 
    PIPE=7, WHITESPACE=8, LINESPACE=9;
  public static final int
    RULE_lyric = 0, RULE_measure = 1, RULE_syllable = 2;
  public static final String[] ruleNames = {
    "lyric", "measure", "syllable"
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

  @Override
  public String getGrammarFileName() { return "Lyrics.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public LyricsParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class LyricContext extends ParserRuleContext {
    public List<MeasureContext> measure() {
      return getRuleContexts(MeasureContext.class);
    }
    public MeasureContext measure(int i) {
      return getRuleContext(MeasureContext.class,i);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(LyricsParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(LyricsParser.WHITESPACE, i);
    }
    public TerminalNode EOF() { return getToken(LyricsParser.EOF, 0); }
    public LyricContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_lyric; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).enterLyric(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).exitLyric(this);
    }
  }

  public final LyricContext lyric() throws RecognitionException {
    LyricContext _localctx = new LyricContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_lyric);
    int _la;
    try {
      int _alt;
      setState(18);
      switch (_input.LA(1)) {
      case WORD:
      case STARS:
      case PIPE:
      case WHITESPACE:
        enterOuterAlt(_localctx, 1);
        {
        setState(7); 
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
          case 1:
            {
            {
            setState(6);
            measure();
            }
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          setState(9); 
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,0,_ctx);
        } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
        setState(14);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la==WHITESPACE) {
          {
          {
          setState(11);
          match(WHITESPACE);
          }
          }
          setState(16);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        }
        break;
      case EOF:
        enterOuterAlt(_localctx, 2);
        {
        setState(17);
        match(EOF);
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

  public static class MeasureContext extends ParserRuleContext {
    public List<TerminalNode> PIPE() { return getTokens(LyricsParser.PIPE); }
    public TerminalNode PIPE(int i) {
      return getToken(LyricsParser.PIPE, i);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(LyricsParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(LyricsParser.WHITESPACE, i);
    }
    public List<SyllableContext> syllable() {
      return getRuleContexts(SyllableContext.class);
    }
    public SyllableContext syllable(int i) {
      return getRuleContext(SyllableContext.class,i);
    }
    public MeasureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).enterMeasure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).exitMeasure(this);
    }
  }

  public final MeasureContext measure() throws RecognitionException {
    MeasureContext _localctx = new MeasureContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_measure);
    int _la;
    try {
      int _alt;
      setState(50);
      switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(21);
        _la = _input.LA(1);
        if (_la==PIPE) {
          {
          setState(20);
          match(PIPE);
          }
        }

        setState(26);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la==WHITESPACE) {
          {
          {
          setState(23);
          match(WHITESPACE);
          }
          }
          setState(28);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(36); 
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
          case 1:
            {
            {
            setState(29);
            syllable();
            setState(33);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input,5,_ctx);
            while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
              if ( _alt==1 ) {
                {
                {
                setState(30);
                match(WHITESPACE);
                }
                } 
              }
              setState(35);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input,5,_ctx);
            }
            }
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          setState(38); 
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,6,_ctx);
        } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
        setState(41);
        switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
        case 1:
          {
          setState(40);
          match(PIPE);
          }
          break;
        }
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(43);
        match(PIPE);
        setState(47);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,8,_ctx);
        while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
          if ( _alt==1 ) {
            {
            {
            setState(44);
            match(WHITESPACE);
            }
            } 
          }
          setState(49);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,8,_ctx);
        }
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

  public static class SyllableContext extends ParserRuleContext {
    public TerminalNode WORD() { return getToken(LyricsParser.WORD, 0); }
    public TerminalNode HYPHEN() { return getToken(LyricsParser.HYPHEN, 0); }
    public TerminalNode WHITESPACE() { return getToken(LyricsParser.WHITESPACE, 0); }
    public TerminalNode EXTENDERS() { return getToken(LyricsParser.EXTENDERS, 0); }
    public TerminalNode DOUBHYPHEN() { return getToken(LyricsParser.DOUBHYPHEN, 0); }
    public TerminalNode UNION_OPER() { return getToken(LyricsParser.UNION_OPER, 0); }
    public TerminalNode STARS() { return getToken(LyricsParser.STARS, 0); }
    public SyllableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_syllable; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).enterSyllable(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof LyricsListener ) ((LyricsListener)listener).exitSyllable(this);
    }
  }

  public final SyllableContext syllable() throws RecognitionException {
    SyllableContext _localctx = new SyllableContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_syllable);
    int _la;
    try {
      setState(68);
      switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(52);
        match(WORD);
        setState(54);
        _la = _input.LA(1);
        if (_la==WHITESPACE) {
          {
          setState(53);
          match(WHITESPACE);
          }
        }

        setState(56);
        match(HYPHEN);
        setState(58);
        _la = _input.LA(1);
        if (_la==EXTENDERS) {
          {
          setState(57);
          match(EXTENDERS);
          }
        }

        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(60);
        match(WORD);
        setState(61);
        match(DOUBHYPHEN);
        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        setState(62);
        match(WORD);
        setState(63);
        match(UNION_OPER);
        }
        break;
      case 4:
        enterOuterAlt(_localctx, 4);
        {
        setState(64);
        match(WORD);
        setState(65);
        match(EXTENDERS);
        }
        break;
      case 5:
        enterOuterAlt(_localctx, 5);
        {
        setState(66);
        match(WORD);
        }
        break;
      case 6:
        enterOuterAlt(_localctx, 6);
        {
        setState(67);
        match(STARS);
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13I\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\2\7\2\17\n\2\f\2\16\2\22"+
      "\13\2\3\2\5\2\25\n\2\3\3\5\3\30\n\3\3\3\7\3\33\n\3\f\3\16\3\36\13"+
      "\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\6\3\'\n\3\r\3\16\3(\3\3\5\3,\n"+
      "\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3\5\3\65\n\3\3\4\3\4\5\49\n\4"+
      "\3\4\3\4\5\4=\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4G\n\4\3\4\2\2"+
      "\5\2\4\6\2\2V\2\24\3\2\2\2\4\64\3\2\2\2\6F\3\2\2\2\b\n\5\4\3\2\t\b"+
      "\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\20\3\2\2\2\r\17"+
      "\7\n\2\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21"+
      "\25\3\2\2\2\22\20\3\2\2\2\23\25\7\2\2\3\24\t\3\2\2\2\24\23\3\2\2\2"+
      "\25\3\3\2\2\2\26\30\7\t\2\2\27\26\3\2\2\2\27\30\3\2\2\2\30\34\3\2"+
      "\2\2\31\33\7\n\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35"+
      "\3\2\2\2\35&\3\2\2\2\36\34\3\2\2\2\37#\5\6\4\2 \"\7\n\2\2! \3\2\2"+
      "\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\'\3\2\2\2%#\3\2\2\2&\37\3\2\2\2"+
      "\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*,\7\t\2\2+*\3\2\2\2+,\3"+
      "\2\2\2,\65\3\2\2\2-\61\7\t\2\2.\60\7\n\2\2/.\3\2\2\2\60\63\3\2\2\2"+
      "\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64\27\3\2\2"+
      "\2\64-\3\2\2\2\65\5\3\2\2\2\668\7\3\2\2\679\7\n\2\28\67\3\2\2\289"+
      "\3\2\2\29:\3\2\2\2:<\7\6\2\2;=\7\b\2\2<;\3\2\2\2<=\3\2\2\2=G\3\2\2"+
      "\2>?\7\3\2\2?G\7\5\2\2@A\7\3\2\2AG\7\4\2\2BC\7\3\2\2CG\7\b\2\2DG\7"+
      "\3\2\2EG\7\7\2\2F\66\3\2\2\2F>\3\2\2\2F@\3\2\2\2FB\3\2\2\2FD\3\2\2"+
      "\2FE\3\2\2\2G\7\3\2\2\2\17\13\20\24\27\34#(+\61\648<F";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}