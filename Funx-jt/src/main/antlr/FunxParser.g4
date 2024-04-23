parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

program: functions EOF;

functions: function (NEWLINE function?)*;

// ----------------------------------------------------------------
// Function
function
    : functionType NEWLINE
        FUNID lambdaElems? Equals statement
        (NEWLINE WITH localFunctions OUT)?
    ;

functionType: FUNID Colon typeElems;

localFunctions: NEWLINE functions NEWLINE;

// ----------------------------------------------------------------
// Type
typeElems
    : OpenParen typeElems CloseParen # parenType
    | TYPE # type
    | <assoc = right> typeElems Arrow typeElems # arrowType
    ;

// ----------------------------------------------------------------
// Statement
statement
    : expression # ex
    | lambda # lambdaSt
    | let # letSt
    | if # ifSt
    ;

// ----------------------------------------------------------------
// Expression
expression
    : primary # prim
    | expression expression # app
    | Not expression # not
    | expression (Divide | Modulo | Multiply) expression # divModMult
    | expression (Add | Subtract) expression # addSub
    | expression (GreaterThan | GreaterThanEquals | LessThan | LessThanEquals) expression # comp
    | expression (EqualsEquals | NotEquals) expression # eq
    | expression And expression # and
    | expression Or expression # or
    ;

primary
    : OpenParen statement CloseParen # paren
    | literal # lit
    | FUNID # fun
    ;

// ----------------------------------------------------------------
// Lambda
lambda: Backslash lambdaElems? Arrow statement;

lambdaElems
    : FUNID
    | <assoc = right> lambdaElems lambdaElems
    ;

// ----------------------------------------------------------------
// Let
let: LET localFunctions IN statement;

// ----------------------------------------------------------------
// If
if: IF statement THEN statement ELSE statement FI;

// ----------------------------------------------------------------
// Literal
literal
    : BOOL
    | numLiteral
    ;

numLiteral
    : FLOAT
    | INT
    ;