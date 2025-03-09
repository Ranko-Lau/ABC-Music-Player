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
   * Enter a parse tree produced by {@link ABCmusicParser#abc_music}.
   * @param ctx the parse tree
   */
  void enterAbc_music(ABCmusicParser.Abc_musicContext ctx);
  /**
   * Exit a parse tree produced by {@link ABCmusicParser#abc_music}.
   * @param ctx the parse tree
   */
  void exitAbc_music(ABCmusicParser.Abc_musicContext ctx);
}