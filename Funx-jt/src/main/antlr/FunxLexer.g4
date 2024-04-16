lexer grammar FunxLexer;

// Fragments
fragment LALPHA: [a-z];
fragment UALPHA: [A-Z];
fragment ALPHA: LALPHA | UALPHA;
fragment ALPHA_: ALPHA | UnderScore;

fragment DIGIT: [0-9];
fragment DECIMAL: DIGIT+;
fragment EXPONENT: [eE] [+-]? DECIMAL;
fragment FLOATING: DECIMAL ('.' DECIMAL) EXPONENT?;

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
FI: 'fi';
IF: 'if';
IN: 'in';
LET: 'let';
OUT: 'out';
THEN: 'then';
WITH: 'with';

// Literals
TYPEID: UALPHA (ALPHA_ | DIGIT)*;

FUNID: LALPHA (ALPHA_ | DIGIT)*;

BOOLEAN
    : 'False'
    | 'True'
    ;
FLOAT
    : FLOATING
    | OpenParen Minus FLOATING CloseParen
    ;
INTEGER
    : DECIMAL
    | OpenParen Minus DECIMAL CloseParen
    ;

// Symbols
Ampersand: '&';
Backslash: '\\';
Bang: '!';
Colon: ':';
Dot: '.';
Equals: '=';
Minus: '-';
Pipe: '|';
Plus: '+';
SemiColon: ';';
Slash: '/';
Star: '*';
UnderScore: '_';

Arrow: '->';
DotArrow: '.>';

OpenParen: '(';
CloseParen: ')';

OpenBracket: '[';
CloseBracket: ']';

OpenBrace: '{';
CloseBrace: '}';

CloseMultiComment: './';
OpenMultiComment: '/.';
SingleComment: '//';
