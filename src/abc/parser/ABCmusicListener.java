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
}