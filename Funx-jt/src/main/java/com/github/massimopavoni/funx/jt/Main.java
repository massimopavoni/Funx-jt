package com.github.massimopavoni.funx.jt;

import com.github.massimopavoni.funx.jt.ast.ASTNode;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;
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
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];

        try {
            CharStream input = CharStreams.fromFileName(filename);
            FunxParser parser = new FunxParser(new CommonTokenStream(new FunxLexer(input)));
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            parser.addErrorListener(new DiagnosticErrorListener());

            ParseTree tree = parser.program();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Syntax errors found. Exiting.");
                return;
            }

            ASTBuilder astBuilder = new ASTBuilder();
            ASTNode ast = astBuilder.visit(tree);

            System.out.println(tree.toStringTree(parser));

            JFrame frame = new JFrame("ANTLR CST");
            JPanel panel = new JPanel();
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // Scale a little
            panel.add(viewer);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}