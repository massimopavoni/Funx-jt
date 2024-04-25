package com.github.massimopavoni.funx.jt.ast;

public abstract class Expression extends Statement {
    public static abstract class Operator extends Statement {
        public abstract String operatorString();
    }
}
