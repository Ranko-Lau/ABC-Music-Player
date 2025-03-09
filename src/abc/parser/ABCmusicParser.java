// Generated from ABCmusic.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ABCmusicParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, EOL=2, WHITESPACE=3, INDEX=4, TITLE=5, COMPOSER=6, LENGTH=7, 
    METER=8, TEMPO=9, VOICE=10, KEY=11;
  public static final int
    RULE_abc_tune = 0, RULE_abc_header = 1, RULE_field_number = 2, RULE_field_title = 3, 
    RULE_other_fields = 4, RULE_field_key = 5, RULE_abc_music = 6;
  public static final String[] ruleNames = {
    "abc_tune", "abc_header", "field_number", "field_title", "other_fields", 
    "field_key", "abc_music"
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

  @Override
  public String getGrammarFileName() { return "ABCmusic.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public ABCmusicParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class Abc_tuneContext extends ParserRuleContext {
    public Abc_headerContext abc_header() {
      return getRuleContext(Abc_headerContext.class,0);
    }
    public TerminalNode EOF() { return getToken(ABCmusicParser.EOF, 0); }
    public Abc_musicContext abc_music() {
      return getRuleContext(Abc_musicContext.class,0);
    }
    public TerminalNode EOL() { return getToken(ABCmusicParser.EOL, 0); }
    public Abc_tuneContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_abc_tune; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterAbc_tune(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitAbc_tune(this);
    }
  }

  public final Abc_tuneContext abc_tune() throws RecognitionException {
    Abc_tuneContext _localctx = new Abc_tuneContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_abc_tune);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(14);
      abc_header();
      setState(16);
      _la = _input.LA(1);
      if (_la==T__0) {
        {
        setState(15);
        abc_music();
        }
      }

      setState(19);
      _la = _input.LA(1);
      if (_la==EOL) {
        {
        setState(18);
        match(EOL);
        }
      }

      setState(21);
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

  public static class Abc_headerContext extends ParserRuleContext {
    public Field_numberContext field_number() {
      return getRuleContext(Field_numberContext.class,0);
    }
    public Field_titleContext field_title() {
      return getRuleContext(Field_titleContext.class,0);
    }
    public Field_keyContext field_key() {
      return getRuleContext(Field_keyContext.class,0);
    }
    public List<Other_fieldsContext> other_fields() {
      return getRuleContexts(Other_fieldsContext.class);
    }
    public Other_fieldsContext other_fields(int i) {
      return getRuleContext(Other_fieldsContext.class,i);
    }
    public Abc_headerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_abc_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterAbc_header(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitAbc_header(this);
    }
  }

  public final Abc_headerContext abc_header() throws RecognitionException {
    Abc_headerContext _localctx = new Abc_headerContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_abc_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(23);
      field_number();
      setState(24);
      field_title();
      setState(28);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPOSER) | (1L << LENGTH) | (1L << METER) | (1L << TEMPO) | (1L << VOICE))) != 0)) {
        {
        {
        setState(25);
        other_fields();
        }
        }
        setState(30);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(31);
      field_key();
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

  public static class Field_numberContext extends ParserRuleContext {
    public TerminalNode INDEX() { return getToken(ABCmusicParser.INDEX, 0); }
    public Field_numberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_number; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterField_number(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitField_number(this);
    }
  }

  public final Field_numberContext field_number() throws RecognitionException {
    Field_numberContext _localctx = new Field_numberContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_field_number);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(33);
      match(INDEX);
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

  public static class Field_titleContext extends ParserRuleContext {
    public TerminalNode TITLE() { return getToken(ABCmusicParser.TITLE, 0); }
    public Field_titleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_title; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterField_title(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitField_title(this);
    }
  }

  public final Field_titleContext field_title() throws RecognitionException {
    Field_titleContext _localctx = new Field_titleContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_field_title);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(35);
      match(TITLE);
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

  public static class Other_fieldsContext extends ParserRuleContext {
    public TerminalNode COMPOSER() { return getToken(ABCmusicParser.COMPOSER, 0); }
    public TerminalNode LENGTH() { return getToken(ABCmusicParser.LENGTH, 0); }
    public TerminalNode METER() { return getToken(ABCmusicParser.METER, 0); }
    public TerminalNode TEMPO() { return getToken(ABCmusicParser.TEMPO, 0); }
    public TerminalNode VOICE() { return getToken(ABCmusicParser.VOICE, 0); }
    public Other_fieldsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_other_fields; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterOther_fields(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitOther_fields(this);
    }
  }

  public final Other_fieldsContext other_fields() throws RecognitionException {
    Other_fieldsContext _localctx = new Other_fieldsContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_other_fields);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(37);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPOSER) | (1L << LENGTH) | (1L << METER) | (1L << TEMPO) | (1L << VOICE))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
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

  public static class Field_keyContext extends ParserRuleContext {
    public TerminalNode KEY() { return getToken(ABCmusicParser.KEY, 0); }
    public Field_keyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterField_key(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitField_key(this);
    }
  }

  public final Field_keyContext field_key() throws RecognitionException {
    Field_keyContext _localctx = new Field_keyContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_field_key);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(39);
      match(KEY);
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

  public static class Abc_musicContext extends ParserRuleContext {
    public TerminalNode EOF() { return getToken(ABCmusicParser.EOF, 0); }
    public Abc_musicContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_abc_music; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterAbc_music(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitAbc_music(this);
    }
  }

  public final Abc_musicContext abc_music() throws RecognitionException {
    Abc_musicContext _localctx = new Abc_musicContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_abc_music);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(41);
      match(T__0);
      setState(42);
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r/\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\5\2\23\n\2\3"+
      "\2\5\2\26\n\2\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3"+
      "\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n"+
      "\f\16\2\3\3\2\b\f*\2\20\3\2\2\2\4\31\3\2\2\2\6#\3\2\2\2\b%\3\2\2\2"+
      "\n\'\3\2\2\2\f)\3\2\2\2\16+\3\2\2\2\20\22\5\4\3\2\21\23\5\16\b\2\22"+
      "\21\3\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24\26\7\4\2\2\25\24\3\2\2"+
      "\2\25\26\3\2\2\2\26\27\3\2\2\2\27\30\7\2\2\3\30\3\3\2\2\2\31\32\5"+
      "\6\4\2\32\36\5\b\5\2\33\35\5\n\6\2\34\33\3\2\2\2\35 \3\2\2\2\36\34"+
      "\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\5\f\7\2\"\5\3\2"+
      "\2\2#$\7\6\2\2$\7\3\2\2\2%&\7\7\2\2&\t\3\2\2\2\'(\t\2\2\2(\13\3\2"+
      "\2\2)*\7\r\2\2*\r\3\2\2\2+,\7\3\2\2,-\7\2\2\3-\17\3\2\2\2\5\22\25"+
      "\36";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}