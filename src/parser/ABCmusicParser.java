// Generated from ABCmusic.g4 by ANTLR 4.5.1

package parser;
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
    EOL=1, WHITESPACE=2, INDEX=3, TITLE=4, COMPOSER=5, LENGTH=6, METER=7, 
    TEMPO=8, VOICE=9, KEY=10, LYRIC=11, COMMENT=12, NOTE=13, REST=14, DUPLET=15, 
    TRIPLET=16, QUAD=17, PIPE=18, LBRAC=19, RBRAC=20, LREPEAT=21, RREPEAT=22, 
    ONE_REPEAT=23, TWO_REPEAT=24, END_NOTES=25;
  public static final int
    RULE_abc_tune = 0, RULE_abc_header = 1, RULE_field_number = 2, RULE_field_title = 3, 
    RULE_other_fields = 4, RULE_field_key = 5, RULE_field_voice = 6, RULE_abc_music = 7, 
    RULE_line = 8, RULE_measure = 9, RULE_note_element = 10, RULE_note = 11, 
    RULE_rest = 12, RULE_chord = 13, RULE_lyric = 14, RULE_duplet = 15, 
    RULE_triplet = 16, RULE_quadruplet = 17;
  public static final String[] ruleNames = {
    "abc_tune", "abc_header", "field_number", "field_title", "other_fields", 
    "field_key", "field_voice", "abc_music", "line", "measure", "note_element", 
    "note", "rest", "chord", "lyric", "duplet", "triplet", "quadruplet"
  };

  private static final String[] _LITERAL_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, "'['", "']'", null, null, 
    "'[1'", "'[2'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, "EOL", "WHITESPACE", "INDEX", "TITLE", "COMPOSER", "LENGTH", "METER", 
    "TEMPO", "VOICE", "KEY", "LYRIC", "COMMENT", "NOTE", "REST", "DUPLET", 
    "TRIPLET", "QUAD", "PIPE", "LBRAC", "RBRAC", "LREPEAT", "RREPEAT", "ONE_REPEAT", 
    "TWO_REPEAT", "END_NOTES"
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
    public Abc_musicContext abc_music() {
      return getRuleContext(Abc_musicContext.class,0);
    }
    public TerminalNode EOL() { return getToken(ABCmusicParser.EOL, 0); }
    public TerminalNode EOF() { return getToken(ABCmusicParser.EOF, 0); }
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
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(36);
      abc_header();
      setState(37);
      abc_music();
      setState(38);
      match(EOL);
      setState(39);
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
      setState(41);
      field_number();
      setState(42);
      field_title();
      setState(46);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPOSER) | (1L << LENGTH) | (1L << METER) | (1L << TEMPO) | (1L << VOICE) | (1L << COMMENT))) != 0)) {
        {
        {
        setState(43);
        other_fields();
        }
        }
        setState(48);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(49);
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
      setState(51);
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
      setState(53);
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
    public TerminalNode COMMENT() { return getToken(ABCmusicParser.COMMENT, 0); }
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
      setState(55);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPOSER) | (1L << LENGTH) | (1L << METER) | (1L << TEMPO) | (1L << VOICE) | (1L << COMMENT))) != 0)) ) {
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
      setState(57);
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

  public static class Field_voiceContext extends ParserRuleContext {
    public TerminalNode VOICE() { return getToken(ABCmusicParser.VOICE, 0); }
    public Field_voiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_voice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterField_voice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitField_voice(this);
    }
  }

  public final Field_voiceContext field_voice() throws RecognitionException {
    Field_voiceContext _localctx = new Field_voiceContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_field_voice);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(59);
      match(VOICE);
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
    public List<LineContext> line() {
      return getRuleContexts(LineContext.class);
    }
    public LineContext line(int i) {
      return getRuleContext(LineContext.class,i);
    }
    public List<Field_voiceContext> field_voice() {
      return getRuleContexts(Field_voiceContext.class);
    }
    public Field_voiceContext field_voice(int i) {
      return getRuleContext(Field_voiceContext.class,i);
    }
    public List<TerminalNode> COMMENT() { return getTokens(ABCmusicParser.COMMENT); }
    public TerminalNode COMMENT(int i) {
      return getToken(ABCmusicParser.COMMENT, i);
    }
    public List<TerminalNode> EOL() { return getTokens(ABCmusicParser.EOL); }
    public TerminalNode EOL(int i) {
      return getToken(ABCmusicParser.EOL, i);
    }
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
    enterRule(_localctx, 14, RULE_abc_music);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(67); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          setState(67);
          switch (_input.LA(1)) {
          case EOL:
          case NOTE:
          case REST:
          case DUPLET:
          case TRIPLET:
          case QUAD:
          case PIPE:
          case LBRAC:
          case LREPEAT:
          case ONE_REPEAT:
          case TWO_REPEAT:
            {
            setState(61);
            line();
            }
            break;
          case VOICE:
            {
            setState(62);
            field_voice();
            setState(64);
            switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
            case 1:
              {
              setState(63);
              match(EOL);
              }
              break;
            }
            }
            break;
          case COMMENT:
            {
            setState(66);
            match(COMMENT);
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(69); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

  public static class LineContext extends ParserRuleContext {
    public List<TerminalNode> EOL() { return getTokens(ABCmusicParser.EOL); }
    public TerminalNode EOL(int i) {
      return getToken(ABCmusicParser.EOL, i);
    }
    public List<MeasureContext> measure() {
      return getRuleContexts(MeasureContext.class);
    }
    public MeasureContext measure(int i) {
      return getRuleContext(MeasureContext.class,i);
    }
    public LyricContext lyric() {
      return getRuleContext(LyricContext.class,0);
    }
    public LineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterLine(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitLine(this);
    }
  }

  public final LineContext line() throws RecognitionException {
    LineContext _localctx = new LineContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_line);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(72);
      _la = _input.LA(1);
      if (_la==EOL) {
        {
        setState(71);
        match(EOL);
        }
      }

      setState(75); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(74);
          measure();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(77); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,5,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      setState(80);
      switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
      case 1:
        {
        setState(79);
        match(EOL);
        }
        break;
      }
      setState(83);
      _la = _input.LA(1);
      if (_la==LYRIC) {
        {
        setState(82);
        lyric();
        }
      }

      setState(86);
      switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
      case 1:
        {
        setState(85);
        match(EOL);
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

  public static class MeasureContext extends ParserRuleContext {
    public List<Note_elementContext> note_element() {
      return getRuleContexts(Note_elementContext.class);
    }
    public Note_elementContext note_element(int i) {
      return getRuleContext(Note_elementContext.class,i);
    }
    public TerminalNode LREPEAT() { return getToken(ABCmusicParser.LREPEAT, 0); }
    public TerminalNode ONE_REPEAT() { return getToken(ABCmusicParser.ONE_REPEAT, 0); }
    public TerminalNode TWO_REPEAT() { return getToken(ABCmusicParser.TWO_REPEAT, 0); }
    public List<TerminalNode> PIPE() { return getTokens(ABCmusicParser.PIPE); }
    public TerminalNode PIPE(int i) {
      return getToken(ABCmusicParser.PIPE, i);
    }
    public TerminalNode END_NOTES() { return getToken(ABCmusicParser.END_NOTES, 0); }
    public TerminalNode EOL() { return getToken(ABCmusicParser.EOL, 0); }
    public TerminalNode RREPEAT() { return getToken(ABCmusicParser.RREPEAT, 0); }
    public MeasureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterMeasure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitMeasure(this);
    }
  }

  public final MeasureContext measure() throws RecognitionException {
    MeasureContext _localctx = new MeasureContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_measure);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(89);
      _la = _input.LA(1);
      if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIPE) | (1L << LREPEAT) | (1L << ONE_REPEAT) | (1L << TWO_REPEAT))) != 0)) {
        {
        setState(88);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIPE) | (1L << LREPEAT) | (1L << ONE_REPEAT) | (1L << TWO_REPEAT))) != 0)) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
      }

      setState(92); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(91);
          note_element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(94); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,10,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      setState(97);
      switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
      case 1:
        {
        setState(96);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EOL) | (1L << PIPE) | (1L << RREPEAT) | (1L << END_NOTES))) != 0)) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
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

  public static class Note_elementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public RestContext rest() {
      return getRuleContext(RestContext.class,0);
    }
    public ChordContext chord() {
      return getRuleContext(ChordContext.class,0);
    }
    public DupletContext duplet() {
      return getRuleContext(DupletContext.class,0);
    }
    public TripletContext triplet() {
      return getRuleContext(TripletContext.class,0);
    }
    public QuadrupletContext quadruplet() {
      return getRuleContext(QuadrupletContext.class,0);
    }
    public Note_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterNote_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitNote_element(this);
    }
  }

  public final Note_elementContext note_element() throws RecognitionException {
    Note_elementContext _localctx = new Note_elementContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_note_element);
    try {
      setState(105);
      switch (_input.LA(1)) {
      case NOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(99);
        note();
        }
        break;
      case REST:
        enterOuterAlt(_localctx, 2);
        {
        setState(100);
        rest();
        }
        break;
      case LBRAC:
        enterOuterAlt(_localctx, 3);
        {
        setState(101);
        chord();
        }
        break;
      case DUPLET:
        enterOuterAlt(_localctx, 4);
        {
        setState(102);
        duplet();
        }
        break;
      case TRIPLET:
        enterOuterAlt(_localctx, 5);
        {
        setState(103);
        triplet();
        }
        break;
      case QUAD:
        enterOuterAlt(_localctx, 6);
        {
        setState(104);
        quadruplet();
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

  public static class NoteContext extends ParserRuleContext {
    public TerminalNode NOTE() { return getToken(ABCmusicParser.NOTE, 0); }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_note);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(107);
      match(NOTE);
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

  public static class RestContext extends ParserRuleContext {
    public TerminalNode REST() { return getToken(ABCmusicParser.REST, 0); }
    public RestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterRest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitRest(this);
    }
  }

  public final RestContext rest() throws RecognitionException {
    RestContext _localctx = new RestContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_rest);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(109);
      match(REST);
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

  public static class ChordContext extends ParserRuleContext {
    public TerminalNode LBRAC() { return getToken(ABCmusicParser.LBRAC, 0); }
    public TerminalNode RBRAC() { return getToken(ABCmusicParser.RBRAC, 0); }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<RestContext> rest() {
      return getRuleContexts(RestContext.class);
    }
    public RestContext rest(int i) {
      return getRuleContext(RestContext.class,i);
    }
    public ChordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_chord; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(111);
      match(LBRAC);
      setState(114); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        setState(114);
        switch (_input.LA(1)) {
        case NOTE:
          {
          setState(112);
          note();
          }
          break;
        case REST:
          {
          setState(113);
          rest();
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        }
        setState(116); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( _la==NOTE || _la==REST );
      setState(118);
      match(RBRAC);
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

  public static class LyricContext extends ParserRuleContext {
    public TerminalNode LYRIC() { return getToken(ABCmusicParser.LYRIC, 0); }
    public LyricContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_lyric; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterLyric(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitLyric(this);
    }
  }

  public final LyricContext lyric() throws RecognitionException {
    LyricContext _localctx = new LyricContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_lyric);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(120);
      match(LYRIC);
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

  public static class DupletContext extends ParserRuleContext {
    public TerminalNode DUPLET() { return getToken(ABCmusicParser.DUPLET, 0); }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public DupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_duplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterDuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitDuplet(this);
    }
  }

  public final DupletContext duplet() throws RecognitionException {
    DupletContext _localctx = new DupletContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_duplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(122);
      match(DUPLET);
      setState(125);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(123);
        note();
        }
        break;
      case LBRAC:
        {
        setState(124);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(129);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(127);
        note();
        }
        break;
      case LBRAC:
        {
        setState(128);
        chord();
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

  public static class TripletContext extends ParserRuleContext {
    public TerminalNode TRIPLET() { return getToken(ABCmusicParser.TRIPLET, 0); }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public TripletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_triplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterTriplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitTriplet(this);
    }
  }

  public final TripletContext triplet() throws RecognitionException {
    TripletContext _localctx = new TripletContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_triplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(131);
      match(TRIPLET);
      setState(134);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(132);
        note();
        }
        break;
      case LBRAC:
        {
        setState(133);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(138);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(136);
        note();
        }
        break;
      case LBRAC:
        {
        setState(137);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(142);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(140);
        note();
        }
        break;
      case LBRAC:
        {
        setState(141);
        chord();
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

  public static class QuadrupletContext extends ParserRuleContext {
    public TerminalNode QUAD() { return getToken(ABCmusicParser.QUAD, 0); }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public QuadrupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_quadruplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).enterQuadruplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ABCmusicListener ) ((ABCmusicListener)listener).exitQuadruplet(this);
    }
  }

  public final QuadrupletContext quadruplet() throws RecognitionException {
    QuadrupletContext _localctx = new QuadrupletContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_quadruplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(144);
      match(QUAD);
      setState(147);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(145);
        note();
        }
        break;
      case LBRAC:
        {
        setState(146);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(151);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(149);
        note();
        }
        break;
      case LBRAC:
        {
        setState(150);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(155);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(153);
        note();
        }
        break;
      case LBRAC:
        {
        setState(154);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(159);
      switch (_input.LA(1)) {
      case NOTE:
        {
        setState(157);
        note();
        }
        break;
      case LBRAC:
        {
        setState(158);
        chord();
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00a4\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
      "\4\22\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3/\n\3\f\3"+
      "\16\3\62\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
      "\3\t\3\t\5\tC\n\t\3\t\6\tF\n\t\r\t\16\tG\3\n\5\nK\n\n\3\n\6\nN\n\n"+
      "\r\n\16\nO\3\n\5\nS\n\n\3\n\5\nV\n\n\3\n\5\nY\n\n\3\13\5\13\\\n\13"+
      "\3\13\6\13_\n\13\r\13\16\13`\3\13\5\13d\n\13\3\f\3\f\3\f\3\f\3\f\3"+
      "\f\5\fl\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\6\17u\n\17\r\17\16\17"+
      "v\3\17\3\17\3\20\3\20\3\21\3\21\3\21\5\21\u0080\n\21\3\21\3\21\5\21"+
      "\u0084\n\21\3\22\3\22\3\22\5\22\u0089\n\22\3\22\3\22\5\22\u008d\n"+
      "\22\3\22\3\22\5\22\u0091\n\22\3\23\3\23\3\23\5\23\u0096\n\23\3\23"+
      "\3\23\5\23\u009a\n\23\3\23\3\23\5\23\u009e\n\23\3\23\3\23\5\23\u00a2"+
      "\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\4"+
      "\2\7\13\16\16\5\2\24\24\27\27\31\32\6\2\3\3\24\24\30\30\33\33\u00ae"+
      "\2&\3\2\2\2\4+\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\n9\3\2\2\2\f;\3\2"+
      "\2\2\16=\3\2\2\2\20E\3\2\2\2\22J\3\2\2\2\24[\3\2\2\2\26k\3\2\2\2\30"+
      "m\3\2\2\2\32o\3\2\2\2\34q\3\2\2\2\36z\3\2\2\2 |\3\2\2\2\"\u0085\3"+
      "\2\2\2$\u0092\3\2\2\2&\'\5\4\3\2\'(\5\20\t\2()\7\3\2\2)*\7\2\2\3*"+
      "\3\3\2\2\2+,\5\6\4\2,\60\5\b\5\2-/\5\n\6\2.-\3\2\2\2/\62\3\2\2\2\60"+
      ".\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\5\f\7\2"+
      "\64\5\3\2\2\2\65\66\7\5\2\2\66\7\3\2\2\2\678\7\6\2\28\t\3\2\2\29:"+
      "\t\2\2\2:\13\3\2\2\2;<\7\f\2\2<\r\3\2\2\2=>\7\13\2\2>\17\3\2\2\2?"+
      "F\5\22\n\2@B\5\16\b\2AC\7\3\2\2BA\3\2\2\2BC\3\2\2\2CF\3\2\2\2DF\7"+
      "\16\2\2E?\3\2\2\2E@\3\2\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2"+
      "\2H\21\3\2\2\2IK\7\3\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\5\24\13\2"+
      "ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\7\3\2\2RQ\3\2"+
      "\2\2RS\3\2\2\2SU\3\2\2\2TV\5\36\20\2UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2"+
      "WY\7\3\2\2XW\3\2\2\2XY\3\2\2\2Y\23\3\2\2\2Z\\\t\3\2\2[Z\3\2\2\2[\\"+
      "\3\2\2\2\\^\3\2\2\2]_\5\26\f\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2"+
      "\2\2ac\3\2\2\2bd\t\4\2\2cb\3\2\2\2cd\3\2\2\2d\25\3\2\2\2el\5\30\r"+
      "\2fl\5\32\16\2gl\5\34\17\2hl\5 \21\2il\5\"\22\2jl\5$\23\2ke\3\2\2"+
      "\2kf\3\2\2\2kg\3\2\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2l\27\3\2\2\2m"+
      "n\7\17\2\2n\31\3\2\2\2op\7\20\2\2p\33\3\2\2\2qt\7\25\2\2ru\5\30\r"+
      "\2su\5\32\16\2tr\3\2\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w"+
      "x\3\2\2\2xy\7\26\2\2y\35\3\2\2\2z{\7\r\2\2{\37\3\2\2\2|\177\7\21\2"+
      "\2}\u0080\5\30\r\2~\u0080\5\34\17\2\177}\3\2\2\2\177~\3\2\2\2\u0080"+
      "\u0083\3\2\2\2\u0081\u0084\5\30\r\2\u0082\u0084\5\34\17\2\u0083\u0081"+
      "\3\2\2\2\u0083\u0082\3\2\2\2\u0084!\3\2\2\2\u0085\u0088\7\22\2\2\u0086"+
      "\u0089\5\30\r\2\u0087\u0089\5\34\17\2\u0088\u0086\3\2\2\2\u0088\u0087"+
      "\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008d\5\30\r\2\u008b\u008d\5\34"+
      "\17\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2"+
      "\u008e\u0091\5\30\r\2\u008f\u0091\5\34\17\2\u0090\u008e\3\2\2\2\u0090"+
      "\u008f\3\2\2\2\u0091#\3\2\2\2\u0092\u0095\7\23\2\2\u0093\u0096\5\30"+
      "\r\2\u0094\u0096\5\34\17\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2"+
      "\u0096\u0099\3\2\2\2\u0097\u009a\5\30\r\2\u0098\u009a\5\34\17\2\u0099"+
      "\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u009e"+
      "\5\30\r\2\u009c\u009e\5\34\17\2\u009d\u009b\3\2\2\2\u009d\u009c\3"+
      "\2\2\2\u009e\u00a1\3\2\2\2\u009f\u00a2\5\30\r\2\u00a0\u00a2\5\34\17"+
      "\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2%\3\2\2\2\32\60BE"+
      "GJORUX[`cktv\177\u0083\u0088\u008c\u0090\u0095\u0099\u009d\u00a1";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}