package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Type checker for the AST tree.
 */
public final class TypeChecker extends ASTVisitor<Void> {
    /**
     * Types of top level declarations.
     */
    private Map<String, Type> moduleDeclarationTypeMap;
    /**
     * Types of currently in scope local declarations.
     */
    private Map<String, Type> localDeclarationTypeMap;

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
     * Get the type for a constant primary node.
     *
     * @param constant constant node
     * @return type of the constant or null if not found
     */
    private Type getConstantType(Primary.Constant constant) {
        TypeEnum constantType = TypeEnum.fromTypeClass(constant.value.getClass());
        return new Type.SimpleType(constantType);
    }

    /**
     * Get the type for a variable primary node,
     * searching a declaration within the current scope.
     *
     * @param node variable node
     * @return type of the variable or null if not found
     */
    private Type getVariableType(Primary.Variable node) {
        Type type = localDeclarationTypeMap.getOrDefault(node.id,
                moduleDeclarationTypeMap.getOrDefault(node.id,
                        Optional.ofNullable(PreludeFunction.fromFunctionName(node.id))
                                .map(f -> f.functionType)
                                .orElse(null)));
        if (type == null)
            reportError(String.format("reference to non-existing declaration \"%s\"", node.id));
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
            reportError(String.format("type id \"%s\" does not match declaration id \"%s\"",
                    node.typeVarId, node.id));
        switch (node.type) {
            case Type.SimpleType type -> checkSimpleType(type, node.statement);
            case Type.ArrowType type -> checkArrowType(type, node.statement);
            default -> {
                // No error
            }
        }
        return visit(node.statement);
    }

    /**
     * Check a declaration simple type against a statement.
     *
     * @param type      declaration type
     * @param statement statement to check
     */
    private void checkSimpleType(Type.SimpleType type, ASTNode statement) {
        switch (statement) {
            case Statement.Lambda ignored ->
                    reportError(String.format("simple type \"%s\" does not match lambda statement", type));
            case Primary primary -> {
                Type primaryType = getPrimaryType(primary);
                if (primaryType != null && !primaryType.equals(type))
                    reportError(String.format("simple type \"%s\" does not match primary type \"%s\"",
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
            case Primary.Constant constant ->
                    reportError(String.format("arrow type \"%s\" does not match constant type \"%s\"",
                            type, getConstantType(constant)));
            case Primary.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null && !variableType.equals(type))
                    reportError(String.format("arrow type \"%s\" does not match variable type \"%s\"",
                            type, variableType));
            }
            default -> {
                // No error
            }
        }
    }

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitSimpleType(Type.SimpleType node) {
        throw new IllegalStateException("Type.SimpleType should not be visited directly by the TypeChecker.");
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitArrowType(Type.ArrowType node) {
        throw new IllegalStateException("Type.SimpleType should not be visited directly by the TypeChecker.");
    }

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitLambda(Statement.Lambda node) {
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
        localDeclarationTypeMap = Collections.emptyMap();
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
            case Primary.Constant constant ->
                    reportError(String.format("attempt to use constant value \"%s\" as function",
                            constant.value));
            case Primary.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null) {
                    switch (variableType) {
                        case Type.SimpleType type -> reportError(String.format(
                                "attempt to use function \"%s\" with simple type \"%s\" in application",
                                variable.id, type));
                        case Type.ArrowType type -> {
                            if (node.right instanceof Primary rightPrimary) {
                                Type rightType = getPrimaryType(rightPrimary);
                                if (rightType != null && !rightType.equals(type.input))
                                    reportError(String.format(
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
