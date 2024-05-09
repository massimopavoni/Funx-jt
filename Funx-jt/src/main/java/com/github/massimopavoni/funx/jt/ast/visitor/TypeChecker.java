package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.TypeEnum;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.node.Type;

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
     * Current declaration type, used to match an expression.
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
    private Type getPrimaryType(Expression primary) {
        return switch (primary) {
            case Expression.Constant constant -> getConstantType(constant);
            case Expression.Variable variable -> getVariableType(variable);
            default -> throw new IllegalStateException("Expression is not a constant or variable");
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
     * Get the type for a constant expression node.
     *
     * @param constant constant node
     * @return type of the constant or null if not found
     */
    private Type getConstantType(Expression.Constant constant) {
        TypeEnum constantType = TypeEnum.fromTypeClass(constant.value.getClass());
        return new Type.NamedType(constantType);
    }

    /**
     * Get the type for a variable expression node,
     * searching a declaration within the current scope.
     *
     * @param node variable node
     * @return type of the variable or null if not found
     */
    private Type getVariableType(Expression.Variable node) {
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
        checkDeclarationType(node.expression);
        if (localDeclarationTypeMap.isEmpty())
            lambdaParamTypeMap.clear();
        if (node.expression instanceof Expression.Lambda)
            currentDeclarationPartialType = (Type) node.type;
        return visit(node.expression);
    }

    /**
     * Check the current declaration type against an expression.
     *
     * @param expression expression node
     */
    private void checkDeclarationType(ASTNode expression) {
        switch (currentDeclarationType) {
            case Type.NamedType type -> checkNamedType(type, expression);
            case Type.ArrowType type -> checkArrowType(type, expression);
            default -> {
                // No error
            }
        }
    }

    /**
     * Check a declaration named type against an expression.
     *
     * @param type       declaration type
     * @param expression expression to check
     */
    private void checkNamedType(Type.NamedType type, ASTNode expression) {
        switch (expression) {
            case Expression.Lambda lambda -> reportError(lambda.inputPosition,
                    String.format("named type \"%s\" does not match lambda expression", type));
            case Expression primary when
                    (primary instanceof Expression.Constant || primary instanceof Expression.Variable) -> {
                Type primaryType = getPrimaryType(primary);
                if (primaryType != null && !primaryType.equals(type))
                    reportError(primary.inputPosition,
                            String.format("named type \"%s\" does not match expression type \"%s\"",
                                    type, primaryType));
            }
            default -> {
                // No error
            }
        }
    }

    /**
     * Check a declaration arrow type against an expression.
     *
     * @param type       declaration type
     * @param expression expression to check
     */
    private void checkArrowType(Type.ArrowType type, ASTNode expression) {
        switch (expression) {
            case Expression.Constant constant -> reportError(constant.inputPosition,
                    String.format("arrow type \"%s\" does not match constant type \"%s\"",
                            type, getConstantType(constant)));
            case Expression.Variable variable -> {
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
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitLambda(Expression.Lambda node) {
        switch (currentDeclarationPartialType) {
            case null -> lambdaParamTypeMap.put(node.paramId, getNewVariableType());
            case Type.ArrowType arrowType -> {
                lambdaParamTypeMap.put(node.paramId, (Type) arrowType.input);
                currentDeclarationPartialType = (Type) arrowType.output;
            }
            default -> reportError(node.inputPosition,
                    String.format("non-arrow type \"%s\" does not match lambda expression",
                            currentDeclarationPartialType));
        }
        if (!(node.expression instanceof Expression.Lambda))
            currentDeclarationPartialType = null;
        return visit(node.expression);
    }

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitLet(Expression.Let node) {
        localDeclarationTypeMap = ((ASTNode.Declarations) node.localDeclarations).declarationTypeMap;
        visit(List.of(node.localDeclarations, node.expression));
        checkDeclarationType(node.expression);
        localDeclarationTypeMap.clear();
        return null;
    }

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitIf(Expression.If node) {
        switch (node.condition) {
            case Expression.Constant constant -> {
                if (!(constant.value instanceof Boolean))
                    reportError(constant.inputPosition,
                            String.format("type \"%s\" of constant in if condition is not boolean",
                                    constant.value));
            }
            case Expression.Variable variable -> {
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
            case Expression.Constant constant -> reportError(constant.inputPosition,
                    String.format("attempt to use constant value \"%s\" as function",
                            constant.value));
            case Expression.Variable variable -> {
                Type variableType = getVariableType(variable);
                if (variableType != null) {
                    switch (variableType) {
                        case Type.NamedType type -> reportError(variable.inputPosition,
                                String.format(
                                        "attempt to use function \"%s\" with simple type \"%s\" in application",
                                        variable.id, type));
                        case Type.ArrowType type -> {
                            if (node.right instanceof Expression rightPrimary
                                    && (rightPrimary instanceof Expression.Constant
                                    || rightPrimary instanceof Expression.Variable)) {
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
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitConstant(Expression.Constant node) {
        return defaultResult();
    }

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public Void visitVariable(Expression.Variable node) {
        return defaultResult();
    }
}
