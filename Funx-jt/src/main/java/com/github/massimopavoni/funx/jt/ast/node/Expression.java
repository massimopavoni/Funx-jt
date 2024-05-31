package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.BOOLEAN_TYPE;

/**
 * Base class for expression nodes.
 */
public abstract sealed class Expression extends ASTNode implements Inferable {
    /**
     * Expression node inferred type.
     */
    protected Type type;

    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     *
     * @param inputPosition input source code node position
     */
    protected Expression(InputPosition inputPosition) {
        super(inputPosition);
    }

    /**
     * Propagate a substitution within the expression.
     *
     * @param substitution substitution to propagate
     */
    protected abstract void propagateSubstitution(Substitution substitution);

    /**
     * Inferred type getter.
     *
     * @return inferred type
     */
    public Type type() {
        return type;
    }

    /**
     * Constant expression class.
     */
    public static final class Constant extends Expression {
        /**
         * Constant value.
         */
        public final Object value;

        /**
         * Constructor for the constant expression node.
         *
         * @param inputPosition input source code node position
         * @param value         constant value
         */
        public Constant(InputPosition inputPosition, Object value) {
            super(inputPosition);
            this.value = value;
        }

        /**
         * Inference method for constant expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            if (value == null) {
                type = Type.Boring.INSTANCE;
                return new Utils.Tuple<>(Substitution.EMPTY, type);
            }
            TypeFunction typeFunction = TypeFunction.fromClass(value.getClass());
            if (typeFunction == null) {
                InferenceEngine.reportError(inputPosition,
                        String.format("cannot infer type of constant '%s'", value));
                type = Type.Error.INSTANCE;
            } else
                type = new Type.FunctionApplication(typeFunction, Collections.emptyList());
            return new Utils.Tuple<>(Substitution.EMPTY, type);
        }

        /**
         * Propagate a substitution within the constant.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            // Do nothing
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitConstant(this);
        }
    }

    /**
     * Variable expression class.
     */
    public static final class Variable extends Expression {
        /**
         * Variable identifier.
         */
        public final String id;

        /**
         * Constructor for the variable expression node.
         *
         * @param inputPosition input source code node position
         * @param id            variable identifier
         */
        public Variable(InputPosition inputPosition, String id) {
            super(inputPosition);
            this.id = id;
        }

        /**
         * Inference method for variable expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            Scheme binding = env.bindingOf(id);
            if (binding == null) {
                InferenceEngine.reportError(inputPosition,
                        String.format("unbound variable '%s'", id));
                type = Type.Error.INSTANCE;
            } else
                type = binding.instantiate().snd();
            return new Utils.Tuple<>(Substitution.EMPTY, type);
        }

        /**
         * Propagate a substitution within the variable.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            type = type.applySubstitution(substitution);
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitVariable(this);
        }
    }

    /**
     * Application expression class.
     */
    public static final class Application extends Expression {
        /**
         * Application left expression.
         */
        public final Expression left;
        /**
         * Application right expression.
         */
        public final Expression right;

        /**
         * Constructor for the application expression node.
         *
         * @param inputPosition input source code node position
         * @param left          left expression
         * @param right         right expression
         */
        public Application(InputPosition inputPosition, ASTNode left, ASTNode right) {
            super(inputPosition);
            this.left = (Expression) left;
            this.right = (Expression) right;
        }

        /**
         * Inference method for application expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            Utils.Tuple<Substitution, Type> leftInference = left.infer(env);
            Utils.Tuple<Substitution, Type> rightInference =
                    right.infer(env.applySubstitution(leftInference.fst()));
            Type.Variable funTypeVar = InferenceEngine.newTypeVariable();
            Substitution subst = leftInference.fst()
                    .compose(rightInference.fst());
            try {
                Substitution applicationSubstitution = leftInference.snd()
                        .applySubstitution(rightInference.fst())
                        .unify(new Type.FunctionApplication(TypeFunction.ARROW,
                                List.of(rightInference.snd(), funTypeVar)));
                type = funTypeVar.applySubstitution(applicationSubstitution);
                left.propagateSubstitution(applicationSubstitution);
                right.propagateSubstitution(applicationSubstitution);
                return new Utils.Tuple<>(subst.compose(applicationSubstitution), type);
            } catch (TypeException e) {
                InferenceEngine.reportError(inputPosition, e.getMessage());
                type = Type.Error.INSTANCE;
                return new Utils.Tuple<>(subst, type);
            }
        }

        /**
         * Propagate a substitution within the application.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            type = type.applySubstitution(substitution);
            left.propagateSubstitution(substitution);
            right.propagateSubstitution(substitution);
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitApplication(this);
        }
    }

    /**
     * Lambda expression class.
     */
    public static final class Lambda extends Expression {
        /**
         * Parameter identifier.
         */
        public final String paramId;
        /**
         * Expression node.
         */
        public final Expression expression;

        /**
         * Constructor for the lambda expression node.
         *
         * @param inputPosition input source code node position
         * @param paramId       parameter identifier
         * @param expression    expression node
         */
        public Lambda(InputPosition inputPosition, String paramId, ASTNode expression) {
            super(inputPosition);
            this.paramId = paramId;
            this.expression = (Expression) expression;
        }

        /**
         * Inference method for lambda expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            if (!env.lambdaBind(paramId))
                InferenceEngine.reportError(inputPosition,
                        String.format("lambda variable '%s' already bound", paramId));
            Type.Variable paramTypeVar = InferenceEngine.newTypeVariable();
            Environment newEnv = new Environment(env);
            newEnv.bind(paramId, new Scheme(Collections.emptySet(), paramTypeVar));
            Utils.Tuple<Substitution, Type> bodyInference = expression.infer(newEnv);
            type = new Type.FunctionApplication(TypeFunction.ARROW,
                    List.of(paramTypeVar.applySubstitution(bodyInference.fst()), bodyInference.snd()));
            env.lambdaFree(paramId);
            return bodyInference.setSnd(type);
        }

        /**
         * Propagate a substitution within the lambda.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            type = type.applySubstitution(substitution);
            expression.propagateSubstitution(substitution);
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitLambda(this);
        }
    }

    /**
     * Let expression class.
     */
    public static final class Let extends Expression {
        /**
         * Local declarations node.
         */
        public final Declarations localDeclarations;
        /**
         * Expression node.
         */
        public final Expression expression;

        /**
         * Constructor for the let expression node.
         *
         * @param inputPosition     input source code node position
         * @param localDeclarations local declarations node
         * @param expression        expression node
         */
        public Let(InputPosition inputPosition, ASTNode localDeclarations, ASTNode expression) {
            super(inputPosition);
            this.localDeclarations = (Declarations) localDeclarations;
            this.expression = (Expression) expression;
        }

        /**
         * Inference method for let expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            Map<String, InputPosition> declarationPositions = new HashMap<>();
            Environment newEnv = new Environment(env);
            for (Declaration decl : localDeclarations.declarationList) {
                if (declarationPositions.containsKey(decl.id))
                    InferenceEngine.reportError(decl.inputPosition,
                            String.format("variable '%s' already declared at %s",
                                    decl.id, declarationPositions.get(decl.id)));
                else {
                    declarationPositions.put(decl.id, decl.inputPosition);
                    newEnv.bind(decl.id, new Scheme(Collections.emptySet(), InferenceEngine.newTypeVariable()));
                }
            }
            Substitution subst = Substitution.EMPTY;
            for (Declaration decl : localDeclarations.declarationList) {
                Utils.Tuple<Substitution, Type> declInference = decl.expression.infer(newEnv);
                try {
                    subst = subst.compose(declInference.fst())
                            .compose(newEnv.bindingOf(decl.id).type
                                    .applySubstitution(subst)
                                    .unify(declInference.snd()));
                    decl.expression.type = declInference.snd().applySubstitution(subst);
                    newEnv = newEnv.applySubstitution(subst);
                } catch (TypeException e) {
                    InferenceEngine.reportError(decl.inputPosition, e.getMessage());
                    decl.expression.type = Type.Error.INSTANCE;
                }
            }
            for (Declaration decl : localDeclarations.declarationList) {
                decl.expression.propagateSubstitution(subst);
                Scheme expectedScheme = decl.expression.type.generalize(env);
                decl.checkScheme(expectedScheme, env);
                newEnv.bind(decl.id, decl.scheme());
            }
            Utils.Tuple<Substitution, Type> exprInference = expression.infer(newEnv);
            subst = subst.compose(exprInference.fst());
            type = exprInference.snd().applySubstitution(subst);
            propagateSubstitution(subst);
            return new Utils.Tuple<>(subst, type);
        }

        /**
         * Propagate a substitution within the let.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            type = type.applySubstitution(substitution);
            expression.propagateSubstitution(substitution);
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitLet(this);
        }
    }

    /**
     * If expression class.
     */
    public static final class If extends Expression {
        /**
         * Condition expression node.
         */
        public final Expression condition;
        /**
         * Then branch expression node.
         */
        public final Expression thenBranch;
        /**
         * Else branch expression node.
         */
        public final Expression elseBranch;

        /**
         * Constructor for the if expression node.
         *
         * @param inputPosition input source code node position
         * @param condition     condition expression
         * @param thenBranch    then branch expression
         * @param elseBranch    else branch expression
         */
        public If(InputPosition inputPosition, ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
            super(inputPosition);
            this.condition = (Expression) condition;
            this.thenBranch = (Expression) thenBranch;
            this.elseBranch = (Expression) elseBranch;
        }

        /**
         * Inference method for if expressions.
         *
         * @param env current environment
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Environment env) {
            Utils.Tuple<Substitution, Type> conditionInference = condition.infer(env);
            Environment newEnv = env.applySubstitution(conditionInference.fst());
            Utils.Tuple<Substitution, Type> thenInference = thenBranch.infer(newEnv);
            Utils.Tuple<Substitution, Type> elseInference =
                    elseBranch.infer(newEnv.applySubstitution(thenInference.fst()));
            try {
                Substitution conditionSubstitution = conditionInference.snd().unify(BOOLEAN_TYPE);
                Substitution thenElseSubstitution = thenInference.snd()
                        .applySubstitution(elseInference.fst())
                        .unify(elseInference.snd());
                type = thenInference.snd().applySubstitution(thenElseSubstitution);
                propagateSubstitution(thenElseSubstitution);
                return new Utils.Tuple<>(conditionInference.fst()
                        .compose(thenInference.fst())
                        .compose(elseInference.fst())
                        .compose(conditionSubstitution)
                        .compose(thenElseSubstitution),
                        type);
            } catch (TypeException e) {
                InferenceEngine.reportError(inputPosition, e.getMessage());
                type = Type.Error.INSTANCE;
                return new Utils.Tuple<>(conditionInference.fst()
                        .compose(thenInference.fst())
                        .compose(elseInference.fst()),
                        type);
            }
        }

        /**
         * Propagate a substitution within the if.
         *
         * @param substitution substitution to propagate
         */
        @Override
        protected void propagateSubstitution(Substitution substitution) {
            type = type.applySubstitution(substitution);
            condition.propagateSubstitution(substitution);
            thenBranch.propagateSubstitution(substitution);
            elseBranch.propagateSubstitution(substitution);
        }

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitIf(this);
        }
    }
}
