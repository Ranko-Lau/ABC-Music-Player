/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar ABCmusic;
import Configuration;

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 */
TEXT: [a-zA-Z]+;
DIGIT: [0-9]+;
EOL: '\r'? '\n';

 
/*
 * These are the parser rules. They define the structures used by the parser.
 */
abc_tune: '+' EOF;