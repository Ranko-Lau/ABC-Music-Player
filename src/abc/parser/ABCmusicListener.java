// Generated from ABCmusic.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ABCmusicParser}.
 */
public interface ABCmusicListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#abc_tune}.
   * @param ctx the parse tree
   */
  void enterAbc_tune(ABCmusicParser.Abc_tuneContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#abc_tune}.
   * @param ctx the parse tree
   */
  void exitAbc_tune(ABCmusicParser.Abc_tuneContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#abc_header}.
   * @param ctx the parse tree
   */
  void enterAbc_header(ABCmusicParser.Abc_headerContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#abc_header}.
   * @param ctx the parse tree
   */
  void exitAbc_header(ABCmusicParser.Abc_headerContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#field_number}.
   * @param ctx the parse tree
   */
  void enterField_number(ABCmusicParser.Field_numberContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#field_number}.
   * @param ctx the parse tree
   */
  void exitField_number(ABCmusicParser.Field_numberContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#field_title}.
   * @param ctx the parse tree
   */
  void enterField_title(ABCmusicParser.Field_titleContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#field_title}.
   * @param ctx the parse tree
   */
  void exitField_title(ABCmusicParser.Field_titleContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#other_fields}.
   * @param ctx the parse tree
   */
  void enterOther_fields(ABCmusicParser.Other_fieldsContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#other_fields}.
   * @param ctx the parse tree
   */
  void exitOther_fields(ABCmusicParser.Other_fieldsContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#field_key}.
   * @param ctx the parse tree
   */
  void enterField_key(ABCmusicParser.Field_keyContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#field_key}.
   * @param ctx the parse tree
   */
  void exitField_key(ABCmusicParser.Field_keyContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#field_voice}.
   * @param ctx the parse tree
   */
  void enterField_voice(ABCmusicParser.Field_voiceContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#field_voice}.
   * @param ctx the parse tree
   */
  void exitField_voice(ABCmusicParser.Field_voiceContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#abc_music}.
   * @param ctx the parse tree
   */
  void enterAbc_music(ABCmusicParser.Abc_musicContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#abc_music}.
   * @param ctx the parse tree
   */
  void exitAbc_music(ABCmusicParser.Abc_musicContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#line}.
   * @param ctx the parse tree
   */
  void enterLine(ABCmusicParser.LineContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#line}.
   * @param ctx the parse tree
   */
  void exitLine(ABCmusicParser.LineContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#measure}.
   * @param ctx the parse tree
   */
  void enterMeasure(ABCmusicParser.MeasureContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#measure}.
   * @param ctx the parse tree
   */
  void exitMeasure(ABCmusicParser.MeasureContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#note_element}.
   * @param ctx the parse tree
   */
  void enterNote_element(ABCmusicParser.Note_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#note_element}.
   * @param ctx the parse tree
   */
  void exitNote_element(ABCmusicParser.Note_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(ABCmusicParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(ABCmusicParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#rest}.
   * @param ctx the parse tree
   */
  void enterRest(ABCmusicParser.RestContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#rest}.
   * @param ctx the parse tree
   */
  void exitRest(ABCmusicParser.RestContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(ABCmusicParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(ABCmusicParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#lyric}.
   * @param ctx the parse tree
   */
  void enterLyric(ABCmusicParser.LyricContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#lyric}.
   * @param ctx the parse tree
   */
  void exitLyric(ABCmusicParser.LyricContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#duplet}.
   * @param ctx the parse tree
   */
  void enterDuplet(ABCmusicParser.DupletContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#duplet}.
   * @param ctx the parse tree
   */
  void exitDuplet(ABCmusicParser.DupletContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#triplet}.
   * @param ctx the parse tree
   */
  void enterTriplet(ABCmusicParser.TripletContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#triplet}.
   * @param ctx the parse tree
   */
  void exitTriplet(ABCmusicParser.TripletContext ctx);
  /**
   * Enter a parse tree produced by {@link ABCmusicParser#quadruplet}.
   * @param ctx the parse tree
   */
  void enterQuadruplet(ABCmusicParser.QuadrupletContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#quadruplet}.
   * @param ctx the parse tree
   */
  void exitQuadruplet(ABCmusicParser.QuadrupletContext ctx);
}