lexer grammar FunxLexer;

// Fragments
fragment LALPHA: [a-z];
fragment UALPHA: [A-Z];
fragment ALPHA: LALPHA | UALPHA;
fragment ALPHA_: ALPHA | UnderScore;
fragment DIGIT: [0-9];

// Whitespace
NEWLINE
    : '\r'? '\n'
    | '\r'
    ;

TAB: [\t]+ -> skip;

WS: [\u0020\u00a0\u1680\u2000\u200a\u202f\u205f\u3000]+ -> skip;

// Comments
COMMENT: SingleComment ~[\r\n]* -> skip;
MULTICOMMENT: OpenMultiComment .*? CloseMultiComment -> skip;

// Keywords
ELSE: 'else';
END: 'end';
IF: 'if';
IN: 'in';
LET: 'let';
THEN: 'then';
WITH: 'with';

// Literals
FUNID: LALPHA (ALPHA_ | DIGIT)*;

BOOLEAN
    : 'False'
    | 'True'
    ;
DECIMAL: DIGIT+;
EXPONENT : [eE] [+-]? DECIMAL;
FLOAT
    : DECIMAL '.' DECIMAL EXPONENT?
    | DECIMAL EXPONENT
    ;

// Symbols
Backslash: '\\';
CloseMultiComment: './';
Colon: ':';
Equals: '=';
OpenMultiComment: '/.';
SemiColon: ';';
SingleComment: '//';
UnderScore: '_';

DotArrow: '.>';

OpenParen: '(';
CloseParen: ')';

OpenBracket: '[';
CloseBracket: ']';

OpenBrace: '{';
CloseBrace: '}';

OpenJavaBrace: '{{#';
CloseJavaBrace: '#}}';
