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
fragment TEXT: ~('\r' | '\n')+;
fragment DIGIT: [0-9]+;
fragment FRACTION: DIGIT '/' DIGIT;

EOL: ('\r'? '\n')+;
WHITESPACE: [ \t]+ -> skip;

INDEX:        'X:' ' '* DIGIT ' '* EOL;
TITLE:        'T:' ' '* TEXT ' '* EOL;
COMPOSER:     'C:' ' '* TEXT ' '* EOL;
LENGTH:       'L:' ' '* FRACTION EOL;
METER:        'M:' ' '* ('C' | 'C|' | FRACTION) ' '* EOL;
TEMPO:        'Q:' ' '* FRACTION '=' DIGIT ' '* EOL;
VOICE:        'V:' ' '* TEXT ' '* EOL;
KEY:          'K:' ' '* TEXT ' '* EOL;

 
/*
 * These are the parser rules. They define the structures used by the parser.
 */
abc_tune: abc_header abc_music? EOL? EOF;

//Header
abc_header: field_number field_title other_fields* field_key;

field_number: INDEX;
field_title: TITLE;
other_fields: COMPOSER | LENGTH | METER | TEMPO | VOICE;
field_key: KEY;

//Body
abc_music: '+' EOF;