package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

import java.util.Collections;
import java.util.HashMap;
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // null value means boring type
            if (value == null) {
                type = Type.Boring.INSTANCE;
                return new Utils.Tuple<>(Substitution.EMPTY, type);
            }
            // otherwise apply a type function
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
            // do nothing
        }

        /**
         * Accept a visitor to traverse the AST.
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // get existing binding
            Scheme binding = ctx.bindingOf(id);
            if (binding == null) {
                InferenceEngine.reportError(inputPosition,
                        String.format("unbound variable '%s'", id));
                type = Type.Error.INSTANCE;
            } else {
                // and instantiate the potentially polymorphic type (scheme) into a monomorphic one
                type = binding.instantiate().snd();
            }
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
         * Accept a visitor to traverse the AST.
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // infer left and right expressions' types
            Utils.Tuple<Substitution, Type> leftInference = left.infer(ctx);
            Utils.Tuple<Substitution, Type> rightInference =
                    right.infer(ctx.applySubstitution(leftInference.fst()));
            // create new type variable for the function type
            Type.Variable funTypeVar = InferenceEngine.newTypeVariable();
            Substitution subst = leftInference.fst()
                    .compose(rightInference.fst());
            try {
                // unify left expression type with function type
                Substitution applicationSubstitution = leftInference.snd()
                        .applySubstitution(rightInference.fst())
                        .unify(Type.FunctionApplication.arrowOf(
                                rightInference.snd(), funTypeVar));
                // propagate substitution
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
         * Accept a visitor to traverse the AST.
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // check if lambda param was already bound (duplicate params)
            if (!ctx.lambdaBind(paramId))
                InferenceEngine.reportError(inputPosition,
                        String.format("lambda variable '%s' already bound", paramId));
            // create new type variable and update context
            Type.Variable paramTypeVar = InferenceEngine.newTypeVariable();
            Context newCtx = new Context(ctx);
            newCtx.bind(paramId, new Scheme(Collections.emptySet(), paramTypeVar));
            // infer body expression type, create lambda function type and update context
            Utils.Tuple<Substitution, Type> bodyInference = expression.infer(newCtx);
            type = Type.FunctionApplication.arrowOf(
                    paramTypeVar.applySubstitution(bodyInference.fst()), bodyInference.snd());
            ctx.lambdaFree(paramId);
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
         * Accept a visitor to traverse the AST.
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // check for duplicate declarations within the same let
            Map<String, InputPosition> declarationPositions = new HashMap<>();
            Context newCtx = new Context(ctx);
            for (Declaration decl : localDeclarations.declarationList) {
                if (declarationPositions.containsKey(decl.id))
                    InferenceEngine.reportError(decl.inputPosition,
                            String.format("variable '%s' already declared at %s",
                                    decl.id, declarationPositions.get(decl.id)));
                else {
                    declarationPositions.put(decl.id, decl.inputPosition);
                    // while also updating the context with placeholder schemes,
                    // so that self and mutual recursion can be handled
                    newCtx.bind(decl.id, new Scheme(Collections.emptySet(), InferenceEngine.newTypeVariable()));
                }
            }
            // proceed to infer all local declarations
            Substitution subst = Substitution.EMPTY;
            for (Declaration decl : localDeclarations.declarationList) {
                Utils.Tuple<Substitution, Type> declInference = decl.expression.infer(newCtx);
                try {
                    // unifying types of known bindings,
                    // gradually composing substitutions and updating context
                    subst = subst.compose(declInference.fst())
                            .compose(newCtx.bindingOf(decl.id).type
                                    .applySubstitution(subst)
                                    .unify(declInference.snd()));
                    decl.expression.type = declInference.snd().applySubstitution(subst);
                    newCtx = newCtx.applySubstitution(subst);
                } catch (TypeException e) {
                    InferenceEngine.reportError(decl.inputPosition, e.getMessage());
                    decl.expression.type = Type.Error.INSTANCE;
                }
            }
            // finally generalize all types and check against actual user-defined schemes
            for (Declaration decl : localDeclarations.declarationList) {
                decl.expression.propagateSubstitution(subst);
                Scheme expectedScheme = decl.expression.type.generalize(newCtx);
                decl.checkScheme(expectedScheme);
                newCtx.bind(decl.id, decl.scheme());
            }
            // now it's possible to infer the expression type
            Utils.Tuple<Substitution, Type> exprInference = expression.infer(newCtx);
            subst = subst.compose(exprInference.fst());
            type = exprInference.snd().applySubstitution(subst);
            expression.propagateSubstitution(subst);
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
         * Accept a visitor to traverse the AST.
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
         * @param ctx current context
         * @return tuple of potential substitution and inferred type
         */
        @Override
        public Utils.Tuple<Substitution, Type> infer(Context ctx) {
            // infer condition, then and else branches' types
            Utils.Tuple<Substitution, Type> conditionInference = condition.infer(ctx);
            Context newCtx = ctx.applySubstitution(conditionInference.fst());
            // using the context updated with the condition substitution
            Utils.Tuple<Substitution, Type> thenInference = thenBranch.infer(newCtx);
            Utils.Tuple<Substitution, Type> elseInference =
                    elseBranch.infer(newCtx.applySubstitution(thenInference.fst()));
            try {
                // unify condition type with boolean type
                Substitution conditionSubstitution = conditionInference.snd().unify(BOOLEAN_TYPE);
                // and unify then and else branches' types
                Substitution thenElseSubstitution = thenInference.snd()
                        .applySubstitution(elseInference.fst())
                        .unify(elseInference.snd());
                // use the then branch as the if expression type
                type = thenInference.snd();
                // compose all substitutions
                Substitution subst = conditionInference.fst()
                        .compose(thenInference.fst())
                        .compose(elseInference.fst())
                        .compose(conditionSubstitution)
                        .compose(thenElseSubstitution);
                propagateSubstitution(subst);
                return new Utils.Tuple<>(subst, type);
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
         * Accept a visitor to traverse the AST.
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
