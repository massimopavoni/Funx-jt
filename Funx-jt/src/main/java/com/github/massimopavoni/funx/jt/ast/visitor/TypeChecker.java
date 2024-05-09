package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.TypeEnum;
import com.github.massimopavoni.funx.jt.ast.node.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Type checker for the AST tree.
 */
public final class TypeChecker extends ASTVisitor<Void> {
    /**
     * Types of currently in scope lambda parameters.
     */
    private final Map<String, Type> lambdaParamTypeMap = new HashMap<>();
    /**
     * Counter for type variables used in lambda parameters.
     */
    private int variableTypeCount = 0;
    /**
     * Current declaration type, used to match the statement.
     */
    private Type currentDeclarationType = null;
    /**
     * Current declaration type,
     * potentially partial, as it's used to populate lambda param type map.
     */
    private Type currentDeclarationPartialType = null;
    /**
     * Types of top level declarations.
     */
    private Map<String, Type> moduleDeclarationTypeMap = new HashMap<>();
    /**
     * Types of currently in scope local declarations.
     */
    private Map<String, Type> localDeclarationTypeMap = new HashMap<>();

    /**
     * Get the type for a primary node,
     * either from the constant value,
     * or searching a declaration within the current scope.
     *
     * @param primary primary node
     * @return type of the primary or null if not found
     */
    private Type getPrimaryType(Primary primary) {
        return switch (primary) {
            case Primary.Constant constant -> getConstantType(constant);
            case Primary.Variable variable -> getVariableType(variable);
            default -> throw new IllegalStateException("Primary is not a constant or variable");
        };
    }

    /**
     * Get a new type variable.
     *
     * @return new type variable
     */
    private Type.VariableType getNewVariableType() {
        return new Type.VariableType(String.format("t%d", variableTypeCount++));
    }

    /**
     * Get the type for a constant primary node.
     *
     * @param constant constant node
     * @return type of the constant or null if not found
     */
    private Type getConstantType(Primary.Constant constant) {
        TypeEnum constantType = TypeEnum.fromTypeClass(constant.value.getClass());
        return new Type.NamedType(constantType);
    }

    /**
     * Get the type for a variable primary node,
     * searching a declaration within the current scope.
     *
     * @param node variable node
     * @return type of the variable or null if not found
     */
    private Type getVariableType(Primary.Variable node) {
        Type type = lambdaParamTypeMap.getOrDefault(node.id,
                localDeclarationTypeMap.getOrDefault(node.id,
                        moduleDeclarationTypeMap.getOrDefault(node.id,
                                Optional.ofNullable(PreludeFunction.fromFunctionName(node.id))
                                        .map(f -> f.functionType)
                                        .orElse(null))));
        if (type == null)
            reportError(node.inputPosition,
                    String.format("reference to non-existing variable \"%s\"", node.id));
        return type;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitModule(ASTNode.Module node) {
        moduleDeclarationTypeMap = ((ASTNode.Declarations) node.declarations).declarationTypeMap;
        return visit(node.declarations);
    }

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitDeclarations(ASTNode.Declarations node) {
        return visit(node.declarationList);
    }

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitDeclaration(Declaration node) {
        if (!node.typeVarId.equals(node.id))
            reportError(node.inputPosition,
                    String.format("type id \"%s\" does not match declaration id \"%s\"",
                            node.typeVarId, node.id));
        currentDeclarationType = (Type) node.type;
        checkDeclarationType(node.statement);
        if (localDeclarationTypeMap.isEmpty())
            lambdaParamTypeMap.clear();
        if (node.statement instanceof Statement.Lambda)
            currentDeclarationPartialType = (Type) node.type;
        return visit(node.statement);
    }

    /**
     * Check the current declaration type against a statement.
     *
     * @param statement statement node
     */
    private void checkDeclarationType(ASTNode statement) {
        switch (currentDeclarationType) {
            case Type.NamedType type -> checkNamedType(type, statement);
            case Type.ArrowType type -> checkArrowType(type, statement);
            default -> {
                // No error
            }
        }
    }

    /**
     * Check a declaration named type against a statement.
     *
     * @param type      declaration type
     * @param statement statement to check
     */
    private void checkNamedType(Type.NamedType type, ASTNode statement) {
        switch (statement) {
            case Statement.Lambda lambda -> reportError(lambda.inputPosition,
                    String.format("named type \"%s\" does not match lambda statement", type));
            case Primary primary -> {
                Type primaryType = getPrimaryType(primary);
                if (primaryType != null && !primaryType.equals(type))
                    reportError(primary.inputPosition,
                            String.format("named type \"%s\" does not match primary type \"%s\"",
                                    type, primaryType));
            }
            default -> {
                // No error
            }
        }
    }

    /**
     * Check a declaration arrow type against a statement.
     *
     * @param type      declaration type
     * @param statement statement to check
     */
    private void checkArrowType(Type.ArrowType type, ASTNode statement) {
        switch (statement) {
            case Primary.Constant constant -> reportError(constant.inputPosition,
                    String.format("arrow type \"%s\" does not match constant type \"%s\"",
                            type, getConstantType(constant)));
            case Primary.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null && !variableType.equals(type))
                    reportError(variable.inputPosition,
                            String.format("arrow type \"%s\" does not match variable type \"%s\"",
                                    type, variableType));
            }
            default -> {
                // No error
            }
        }
    }

    /**
     * Visit a {@link Type.NamedType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitNamedType(Type.NamedType node) {
        throw new IllegalStateException(String.format("%s should not be visited directly by the TypeChecker",
                Type.NamedType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Type.VariableType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitVariableType(Type.VariableType node) {
        throw new IllegalStateException(String.format("%s should not be visited directly by the TypeChecker",
                Type.VariableType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitArrowType(Type.ArrowType node) {
        throw new IllegalStateException(String.format("%s should not be visited directly by the TypeChecker",
                Type.ArrowType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitLambda(Statement.Lambda node) {
        switch (currentDeclarationPartialType) {
            case null -> lambdaParamTypeMap.put(node.paramId, getNewVariableType());
            case Type.ArrowType arrowType -> {
                lambdaParamTypeMap.put(node.paramId, (Type) arrowType.input);
                currentDeclarationPartialType = (Type) arrowType.output;
            }
            default -> reportError(node.inputPosition,
                    String.format("non-arrow type \"%s\" does not match lambda statement",
                            currentDeclarationPartialType));
        }
        if (!(node.statement instanceof Statement.Lambda))
            currentDeclarationPartialType = null;
        return visit(node.statement);
    }

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitLet(Statement.Let node) {
        localDeclarationTypeMap = ((ASTNode.Declarations) node.localDeclarations).declarationTypeMap;
        visit(List.of(node.localDeclarations, node.statement));
        checkDeclarationType(node.statement);
        localDeclarationTypeMap.clear();
        return null;
    }

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitIf(Statement.If node) {
        switch (node.condition) {
            case Primary.Constant constant -> {
                if (!(constant.value instanceof Boolean))
                    reportError(constant.inputPosition,
                            String.format("type \"%s\" of constant in if condition is not boolean",
                                    constant.value));
            }
            case Primary.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null && !(variableType instanceof Type.VariableType)
                        && !variableType.equals(new Type.NamedType(TypeEnum.BOOLEAN)))
                    reportError(variable.inputPosition,
                            String.format("type \"%s\" of variable in if condition is not boolean",
                                    variableType));
            }
            default -> {
                // No error
            }
        }
        return visit(List.of(node.condition, node.thenBranch, node.elseBranch));
    }

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitApplication(Expression.Application node) {
        switch (node.left) {
            case Primary.Constant constant -> reportError(constant.inputPosition,
                    String.format("attempt to use constant value \"%s\" as function",
                            constant.value));
            case Primary.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null) {
                    switch (variableType) {
                        case Type.NamedType type -> reportError(variable.inputPosition,
                                String.format(
                                        "attempt to use function \"%s\" with simple type \"%s\" in application",
                                        variable.id, type));
                        case Type.ArrowType type -> {
                            if (node.right instanceof Primary rightPrimary) {
                                Type rightType = getPrimaryType(rightPrimary);
                                if (rightType != null && !(rightType instanceof Type.VariableType)
                                        && !rightType.equals(type.input))
                                    reportError(variable.inputPosition,
                                            String.format(
                                                    "function \"%s\" has input type \"%s\" but was applied type \"%s\"",
                                                    variable.id, type.input, rightType));
                            }
                        }
                        default -> {
                            // No error
                        }
                    }
                }
            }
            default -> {
                // No error
            }
        }
        return visit(List.of(node.left, node.right));
    }

    /**
     * Visit a {@link Primary.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitConstant(Primary.Constant node) {
        return defaultResult();
    }

    /**
     * Visit a {@link Primary.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitVariable(Primary.Variable node) {
        return defaultResult();
    }
}
