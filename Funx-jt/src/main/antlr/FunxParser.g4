parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

program: functions EOF;

functions: function (NEWLINE function?)*;

function: FUNID lambdaElems? Equals expression (NEWLINE with)?;

with: WITH localFunctions END;

localFunctions: NEWLINE functions NEWLINE;

expression
    : literalEx # literal
    | applicationEx # application
    | lambdaEx # lambda
    | letEx # let
    | OpenParen expression CloseParen # parenthesized
    ;

literalEx
    : BOOLEAN # bool
    | DECIMAL # integer
    | FLOAT # floating
    ;

applicationEx
    : FUNID # singleApplication
    | applicationEx applicationTerm # multiApplication
    ;

applicationTerm
    : FUNID # funTerm
    | literalEx # literalTerm
    ;

lambdaEx: Backslash lambdaElems? DotArrow expression;

lambdaElems
    : FUNID # singleLambda
    | lambdaElems FUNID # multiLambda
    ;

letEx: LET (function | localFunctions) IN expression;
