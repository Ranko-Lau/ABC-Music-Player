// Generated from Lyrics.g4 by ANTLR 4.5.1

package lyrics;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LyricsParser}.
 */
public interface LyricsListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link LyricsParser#lyric}.
   * @param ctx the parse tree
   */
  void enterLyric(LyricsParser.LyricContext ctx);
  /**
   * Exit a parse tree produced by {@link LyricsParser#lyric}.
   * @param ctx the parse tree
   */
  void exitLyric(LyricsParser.LyricContext ctx);
  /**
   * Enter a parse tree produced by {@link LyricsParser#measure}.
   * @param ctx the parse tree
   */
  void enterMeasure(LyricsParser.MeasureContext ctx);
  /**
   * Exit a parse tree produced by {@link LyricsParser#measure}.
   * @param ctx the parse tree
   */
  void exitMeasure(LyricsParser.MeasureContext ctx);
  /**
   * Enter a parse tree produced by {@link LyricsParser#syllable}.
   * @param ctx the parse tree
   */
  void enterSyllable(LyricsParser.SyllableContext ctx);
  /**
   * Exit a parse tree produced by {@link LyricsParser#syllable}.
   * @param ctx the parse tree
   */
  void exitSyllable(LyricsParser.SyllableContext ctx);
}