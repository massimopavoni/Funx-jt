parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

program: functions EOF;

functions: function (NEWLINE function?)*;

// ----------------------------------------------------------------
// Function
function
    : functionType NEWLINE
        FUNID lambdaElems? Equals expression
        (NEWLINE WITH localFunctions OUT)?
    ;

functionType: FUNID Colon typeElems;

localFunctions: NEWLINE functions NEWLINE;

// ----------------------------------------------------------------
// Type
typeElems: typeTerm (Arrow typeElems)?;

typeTerm
    : OpenParen typeElems CloseParen # parenType
    | TYPE # type
    ;

// ----------------------------------------------------------------
// Expressions
expression
    : ifEx # if
    | letEx # let
    | lambdaEx # lambda
    | applicationEx # app
    | boolEx # bool
    | arithmeticEx # arith
    ;

parenOrFun
    : OpenParen expression CloseParen
    | FUNID
    ;

// ----------------------------------------------------------------
// Application
applicationEx: parenOrFun multiApplication?;

multiApplication: (parenOrFun | literal) multiApplication?;

// ----------------------------------------------------------------
// Literals
literal
    : BOOL
    | numLiteral
    ;

numLiteral
    : FLOAT
    | INT
    ;

// ----------------------------------------------------------------
// Lambda
lambdaEx: Backslash lambdaElems? Arrow expression;

lambdaElems: FUNID+;

// ----------------------------------------------------------------
// Let
letEx: LET (function | localFunctions) IN expression;

// ----------------------------------------------------------------
// If
ifEx: IF expression THEN expression ELSE expression FI;

// ----------------------------------------------------------------
// Boolean
boolEx: boolTerm boolOr?;

boolOr: Or boolTerm boolOr?;

boolTerm: boolFactor boolAnd?;

boolAnd: And boolFactor boolAnd?;

boolFactor
    : boolPrimary # simpleBool
    | Not boolPrimary # notBool
    ;

boolPrimary
    : BOOL # litBool
    | comparison # compBool
    | parenOrFun # appParenBool
    ;

// ----------------------------------------------------------------
// Comparison
comparison
    : (applicationEx | literal)
        (EqualsEquals | GreaterThan | GreaterThanEquals | LessThan | LessThanEquals | NotEquals)
        (applicationEx | literal)
    ;

// ----------------------------------------------------------------
// Arithmetic
arithmeticEx: arithmeticTerm addSub?;

addSub: (Add | Subtract) arithmeticTerm addSub?;

arithmeticTerm: arithmeticFactor divModMult?;

divModMult: (Divide | Modulo | Multiply) arithmeticFactor divModMult?;

arithmeticFactor
    : numLiteral # litArith
    | parenOrFun # appParenArith
    ;