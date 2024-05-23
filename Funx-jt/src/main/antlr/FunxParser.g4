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
    : (declarationType NEWLINE)?
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
    | VARID # typeVar
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
    | <assoc = right> expression bop = Dot expression # composeExpression // infixr 9
    | expression bop = (Divide | Modulo | Multiply) expression # divModMultExpression // infixl 7
    | expression bop = (Add | Subtract) expression # addSubExpression // infixl 6
    | expression
        bop = (GreaterThan | GreaterThanEquals | LessThan | LessThanEquals)
        expression # compExpression // infix 4
    | expression bop = (EqualsEquals | NotEquals) expression # eqExpression // infix 4
    | uop = Not expression # notExpression // prefix 4
    | <assoc = right> expression bop = And expression # andExpression // infixr 3
    | <assoc = right> expression bop = Or expression # orExpression // infixr 2
    | <assoc = right> expression bop = Dollar expression # rightAppExpression // infixr 0
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