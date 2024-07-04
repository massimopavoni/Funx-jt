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
        version = Properties.VERSION,
        description = Properties.DESCRIPTION,
        mixinStandardHelpOptions = true,
        subcommands = {CLI.Transpiler.class, CLI.Runner.class})
public class CLI {
    /**
     * Default constructor.
     */
    CLI() {
        // empty constructor
    }

    /**
     * Main method for executing the CLI in one line.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.exit(new CommandLine(new CLI())
                .setExecutionExceptionHandler(new ExceptionHandler())
                .execute(args));
    }

    /**
     * Transpiler subcommand for the CLI.
     */
    @CommandLine.Command(
            name = "t",
            description = "Transpile a funx program")
    static class Transpiler implements Callable<Integer> {
        /**
         * Help option mixin instance.
         */
        @CommandLine.Mixin
        private HelpOptionMixin helpMixin;
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
         * AST inference annotations flag.
         */
        @CommandLine.Option(
                names = {"-I", "--no-inference"},
                description = "Omit AST type inference annotations",
                defaultValue = "true")
        private boolean astInferenceAnnotations;
        /**
         * Fancy inference types flag.
         */
        @CommandLine.Option(
                names = {"-F", "--fancy-types"},
                description = "Don't use fancy types for inference annotations",
                defaultValue = "true")
        private boolean fancyTypes;
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
        Transpiler() {
            // empty constructor
        }

        /**
         * Callable method for the transpiler subcommand.
         *
         * @return exit code
         * @throws Exception if any error occurs
         */
        @Override
        public Integer call() throws Exception {
            // figure out the working directory
            Path filePath = input.toPath().toAbsolutePath();
            Path workingDir = Path.of(System.getProperty("user.dir"));
            if (outputDir != null) {
                if (!outputDir.isDirectory())
                    throw new CLIException("Output path must be a directory");
                workingDir = outputDir.toPath();
            }
            // figure out the file name
            String fileName = input.getName().split("\\.")[0];
            fileName = Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1);
            // parse input
            ParseTree rawParseTree = getParseTree(filePath.toString());
            // build AST
            ASTNode astRoot = getAST(fileName, rawParseTree);
            if (!(astRoot instanceof ASTNode.Module module)) // this should never fail
                throw new IllegalASTStateException("root node does not identify a module");
            if (!fileName.equals(module.name))
                throw new IllegalASTStateException("file name does not match module name");
            // perform type inference
            InferenceEngine.inferModuleTypes(module);
            if (InferenceEngine.getErrorsCount() > 0)
                throw new InferenceException("Type inference errors found");
            // resolve actual working directory from module package name
            workingDir = workingDir.resolve(Path.of(
                    module.packageName.toLowerCase()
                            .replace('.', File.separatorChar)));
            if (java)
                transpile(module, workingDir);
            if (parseTree)
                outputParseTree(rawParseTree, workingDir.resolve(String.format("%s_parse_tree.png", module.name)));
            if (ast)
                outputAST(module, workingDir.resolve(String.format("%s_ast.dot", module.name)));
            return 0;
        }

        /**
         * Get the raw parse tree using the ANTLR generated parser.
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
                // crash if the grammar is ANTLR ambiguous (not actually LL(k), because it can have direct left recursion)
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
         * @param fileName  input file name
         * @param parseTree parse tree
         * @return abstract syntax tree root node
         */
        private ASTNode getAST(String fileName, ParseTree parseTree) {
            return new ASTBuilder(fileName).visit(parseTree);
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
            // unfortunately ANTLR does not provide a way to directly get an image,
            // so we draw the tree on a custom viewer and then save the image, thanks to awt
            TreeViewer viewer = new TreeViewer(Arrays.asList(FunxParser.ruleNames), tree);
            BufferedImage image = new BufferedImage(viewer.getPreferredSize().width,
                    viewer.getPreferredSize().height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
            graphics.setPaint(Color.BLACK);
            viewer.paint(graphics);
            // very bad shenanigans because of ImageIO internal workings
            // randomly printing the stack trace even if the exception is caught
            PrintStream originalErr = System.err;
            try (PrintStream err = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // do nothing
                }
            })) {
                // redirect the error stream
                System.setErr(err);
                ImageIO.write(image, "png", outputPath.toFile());
            } catch (IOException e) {
                throw new CLIException("Error writing parse tree image", e);
            } finally {
                // reset the error stream
                System.setErr(originalErr);
            }
        }

        /**
         * Output a DOT and a PNG file for abstract syntax tree visualization.
         *
         * @param module     abstract syntax tree root node
         * @param outputPath output file path
         * @throws CLIException if an error occurs
         */
        private void outputAST(ASTNode.Module module, Path outputPath) throws CLIException {
            // use fancy types for inference annotations
            InferenceEngine.setFancyTypes(astInferenceAnnotations && fancyTypes);
            GraphvizBuilder graphvizBuilder = new GraphvizBuilder(new StringBuilder(), astInferenceAnnotations);
            graphvizBuilder.visit(module);
            InferenceEngine.setFancyTypes(false);
            try {
                // write the dot file but also try and convert it to a png
                Files.write(outputPath, graphvizBuilder.getBuiltGraphviz().getBytes());
                Process process = new ProcessBuilder("dot", "-Tpng", outputPath.toString(), "-o",
                        outputPath.toString().replace(".dot", ".png"))
                        .inheritIO().start();
                int dotExitCode = process.waitFor();
                if (dotExitCode != 0)
                    throw new CLIException(
                            String.format("Graphviz dot command failed with exit code %d", dotExitCode));
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

    /**
     * Run subcommand for the CLI.
     */
    @CommandLine.Command(
            name = "r",
            description = "Run a funx program")
    static class Runner implements Callable<Integer> {
        /**
         * Help option mixin instance.
         */
        @CommandLine.Mixin
        private HelpOptionMixin helpMixin;
        /**
         * Input file parameter.
         */
        @CommandLine.Parameters(
                index = "0",
                arity = "1",
                description = "Input java source file")
        private File input;

        /**
         * Default constructor.
         */
        Runner() {
            // empty constructor
        }

        /**
         * Callable method for the run subcommand.
         *
         * @return exit code
         * @throws Exception if any error occurs
         */
        @Override
        public Integer call() throws Exception {
            try {
                Process process = new ProcessBuilder("java", "-cp",
                        Path.of(Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                                .getParent()
                                .resolve(Properties.PRELUDEJAR).toString(),
                        input.getAbsolutePath())
                        .inheritIO().start();
                int javaExitCode = process.waitFor();
                if (javaExitCode != 0)
                    throw new CLIException(
                            String.format("Java command failed with exit code %d", javaExitCode));
            } catch (IOException e) {
                throw new CLIException("Error executing Java command", e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new CLIException("Error executing Java command", e);
            }
            return 0;
        }
    }

    /**
     * Help option mixin for the CLI subcommands.
     */
    static class HelpOptionMixin {
        /**
         * Help message flag.
         */
        @CommandLine.Option(
                names = {"-h", "--help"},
                description = "Show this help message and exit.",
                usageHelp = true)
        private boolean usageHelp;

        /**
         * Default constructor.
         */
        HelpOptionMixin() {
            // empty constructor
        }
    }
}