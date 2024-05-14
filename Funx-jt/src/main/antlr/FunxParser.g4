parser grammar FunxParser;

options { tokenVocab = FunxLexer; }

// ----------------------------------------------------------------
// Module
module: (MODULE MODULEID (Dot MODULEID)* NEWLINE+)? (main NEWLINE+)? declarations EOF;

declarations: declaration (NEWLINE declaration?)*;

main
    : id = MAIN Equals statement
        with?
    ;

// ----------------------------------------------------------------
// Declaration
declaration
    : declarationType NEWLINE
        id = VARID lambdaParams? Equals statement
        with?
    ;

declarationType: id = VARID Colon typeElems;

with: NEWLINE WITH localDeclarations OUT;

localDeclarations: NEWLINE declarations NEWLINE;

// ----------------------------------------------------------------
// Type
typeElems
    : OpenParen typeElems CloseParen # parenType
    | TYPE # namedType
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
    | constant # constPrimary
    | VARID # varPrimary
    ;

// ----------------------------------------------------------------
// Lambda
lambda: Backslash lambdaParams? Arrow statement;

lambdaParams: VARID+;

// ----------------------------------------------------------------
// Let
let: LET localDeclarations IN statement;

// ----------------------------------------------------------------
// If
ifS: IF statement THEN statement ELSE statement FI;

// ----------------------------------------------------------------
// Constant
constant
    : BOOL
    | numConstant
    ;

numConstant: INT;