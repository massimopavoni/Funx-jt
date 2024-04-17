parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

program: functions EOF;

functions: function (NEWLINE function?)*;

function
    : functionType NEWLINE
        FUNID lambdaElems? Equals expression
        (NEWLINE WITH localFunctions OUT)?
    ;

functionType: FUNID Colon typeElems;

typeElems
    : typeTerm # singleType
    | typeElems Arrow typeTerm # multiType
    ;

typeTerm
    : OpenParen typeElems CloseParen # parenType
    | TYPE # type
    ;

localFunctions: NEWLINE functions NEWLINE;

expression
    : parenthesizedEx # paren
    | applicationEx # app
    | lambdaEx # lambda
    | letEx # let
    | ifEx # if
    | boolEx # bool
    | arithmeticEx # arith
    ;

parenthesizedEx: OpenParen expression CloseParen;

applicationEx
    : parenthesizedEx # parenApp
    | FUNID # singleApp
    | applicationEx (parenthesizedEx | FUNID | literalEx) # multiApp
    ;

literalEx
    : BOOL
    | FLOAT
    | INT
    ;

lambdaEx: Backslash lambdaElems? Arrow expression;

lambdaElems
    : FUNID # singleLambda
    | lambdaElems FUNID # multiLambda
    ;

letEx: LET (function | localFunctions) IN expression;

ifEx: IF expression THEN expression ELSE expression FI;

boolEx
    : parenthesizedEx # parenBool
    | FUNID # funBool
    | BOOL # litBool
    | comparison # compBool
    | Not boolEx # notBool
    | boolEx And boolEx # andBool
    | boolEx Or boolEx # orBool
    ;

comparison
    : (applicationEx | literalEx)
        (EqualsEquals | GreaterThan | GreaterThanEquals | LessThan | LessThanEquals | NotEquals)
        (applicationEx | literalEx)
    ;

arithmeticEx
    : parenthesizedEx # parenArith
    | FUNID # funArith
    | FLOAT # floatArith
    | INT # intArith
    | arithmeticEx (Divide | Modulo | Multiply) arithmeticEx # divModMultArith
    | arithmeticEx (Add | Subtract) arithmeticEx # addSubArith
    ;


