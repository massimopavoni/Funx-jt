package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

import java.util.Collections;
import java.util.List;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.BOOLEAN_TYPE;

/**
 * Base class for expression nodes.
 */
public sealed abstract class Expression extends ASTNode
        permits Expression.Constant, Expression.Variable, Expression.Application,
        Expression.Lambda, Expression.Let, Expression.If {
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

    public Type type() {
        return type;
    }

    public abstract Utils.Pair<Substitution, Type> infer(Environment env);

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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) {
            TypeFunction typeFunction = TypeFunction.fromClass(value.getClass());
            if (typeFunction == null) {
                InferenceEngine.reportError(inputPosition,
                        String.format("cannot infer type of constant '%s'", value));
                type = Type.TypeError.INSTANCE;
            } else
                type = new Type.FunctionApplication(typeFunction, Collections.emptyList());
            return new Utils.Pair<>(Substitution.EMPTY, type);
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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) {
            Scheme binding = env.bindingOf(id);
            if (binding == null) {
                InferenceEngine.reportError(inputPosition,
                        String.format("unbound variable '%s'", id));
                type = Type.TypeError.INSTANCE;
            } else
                type = binding.instantiate();
            return new Utils.Pair<>(Substitution.EMPTY, type);
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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) {
            Utils.Pair<Substitution, Type> leftInference = left.infer(env);
            Utils.Pair<Substitution, Type> rightInference =
                    right.infer(env.applySubstitution(leftInference.fst));
            Type.Variable funTypeVar = InferenceEngine.newTypeVariable();
            Substitution subst = leftInference.fst
                    .compose(rightInference.fst);
            try {
                Substitution applicationSubstitution = leftInference.snd
                        .applySubstitution(rightInference.fst)
                        .unify(new Type.FunctionApplication(TypeFunction.ARROW,
                                List.of(rightInference.snd, funTypeVar)));
                type = funTypeVar.applySubstitution(applicationSubstitution);
                return new Utils.Pair<>(subst.compose(applicationSubstitution), type);
            } catch (TypeException e) {
                InferenceEngine.reportError(inputPosition, e.getMessage());
            }
            type = Type.TypeError.INSTANCE;
            return new Utils.Pair<>(subst, type);
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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) {
            Type.Variable paramTypeVar = InferenceEngine.newTypeVariable();
            Utils.Pair<Substitution, Type> bodyInference = expression
                    .infer(env.bind(paramId, new Scheme(Collections.emptySet(), paramTypeVar)));
            type = new Type.FunctionApplication(TypeFunction.ARROW,
                    List.of(paramTypeVar.applySubstitution(bodyInference.fst), bodyInference.snd));
            return bodyInference.setSnd(type);
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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) {
            Environment newEnv = new Environment(env);
            for (Declaration decl : localDeclarations.declarations) {
                if (newEnv.bindingOf(decl.id) != null)
                    InferenceEngine.reportError(decl.inputPosition,
                            String.format("variable '%s' rebound", decl.id));
                else
                    newEnv.bind(decl.id, new Scheme(Collections.emptySet(), InferenceEngine.newTypeVariable()));
            }
            Substitution subst = Substitution.EMPTY;
            for (Declaration decl : localDeclarations.declarations) {
                Utils.Pair<Substitution, Type> declInference = decl.expression.infer(newEnv);
                try {
                    subst = subst.compose(newEnv.bindingOf(decl.id).type
                            .applySubstitution(declInference.fst)
                            .unify(declInference.snd));
                } catch (TypeException e) {
                    InferenceEngine.reportError(decl.inputPosition, e.getMessage());
                }
                subst = subst.compose(declInference.fst);
                newEnv = newEnv.applySubstitution(subst)
                        .bind(decl.id, declInference.snd.generalize(newEnv));
                decl.expression.type = newEnv.bindingOf(decl.id).type;
                decl.checkType();
            }
            Utils.Pair<Substitution, Type> exprInference = expression.infer(newEnv);
            subst = subst.compose(exprInference.fst);
            type = exprInference.snd.applySubstitution(subst);
            return new Utils.Pair<>(subst, type);
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

        @Override
        public Utils.Pair<Substitution, Type> infer(Environment env) throws TypeException {
            Utils.Pair<Substitution, Type> conditionInference = condition.infer(env);
            Environment newEnv = env.applySubstitution(conditionInference.fst);
            Utils.Pair<Substitution, Type> thenInference = thenBranch.infer(newEnv);
            Utils.Pair<Substitution, Type> elseInference =
                    elseBranch.infer(newEnv.applySubstitution(thenInference.fst));
            try {
                Substitution conditionSubstitution = conditionInference.snd.unify(BOOLEAN_TYPE);
                Substitution thenElseSubstitution = thenInference.snd
                        .applySubstitution(elseInference.fst)
                        .unify(elseInference.snd);
                type = thenInference.snd.applySubstitution(thenElseSubstitution);
                return new Utils.Pair<>(conditionInference.fst
                        .compose(thenInference.fst)
                        .compose(elseInference.fst)
                        .compose(conditionSubstitution)
                        .compose(thenElseSubstitution),
                        type);
            } catch (TypeException e) {
                throw new TypeException(inputPosition, e.getMessage());
            }
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
