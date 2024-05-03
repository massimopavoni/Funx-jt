package com.github.massimopavoni.funx.jt.cli;

import com.github.massimopavoni.funx.jt.ast.ASTNode;
import com.github.massimopavoni.funx.jt.ast.visitor.GraphvizBuilder;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;
import com.github.massimopavoni.funx.jt.parser.FunxParser;
import com.github.massimopavoni.funx.jt.parser.IllegalParserStateException;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
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
    private File file;

    /**
     * Parse tree visualization flag.
     */
    @CommandLine.Option(
            names = {"-p", "--parse-tree"},
            description = "Output the raw parse tree visualization",
            defaultValue = "false")
    private boolean parseTree;

    /**
     * Abstract syntax tree visualization flag.
     */
    @CommandLine.Option(
            names = {"-a", "--ast"},
            description = "Output the abstract syntax tree visualization",
            defaultValue = "false")
    private boolean ast;

    /**
     * Default constructor.
     */
    public CLI() {
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
        Path filePath = file.toPath().toAbsolutePath();
        Path workingDir = filePath.getParent();
        String filename = file.getName().split("\\.")[0];
        ParseTree tree = getParseTree(filePath.toString());
        ASTNode astRoot = getAST(tree);
        transpile(astRoot, workingDir.resolve(String.format("%s.java", filename)));
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
            CharStream input = CharStreams.fromFileName(inputPath);
            FunxParser parser = new FunxParser(new CommonTokenStream(new FunxLexer(input)));
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

    private void transpile(ASTNode astRoot, Path outputPath) throws CLIException {
//        if (javaBuilder.getNumberOfSemanticErrors() > 0)
//            throw new IllegalTranspilerStateException("Semantic errors found");
// some checks for the java builder
//        if (!ctx.functionType().id.getText()
//                .equals(ctx.id.getText()))
//            errorReporter.reportError(ctx.functionType(), "same identifier for type and function");
//
//        if (left instanceof Primary.Literal)
//            errorReporter.reportError(ctx, "non-literal function application");
    }

    /**
     * Output a PNG image for parse tree visualization.
     *
     * @param tree       parse tree
     * @param outputPath output file path
     * @throws CLIException if an error occurs
     */
    private void outputParseTree(ParseTree tree, Path outputPath) throws CLIException {
        PrintStream originalErr = System.err;
        try {
            TreeViewer viewer = new TreeViewer(Arrays.asList(FunxParser.ruleNames), tree);
            BufferedImage image = new BufferedImage(viewer.getPreferredSize().width,
                    viewer.getPreferredSize().height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
            graphics.setPaint(Color.BLACK);
            viewer.paint(graphics);
            // Very bad shenanigans because of ImageIO internal workings
            // randomly printing the stack trace even if the exception is caught
            // Redirect the error stream
            System.setErr(new PrintStream(new OutputStream() {
                public void write(int b) {
                    // Do nothing
                }
            }));
            ImageIO.write(image, "png", outputPath.toFile());
            // Reset the error stream
            System.setErr(originalErr);
        } catch (IOException e) {
            System.setErr(originalErr);
            throw new CLIException("Error writing parse tree image", e);
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
            graphvizBuilder.visitNode(astRoot);
            Files.write(outputPath, graphvizBuilder.getBuiltGraphviz().getBytes());
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", outputPath.toString(), "-o",
                    outputPath.toString().replace(".dot", ".png"));
            Process process = pb.start();
            int dotExitCode = process.waitFor();
            if (dotExitCode != 0)
                throw new CLIException(String.format("Graphviz dot command failed with exit code %d", dotExitCode));
        } catch (IOException e) {
            throw new CLIException("Error writing AST dot file", e);
        } catch (InterruptedException e) {
            throw new CLIException("Error executing Graphviz dot command", e);
        }
    }
}