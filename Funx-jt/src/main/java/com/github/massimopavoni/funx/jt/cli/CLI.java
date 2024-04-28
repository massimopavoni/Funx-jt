package com.github.massimopavoni.funx.jt.cli;

import com.github.massimopavoni.funx.jt.ast.ASTNode;
import com.github.massimopavoni.funx.jt.ast.visitor.GraphvizBuilder;
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
import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Command Line Interface for the Funx transpiler.
 */
@CommandLine.Command(
        name = CLIProperties.NAME,
        mixinStandardHelpOptions = true,
        version = CLIProperties.VERSION,
        description = CLIProperties.DESCRIPTION)
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
     * Main method for executing the CLI in one line.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CLI()).execute(args);
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
        // transpile to Java here
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
     * @throws IOException if an error occurs while reading the file
     */
    private ParseTree getParseTree(String inputPath) throws IOException {
        CharStream input = CharStreams.fromFileName(inputPath);
        FunxParser parser = new FunxParser(new CommonTokenStream(new FunxLexer(input)));
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new DiagnosticErrorListener());
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() > 0)
            // Replace with custom exception (not runtime (?))
            throw new RuntimeException("Syntax errors or ambiguities found");
        return tree;
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
     * Output a PNG image for parse tree visualization.
     *
     * @param tree       parse tree
     * @param outputPath output file path
     * @throws IOException if an error occurs while writing the file
     */
    private void outputParseTree(ParseTree tree, Path outputPath) throws IOException {
        TreeViewer viewer = new TreeViewer(Arrays.asList(FunxParser.ruleNames), tree);
        BufferedImage image = new BufferedImage(viewer.getPreferredSize().width,
                viewer.getPreferredSize().height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setPaint(Color.BLACK);
        viewer.paint(graphics);
        ImageIO.write(image, "png", outputPath.toFile());
    }

    /**
     * Output a DOT and a PNG file for abstract syntax tree visualization.
     *
     * @param astRoot    abstract syntax tree root node
     * @param outputPath output file path
     * @throws IOException          if an error occurs while writing the file
     * @throws InterruptedException if the dot process is interrupted
     */
    private void outputAST(ASTNode astRoot, Path outputPath) throws IOException, InterruptedException {
        GraphvizBuilder graphvizBuilder = new GraphvizBuilder(new StringBuilder());
        graphvizBuilder.visit(astRoot);
        Files.write(outputPath, graphvizBuilder.getBuiltGraphviz().getBytes());
        ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", outputPath.toString(), "-o",
                outputPath.toString().replace(".dot", ".png"));
        Process process = pb.start();
        int dotExitCode = process.waitFor();
        if (dotExitCode != 0)
            // Replace with custom exception (not runtime (?))
            throw new RuntimeException("Graphviz dot command failed");
    }
}