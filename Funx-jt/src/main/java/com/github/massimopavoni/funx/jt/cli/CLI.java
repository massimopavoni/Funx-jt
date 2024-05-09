package com.github.massimopavoni.funx.jt.cli;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.visitor.GraphvizBuilder;
import com.github.massimopavoni.funx.jt.ast.visitor.IllegalASTStateException;
import com.github.massimopavoni.funx.jt.ast.visitor.TypeChecker;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;
import com.github.massimopavoni.funx.jt.parser.FunxParser;
import com.github.massimopavoni.funx.jt.parser.IllegalParserStateException;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Command Line Interface for the Funx transpiler.
 */
@CommandLine.Command(
        name = Properties.NAME,
        mixinStandardHelpOptions = true,
        version = Properties.VERSION,
        description = Properties.DESCRIPTION)
public class CLI implements Callable<Integer> {
    /**
     * Input file parameter.
     */
    @CommandLine.Parameters(
            index = "0",
            arity = "1",
            description = "Input funx source file")
    private File input;
    /**
     * Type check flag.
     */
    @CommandLine.Option(
            names = {"-T", "--no-typecheck"},
            description = "Skip type checking phase",
            defaultValue = "true")
    private boolean typecheck;
    /**
     * Java transpilation flag.
     */
    @CommandLine.Option(
            names = {"-J", "--no-java"},
            description = "Skip Java transpilation",
            defaultValue = "true")
    private boolean java;
    /**
     * Output file parameter.
     */
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "Output file path",
            defaultValue = "")
    private File output;
    /**
     * Parse tree visualization flag.
     */
    @CommandLine.Option(
            names = {"-p", "--parse-tree"},
            description = "Output raw parse tree visualization",
            defaultValue = "false")
    private boolean parseTree;
    /**
     * Abstract syntax tree visualization flag.
     */
    @CommandLine.Option(
            names = {"-a", "--ast"},
            description = "Output abstract syntax tree visualization",
            defaultValue = "false")
    private boolean ast;
    /**
     * Remove .dot file after AST visualization flag.
     */
    @CommandLine.Option(
            names = {"-d", "--no-dot"},
            description = "Remove .dot file after AST visualization",
            defaultValue = "false")
    private boolean noDot;

    /**
     * Default constructor.
     */
    public CLI() {
        // Empty constructor
    }

    /**
     * Main method for executing the CLI in one line.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CLI())
                .setExecutionExceptionHandler(new ExceptionHandler())
                .execute(args);
        System.exit(exitCode);
    }

    /**
     * Callable method for the CLI, managing the transpilation process
     * and additional flags.
     *
     * @return exit code
     * @throws Exception if any error occurs
     */
    @Override
    public Integer call() throws Exception {
        Path filePath = input.toPath().toAbsolutePath();
        Path workingDir = filePath.getParent();
        String filename = input.getName().split("\\.")[0];
        ParseTree tree = getParseTree(filePath.toString());
        ASTNode astRoot = getAST(tree);
        if (typecheck)
            typecheck(astRoot);
        if (java)
            transpile(astRoot, output == null ?
                    workingDir.resolve(String.format("%s.java", filename))
                    : output.toPath().toAbsolutePath());
        if (parseTree)
            outputParseTree(tree, workingDir.resolve(String.format("%s_parse_tree.png", filename)));
        if (ast)
            outputAST(astRoot, workingDir.resolve(String.format("%s_ast.dot", filename)));
        return 0;
    }

    /**
     * Pass the input file content to the ANTLR generated parser.
     *
     * @param inputPath input file path
     * @return parse tree
     * @throws CLIException if an error occurs
     */
    private ParseTree getParseTree(String inputPath) throws CLIException {
        try {
            FunxParser parser = new FunxParser(
                    new CommonTokenStream(
                            new FunxLexer(
                                    CharStreams.fromFileName(inputPath))));
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            parser.addErrorListener(new DiagnosticErrorListener());
            ParseTree tree = parser.module();
            if (parser.getNumberOfSyntaxErrors() > 0)
                throw new IllegalParserStateException("Syntax errors or ambiguities found");
            return tree;
        } catch (IOException e) {
            throw new CLIException("Error reading input file", e);
        }
    }

    /**
     * Build the abstract syntax tree by visiting the parse tree.
     *
     * @param tree parse tree
     * @return abstract syntax tree root node
     */
    private ASTNode getAST(ParseTree tree) {
        return new ASTBuilder().visit(tree);
    }

    /**
     * Type check a created abstract syntax tree.
     *
     * @param astRoot abstract syntax tree root node
     */
    private void typecheck(ASTNode astRoot) {
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(astRoot);
        if (typeChecker.getErrorsCount() > 0)
            throw new IllegalASTStateException(
                    String.format("%d type error%s found",
                            typeChecker.getErrorsCount(),
                            typeChecker.getErrorsCount() == 1 ? "" : "s"));
    }

    /**
     * Transpile the abstract syntax tree to Java code.
     *
     * @param astRoot    abstract syntax tree root node
     * @param outputPath output file path
     * @throws CLIException if an error occurs
     */
    private void transpile(ASTNode astRoot, Path outputPath) throws CLIException {
    }

    /**
     * Output a PNG image for parse tree visualization.
     *
     * @param tree       parse tree
     * @param outputPath output file path
     * @throws CLIException if an error occurs
     */
    private void outputParseTree(ParseTree tree, Path outputPath) throws CLIException {
        TreeViewer viewer = new TreeViewer(Arrays.asList(FunxParser.ruleNames), tree);
        BufferedImage image = new BufferedImage(viewer.getPreferredSize().width,
                viewer.getPreferredSize().height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setPaint(Color.BLACK);
        viewer.paint(graphics);
        PrintStream originalErr = System.err;
        try (PrintStream err = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                // Do nothing
            }
        })) {
            // Very bad shenanigans because of ImageIO internal workings
            // randomly printing the stack trace even if the exception is caught
            // Redirect the error stream
            System.setErr(err);
            ImageIO.write(image, "png", outputPath.toFile());
        } catch (IOException e) {
            throw new CLIException("Error writing parse tree image", e);
        } finally {
            // Reset the error stream
            System.setErr(originalErr);
        }
    }

    /**
     * Output a DOT and a PNG file for abstract syntax tree visualization.
     *
     * @param astRoot    abstract syntax tree root node
     * @param outputPath output file path
     * @throws CLIException if an error occurs
     */
    private void outputAST(ASTNode astRoot, Path outputPath) throws CLIException {
        try {
            GraphvizBuilder graphvizBuilder = new GraphvizBuilder(new StringBuilder());
            graphvizBuilder.visit(astRoot);
            Files.write(outputPath, graphvizBuilder.getBuiltGraphviz().getBytes());
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", outputPath.toString(), "-o",
                    outputPath.toString().replace(".dot", ".png"));
            Process process = pb.start();
            int dotExitCode = process.waitFor();
            if (dotExitCode != 0)
                throw new CLIException(String.format("Graphviz dot command failed with exit code %d", dotExitCode));
            if (noDot)
                Files.deleteIfExists(outputPath);
        } catch (IOException e) {
            throw new CLIException("Error writing AST dot file", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CLIException("Error executing Graphviz dot command", e);
        }
    }
}