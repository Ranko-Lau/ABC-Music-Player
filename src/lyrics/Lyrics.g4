 /**
 * This file is the grammar file used by ANTLR.
 *
 * In order to compile this file, navigate to this directory
 * (<src/lyrics>) and run the following command:
 *
 * java -jar ../../../lib/antlr.jar *.g4
 */

grammar Lyrics;

/*
 * This puts "package lyrics;" at the top of the output Java files.
 * Do not change these lines unless you know what you're doing.
 */
@header {
package lyrics;
}

/*
 * This adds code to the generated lexer and parser. This makes the lexer and
 * parser throw errors if they encounter invalid input. Do not change these
 * lines unless you know what you're doing.
 */
@members {
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
}

/*
 * These are the lyrics lexical rules. They define the tokens used by the lyrics lexer.
 * 
 */

WORD : ('\'' | '(' | ')' | ',' | [a-zA-Z0-9] | '.' | '!' | '?' | ':' | ';')+ ;
UNION_OPER : '~' | '\\-';
DOUBHYPHEN : '--';
HYPHEN : '-';
STARS : '*'+;
EXTENDERS : '_'+;
PIPE : '|';
WHITESPACE : ' ';
LINESPACE : [\t\n\r]+ -> skip ;

/*
 * These are the parser rules. They define the structures used by the parser.
 * A well constructed lyric will be parsed as follows
 * 
 * lyric:
 *      can have multiple measures and any amount of trailing whitespace at the end
 * measure:
 *      can be an entire lyric if no PIPEs are found
 *      can be empty or a cluster (the first word in the cluster determines the first token)
 *      if it begins with a PIPE, it may have at most one WHITESPACE
 *      if it ends with a PIPE, an optional WHITESPACE* may be used to separate the last syllable
 * syllable:
 *      can ONLY start with a WORD or a STARS
 *      single syllable and single STARS can be considered a full cluster
 *      no combination of WORD and STARS are allowed in the same syllable
 *      one WHITESPACE is allowed at the end of every syllable
 *      if starting with a WORD it must be followed by: 
 *          a HYPHEN and/or EXTENDERS
 *          a WHITESPACE and HYPHEN and/or EXTENDERS
 *          a DOUBHYPHEN
 *          a UNION_OPER  
 *          EXTENDERS
 * Anything outside of these rules will be considered an incorrectly inputted lyric and will
 * throw an exception/fail silently with an unexpected outcome
 *      
 */

lyric   : measure+ WHITESPACE* | EOF;
measure : PIPE? WHITESPACE* (syllable WHITESPACE*)+ PIPE?| PIPE WHITESPACE*;

syllable :  WORD WHITESPACE? HYPHEN EXTENDERS?| 
            WORD DOUBHYPHEN| 
            WORD UNION_OPER| 
            WORD EXTENDERS| 
            WORD|
            STARS;