package com.github.massimopavoni.funx.jt.cli;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.typesystem.InferenceEngine;
import com.github.massimopavoni.funx.jt.ast.typesystem.InferenceException;
import com.github.massimopavoni.funx.jt.ast.visitor.GraphvizBuilder;
import com.github.massimopavoni.funx.jt.ast.visitor.IllegalASTStateException;
import com.github.massimopavoni.funx.jt.ast.visitor.JavaBuilder;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;
import com.github.massimopavoni.funx.jt.parser.FunxParser;
import com.github.massimopavoni.funx.jt.parser.IllegalParserStateException;
import com.google.googlejavaformat.java.FormatterException;
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
     * Java transpilation flag.
     */
    @CommandLine.Option(
            names = {"-J", "--no-java"},
            description = "Skip Java transpilation",
            defaultValue = "true")
    private boolean java;
    /**
     * Output directory parameter.
     */
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "Output directory")
    private File outputDir;
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
            names = {"-d", "--dot"},
            description = "Keep .dot file after AST visualization",
            defaultValue = "true")
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
        Path workingDir = Path.of(System.getProperty("user.dir"));
        if (outputDir != null) {
            if (!outputDir.isDirectory())
                throw new CLIException("Output path must be a directory");
            workingDir = outputDir.toPath();
        }
        String fileName = input.getName().split("\\.")[0];
        fileName = Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1);
        ParseTree tree = getParseTree(filePath.toString());
        ASTNode astRoot = getAST(fileName, tree);
        // This should never fail
        if (!(astRoot instanceof ASTNode.Module module))
            throw new IllegalASTStateException("root node does not identify a module");
        if (!fileName.equals(module.name))
            throw new IllegalASTStateException("file name does not match module name");
        workingDir = workingDir.resolve(Path.of(
                module.packageName.toLowerCase()
                        .replace('.', File.separatorChar)));
        InferenceEngine.inferModuleTypes(module);
        if (InferenceEngine.getErrorsCount() > 0)
            throw new InferenceException("Type inference errors found");
        if (java)
            transpile(module, workingDir);
        if (parseTree)
            outputParseTree(tree, workingDir.resolve(String.format("%s_parse_tree.png", module.name)));
        if (ast)
            outputAST(astRoot, workingDir.resolve(String.format("%s_ast.dot", module.name)));
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
     * @param fileName input file name
     * @param tree     parse tree
     * @return abstract syntax tree root node
     */
    private ASTNode getAST(String fileName, ParseTree tree) {
        return new ASTBuilder(fileName).visit(tree);
    }

    /**
     * Transpile the abstract syntax tree to Java code.
     *
     * @param module        abstract syntax tree root node
     * @param outputDirPath output dir path
     * @throws CLIException if an error occurs
     */
    private void transpile(ASTNode.Module module, Path outputDirPath) throws CLIException {
        JavaBuilder javaBuilder = new JavaBuilder(new StringBuilder());
        javaBuilder.visit(module);
        try {
            Files.createDirectories(outputDirPath);
            Files.write(
                    outputDirPath.resolve(String.format("%s.java", module.name)),
                    javaBuilder.getBuiltJava().getBytes());
        } catch (FormatterException e) {
            throw new CLIException("Error formatting Java code", e);
        } catch (IOException e) {
            throw new CLIException("Error writing Java file", e);
        }
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
        GraphvizBuilder graphvizBuilder = new GraphvizBuilder(new StringBuilder());
        graphvizBuilder.visit(astRoot);
        try {
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