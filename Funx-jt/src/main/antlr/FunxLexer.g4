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
CloseMultiComment: './';
OpenMultiComment: '/.';
SingleComment: '//';

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

// Functions
TYPE
    : 'Bool'
    | 'Float'
    | 'Int'
    ;

FUNID: LALPHA (ALPHA_ | DIGIT)*;

// Literals
BOOL
    : 'False'
    | 'True'
    ;
FLOAT
    : FLOATING
    | OpenParen '-' FLOATING CloseParen
    ;
INT
    : DECIMAL
    | OpenParen '-' DECIMAL CloseParen
    ;

// Bool
And: '&&';
Or: '||';
Not: '!!';

// Comparison
EqualsEquals: '==';
GreaterThan: '>';
GreaterThanEquals: '>=';
LessThan: '<';
LessThanEquals: '<=';
NotEquals: '!=';

// Arithmetic
Add: '+';
Divide: '/';
Modulo: '%';
Multiply: '*';
Subtract: '-';

// Other symbols
Backslash: '\\';
Colon: ':';
Equals: '=';
UnderScore: '_';

Arrow: '->';

// Delimiters
OpenParen: '(';
CloseParen: ')';

OpenBracket: '[';
CloseBracket: ']';

OpenBrace: '{';
CloseBrace: '}';

