package com.github.massimopavoni.funx.jt;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;
import com.github.massimopavoni.funx.jt.parser.FunxParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];

        try {
            // Create a CharStream that reads from the file
            CharStream input = CharStreams.fromFileName(filename);

            // Create a lexer that feeds off of input CharStream
            FunxLexer lexer = new FunxLexer(input);

            // Create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Create a parser that feeds off the tokens buffer
            FunxParser parser = new FunxParser(tokens);

            // Enable ANTLR's profiling mode
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

            // Add a listener to report ambiguities
            parser.addErrorListener(new DiagnosticErrorListener());

            // Begin parsing at rule 'program', the root rule in the Funx grammar
            ParseTree tree = parser.program();

            // Print the parse tree
            System.out.println(tree.toStringTree(parser));

            // Print profiling information
            System.out.println("Ambiguity: " + parser.getNumberOfSyntaxErrors());

            // Show the parse tree in a GUI
            JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // Scale a little
            panel.add(viewer);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}