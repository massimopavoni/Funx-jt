package com.github.massimopavoni.funx.jt.cli;

/**
 * Class containing all useful properties used by the cli application.
 */
public final class Properties {
    /**
     * Project name.
     */
    public static final String NAME = "Funx-jt";
    /**
     * Project version info.
     */
    public static final String VERSION = "Funx-jt v0.1.0\nCopyright (C) 2024  Massimo Pavoni\nLicensed under GNU GPLv3";
    /**
     * Project description.
     */
    public static final String DESCRIPTION = "A Funx to Java source transpiler.";
    
    /**
     * Static class constructor, private to prevent instantiation.
     *
     * @throws IllegalStateException if an attempt to instantiate the class is made
     */
    private Properties() {
        throw new IllegalStateException("Static class cannot be instantiated.");
    }
}