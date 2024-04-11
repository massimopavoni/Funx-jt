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
    | parenthesizedEx # paren
    ;

parenthesizedEx: OpenParen expression CloseParen;

literalEx
    : BOOLEAN # bool
    | INTEGER # integer
    | FLOAT # floating
    ;

applicationEx
    : FUNID # singleApp
    | applicationEx applicationTerm # multiApp
    | parenthesizedEx applicationTerm # leftParenApp
    | applicationEx parenthesizedEx # rightParenApp
    | parenthesizedEx parenthesizedEx # multiParenApp
    ;

applicationTerm
    : FUNID # funTerm
    | literalEx # litTerm
    ;

lambdaEx: Backslash lambdaElems? DotArrow expression;

lambdaElems
    : FUNID # singleLambda
    | lambdaElems FUNID # multiLambda
    ;

letEx: LET (function | localFunctions) IN expression;
