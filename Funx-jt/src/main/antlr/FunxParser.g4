parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

// ----------------------------------------------------------------
// Root
program: functions EOF;

functions: function (NEWLINE function?)*;

// ----------------------------------------------------------------
// Function
function
    : functionType NEWLINE
        id = FUNID lambdaParams? Equals statement
        (NEWLINE WITH localFunctions OUT)?
    ;

functionType: id = FUNID Colon typeElems;

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
    : expression # expressionStatement
    | lambda # lambdaStatement
    | let # letStatement
    | ifS # ifStatement
    ;

// ----------------------------------------------------------------
// Expression
expression
    : primary # primExpression
    | expression expression # appExpression
    | uop = Not expression # notExpression
    | expression bop = (Divide | Modulo | Multiply) expression # divModMultExpression
    | expression bop = (Add | Subtract) expression # addSubExpression
    | expression bop = (GreaterThan | GreaterThanEquals | LessThan | LessThanEquals) expression # compExpression
    | expression bop = (EqualsEquals | NotEquals) expression # eqExpression
    | expression bop = And expression # andExpression
    | expression bop = Or expression # orExpression
    ;

primary
    : OpenParen statement CloseParen # parenPrimary
    | literal # litPrimary
    | funId = FUNID # funPrimary
    ;

// ----------------------------------------------------------------
// Lambda
lambda: Backslash lambdaParams? Arrow statement;

lambdaParams
    : FUNID # paramLambda
    | <assoc = right> lambdaParams lambdaParams # multiParamLambda
    ;

// ----------------------------------------------------------------
// Let
let: LET localFunctions IN statement;

// ----------------------------------------------------------------
// If
ifS: IF statement THEN statement ELSE statement FI;

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