parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

program: functions EOF;

functions: function (NEWLINE function?)*;

function: FUNID lambdaElems? Equals expression (NEWLINE with)?;

with: WITH localFunctions OUT;

localFunctions: NEWLINE functions NEWLINE;

expression
    : literalEx # lit
    | applicationEx # app
    | lambdaEx # lambda
    | letEx # let
    | ifEx # if
    | parenthesizedEx # paren
    ;

parenthesizedEx: OpenParen expression CloseParen;

literalEx
    : BOOLEAN # bool
    | INTEGER # int
    | FLOAT # float
    ;

applicationEx
    : FUNID # singleApp
    | applicationEx applicationTerm # multiApp
    | parenthesizedEx # parenApp
    ;

applicationTerm
    : FUNID # funTerm
    | literalEx # litTerm
    | parenthesizedEx # parenTerm
    ;

lambdaEx: Backslash lambdaElems? DotArrow expression;

lambdaElems
    : FUNID # singleLambda
    | lambdaElems FUNID # multiLambda
    ;

letEx: LET (function | localFunctions) IN expression;

ifEx: IF expression THEN expression ELSE expression FI;
