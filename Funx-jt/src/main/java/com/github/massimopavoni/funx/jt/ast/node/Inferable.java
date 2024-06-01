package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.Context;
import com.github.massimopavoni.funx.jt.ast.typesystem.Substitution;
import com.github.massimopavoni.funx.jt.ast.typesystem.Type;

/**
 * Interface for defining AST nodes of which the type can be inferred.
 */
public sealed interface Inferable
        permits Expression {
    /**
     * Inference method for the specific node,
     * allowing for proper type checking within the type system.
     *
     * @param ctx current context
     * @return tuple of potential substitution and inferred type
     */
    Utils.Tuple<Substitution, Type> infer(Context ctx);
}
