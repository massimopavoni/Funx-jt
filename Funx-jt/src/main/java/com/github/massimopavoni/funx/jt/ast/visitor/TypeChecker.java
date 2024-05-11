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
     * Illegal state message.
     */
    private static final String ILLEGAL_STATE_MESSAGE = "%s should not be visited directly by the TypeChecker";
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
     * Default constructor.
     */
    public TypeChecker() {
        // Empty constructor
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
     * @param variable variable node
     * @return type of the variable or null if not found
     */
    private Type getVariableType(Expression.Variable variable) {
        Type type = lambdaParamTypeMap.getOrDefault(variable.id,
                localDeclarationTypeMap.getOrDefault(variable.id,
                        moduleDeclarationTypeMap.getOrDefault(variable.id,
                                Optional.ofNullable(PreludeFunction.fromFunctionName(variable.id))
                                        .map(f -> f.functionType)
                                        .orElse(null))));
        if (type == null)
            reportError(variable.inputPosition,
                    String.format("reference to non-existing variable \"%s\"", variable.id));
        return type;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param module module node
     * @return visitor result
     */
    @Override
    public Void visitModule(ASTNode.Module module) {
        moduleDeclarationTypeMap = ((ASTNode.Declarations) module.declarations).declarationTypeMap;
        return visit(module.declarations);
    }

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param declarations declarations node
     * @return visitor result
     */
    @Override
    public Void visitDeclarations(ASTNode.Declarations declarations) {
        return visit(declarations.declarationList);
    }

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param declaration declaration node
     * @return visitor result
     */
    @Override
    public Void visitDeclaration(Declaration declaration) {
        if (!declaration.typeVarId.equals(declaration.id))
            reportError(declaration.inputPosition,
                    String.format("type id \"%s\" does not match declaration id \"%s\"",
                            declaration.typeVarId, declaration.id));
        currentDeclarationType = (Type) declaration.type;
        checkDeclarationType(declaration.expression);
        if (localDeclarationTypeMap.isEmpty())
            lambdaParamTypeMap.clear();
        if (declaration.expression instanceof Expression.Lambda)
            currentDeclarationPartialType = (Type) declaration.type;
        return visit(declaration.expression);
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
            case Expression primary
                    when primary instanceof Expression.Constant
                    || primary instanceof Expression.Variable -> {
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
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitNamedType(Type.NamedType type) {
        throw new IllegalStateException(String.format(ILLEGAL_STATE_MESSAGE,
                Type.NamedType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Type.VariableType} AST node.
     *
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitVariableType(Type.VariableType type) {
        throw new IllegalStateException(String.format(ILLEGAL_STATE_MESSAGE,
                Type.VariableType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitArrowType(Type.ArrowType type) {
        throw new IllegalStateException(String.format(ILLEGAL_STATE_MESSAGE,
                Type.ArrowType.class.getSimpleName()));
    }

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param lambda lambda node
     * @return visitor result
     */
    @Override
    public Void visitLambda(Expression.Lambda lambda) {
        switch (currentDeclarationPartialType) {
            case null -> lambdaParamTypeMap.put(lambda.paramId, getNewVariableType());
            case Type.ArrowType arrowType -> {
                lambdaParamTypeMap.put(lambda.paramId, (Type) arrowType.input);
                currentDeclarationPartialType = (Type) arrowType.output;
            }
            default -> reportError(lambda.inputPosition,
                    String.format("non-arrow type \"%s\" does not match lambda expression",
                            currentDeclarationPartialType));
        }
        if (!(lambda.expression instanceof Expression.Lambda))
            currentDeclarationPartialType = null;
        return visit(lambda.expression);
    }

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param let let node
     * @return visitor result
     */
    @Override
    public Void visitLet(Expression.Let let) {
        localDeclarationTypeMap = ((ASTNode.Declarations) let.localDeclarations).declarationTypeMap;
        checkDeclarationType(let.expression);
        visit(List.of(let.localDeclarations, let.expression));
        localDeclarationTypeMap.clear();
        return null;
    }

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param ifE if node
     * @return visitor result
     */
    @Override
    public Void visitIf(Expression.If ifE) {
        switch (ifE.condition) {
            case Expression.Constant constant
                    when !(constant.value instanceof Boolean) -> reportError(constant.inputPosition,
                    String.format("type \"%s\" of constant in if condition is not boolean",
                            constant.value));
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
        return visit(List.of(ifE.condition, ifE.thenBranch, ifE.elseBranch));
    }

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param application application node
     * @return visitor result
     */
    @Override
    public Void visitApplication(Expression.Application application) {
        switch (application.left) {
            case Expression.Constant constant -> reportError(constant.inputPosition,
                    String.format("attempt to use constant value \"%s\" as function",
                            constant.value));
            case Expression.Variable variable -> checkApplicationVariable(application, variable);
            default -> {
                // No error
            }
        }
        return visit(List.of(application.left, application.right));
    }

    /**
     * Check a variable as left node in an application.
     *
     * @param application application node
     * @param variable    variable node
     */
    private void checkApplicationVariable(Expression.Application application, Expression.Variable variable) {
        Type variableType = getVariableType(variable);
        if (variableType != null) {
            switch (variableType) {
                case Type.NamedType type -> reportError(variable.inputPosition,
                        String.format(
                                "attempt to use function \"%s\" with simple type \"%s\" in application",
                                variable.id, type));
                case Type.ArrowType type
                        when application.right instanceof Expression rightPrimary
                        && (rightPrimary instanceof Expression.Constant
                        || rightPrimary instanceof Expression.Variable) -> {
                    Type rightType = getPrimaryType(rightPrimary);
                    if (rightType != null && !(rightType instanceof Type.VariableType)
                            && !rightType.equals(type.input))
                        reportError(variable.inputPosition,
                                String.format(
                                        "function \"%s\" has input type \"%s\" but was applied type \"%s\"",
                                        variable.id, type.input, rightType));
                }
                default -> {
                    // No error
                }
            }
        }
    }

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param constant constant node
     * @return visitor result
     */
    @Override
    public Void visitConstant(Expression.Constant constant) {
        return defaultResult();
    }

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param variable variable node
     * @return visitor result
     */
    @Override
    public Void visitVariable(Expression.Variable variable) {
        return defaultResult();
    }
}
