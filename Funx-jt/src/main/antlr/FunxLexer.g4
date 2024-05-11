lexer grammar FunxLexer;

// Fragments
fragment LALPHA: [a-z];
fragment UALPHA: [A-Z];
fragment ALPHA: LALPHA | UALPHA;
fragment ALPHA_: ALPHA | UnderScore;

fragment DIGIT: [0-9];
fragment DECIMAL: DIGIT+;

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
MODULE: 'module';
OUT: 'out';
THEN: 'then';
WITH: 'with';

// Java keywords
RESERVED_JAVA_KEYWORD
    : 'abstract' | 'assert' | 'boolean' | 'break' | 'byte'
    | 'case' | 'catch' | 'char' | 'class' | 'const'
    | 'continue' | 'default' | 'do' | 'double' | 'enum'
    | 'extends' | 'final' | 'finally' | 'float' | 'for'
    | 'goto' | 'implements' | 'import' | 'instanceof' | 'int'
    | 'interface' | 'long' | 'native' | 'new' | 'package'
    | 'private' | 'protected' | 'public' | 'return' | 'short'
    | 'static' | 'strictfp' | 'super' | 'switch' | 'synchronized'
    | 'this' | 'throw' | 'throws' | 'transient' | 'try'
    | 'void' | 'volatile' | 'while'
    ;

// Types
TYPE
    : BOOLTYPE
    | INTTYPE
    ;

BOOLTYPE: 'Bool';
INTTYPE: 'Int';

// Literals
BOOL
    : 'False'
    | 'True'
    ;
INT
    : DECIMAL
    | OpenParen '-' DECIMAL CloseParen
    ;

// Variables
VARID: LALPHA (ALPHA_ | DIGIT)*;

// Module
MODULEID: UALPHA (ALPHA_ | DIGIT)*;

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

