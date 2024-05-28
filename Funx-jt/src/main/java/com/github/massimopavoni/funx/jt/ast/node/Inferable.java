package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.Environment;
import com.github.massimopavoni.funx.jt.ast.typesystem.Substitution;
import com.github.massimopavoni.funx.jt.ast.typesystem.Type;

public sealed interface Inferable
        permits Expression {
    Utils.Pair<Substitution, Type> infer(Environment env);
}
