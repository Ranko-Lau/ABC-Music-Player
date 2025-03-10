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
LENGTH:       'L:' ' '* FRACTION ' '* EOL;
METER:        'M:' ' '* ('C' | 'C|' | FRACTION) ' '* EOL;
TEMPO:        'Q:' ' '* (FRACTION '=')? DIGIT ' '* EOL;
VOICE:        'V:' ' '* TEXT ' '* EOL;
KEY:          'K:' ' '* TEXT ' '* EOL;
LYRIC :       'w:' TEXT ' '* EOL;

COMMENT : '%' ('-' | '^' | '=' | '_'  | ' ' | '|' | '\'' | '(' | ')' | ']' | '[' | ':' |'_' | '*' | '~' | ',' | '/' | [a-zA-Z0-9] | '.' | '!' | '?')*  EOL;
NOTE :  ('^'|'^^'|'_'|'__'|'=')?[a-gA-G]['\''',']*([1-9]* '/' [1-9]+ | [1-9]+ '/'? | '/')?;
REST : ('z'|'Z') ([1-9]* '/' [1-9]+ | [1-9]+ '/'? | '/')?;
DUPLET: '(' '2';
TRIPLET: '(' '3';
QUAD: '(' '4';
PIPE: '|' | '[|';
LBRAC: '[';
RBRAC: ']';
LREPEAT: '|:' | '||:';
RREPEAT: ':|' | ':||';
ONE_REPEAT : '[1';
TWO_REPEAT: '[2';
END_NOTES: '|]' | '||';
 
/*
 * These are the parser rules. They define the structures used by the parser.
 */
abc_tune: abc_header abc_music EOL EOF;

//Header
abc_header: field_number field_title other_fields* field_key;

field_number: INDEX;
field_title: TITLE;
other_fields: COMPOSER | LENGTH | METER | TEMPO | VOICE | COMMENT;
field_key: KEY;
field_voice: VOICE;

//Body
abc_music: (line | field_voice EOL? | COMMENT)+;
line: EOL? measure+ EOL? lyric? EOL?;
measure: (LREPEAT | ONE_REPEAT | TWO_REPEAT | PIPE)? note_element+ (PIPE | END_NOTES | EOL | RREPEAT)?;

note_element: note | rest | chord | duplet | triplet | quadruplet;
note: NOTE;
rest: REST;
chord: LBRAC (note | rest)+ RBRAC;
lyric: LYRIC;
duplet: DUPLET (note|chord) (note|chord);
triplet: TRIPLET (note|chord) (note|chord) (note|chord);
quadruplet: QUAD (note|chord) (note|chord) (note|chord) (note|chord);

