import java.time.LocalDate

// Project details
group = "com.github.massimopavoni.funx.jt"
version = "0.1.0"
description = "A Funx to Java source transpiler."

// Gradle plugins
plugins {
    antlr
    application
    java
    // SonarQube plugin for code quality analysis
    id("org.sonarqube") version "5.+"
}

repositories {
    mavenCentral()
}

// Project dependencies
dependencies {
    antlr("org.antlr:antlr4:4.13.1")
    implementation("org.antlr:antlr4-runtime:4.13.1")
    implementation("info.picocli:picocli:4.7.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

// Project toolchain configuration
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

// ANTLR parser source generation
tasks.generateGrammarSource {
    val packageName = project.group.toString().plus(".parser")
    maxHeapSize = "256m"
    // Use a visitor
    arguments.addAll(listOf("-package", packageName, "-visitor", "-no-listener"))

    doFirst {
        delete("src/main/gen")
    }

    doLast {
        copy {
            from(layout.buildDirectory.dir("generated-src/antlr/main"))
            include("*.java")
            into("src/main/java/".plus(packageName.replace('.', '/')))
        }
        copy {
            from(layout.buildDirectory.dir("generated-src/antlr/main"))
            include("*.tokens")
            into("src/main/gen")
        }
    }

    finalizedBy("cleanGeneratedGrammarSource")
}

// Clean generated ANTLR sources
tasks.register("cleanGeneratedGrammarSource") {
    description = "Clean generated ANTLR sources."
    group = "other"

    doLast {
        delete(layout.buildDirectory.dir("generated-src"))
    }
}

// Project properties from gradle configuration
tasks.register("projectProps") {
    description = "Generate project properties."
    group = JavaBasePlugin.BUILD_NEEDED_TASK_NAME

    doLast {
        val className = "Properties"
        val packageName = project.group.toString() + ".cli"
        val filePath = "src/main/java/${packageName.replace('.', '/')}/$className.java"
        val file = file(filePath)

        val name = rootProject.name
        val version = rootProject.version
        val description = rootProject.description.toString()
        val author = "Massimo Pavoni"
        val yearStart = 2024
        val yearEnd = LocalDate.now().year
        val license = "GNU GPLv3"
        val versionHelp = "$name v$version\\n" +
                "Copyright (C) $yearStart${if (yearEnd != yearStart) "-$yearEnd" else ""}  $author\\n" +
                "Licensed under $license"

        file.writeText(
            """
            package $packageName;
            
            /**
             * Class containing all useful properties used by the cli application.
             */
            public final class $className {
                /**
                 * Project name.
                 */
                public static final String NAME = "$name";
                /**
                 * Project version info.
                 */
                public static final String VERSION = "$versionHelp";
                /**
                 * Project description.
                 */
                public static final String DESCRIPTION = "$description";
                
                /**
                 * Static class constructor, private to prevent instantiation.
                 *
                 * @throws IllegalStateException if an attempt to instantiate the class is made
                 */
                private $className() {
                    throw new IllegalStateException("Static class cannot be instantiated.");
                }
            }
        """.trimIndent()
        )
    }
}

// Project build
tasks.compileJava {
    dependsOn(tasks.generateGrammarSource, "projectProps")

    finalizedBy(tasks.javadoc)
}

// Project documentation
tasks.javadoc {
    setDestinationDir(file("$rootDir/docs/javadoc/${project.name}"))

    options.showFromPrivate()
    (options as StandardJavadocDocletOptions).addStringOption("Xmaxwarns", "1024")

    exclude("**/*Prelude*")

    exclude("**/testexamples/**") // TEMPORARY, until test examples are deleted

    finalizedBy("zipJavadoc")
}

tasks.register<Zip>("zipJavadoc") {
    description = "Zip the javadoc files."
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    dependsOn(tasks.javadoc)

    val javadocDest = tasks.javadoc.get().destinationDir
    from(javadocDest)
    archiveFileName.set("${project.name}-${project.version}-javadoc.zip")
    destinationDirectory.set(file("$rootDir/docs/"))

    // Do not keep javadoc files, just the archive
    doLast {
        delete(javadocDest)
    }
}

// Project tests
tasks.test {
    useJUnitPlatform()
}

// Main class
application {
    mainClass.set("com.github.massimopavoni.funx.jt.cli.CLI")
}

// Local SonarQube configuration
sonar {
    properties {
        property("sonar.projectName", rootProject.name)
        property("sonar.host.url", project.property("sonar.host.url").toString())
        property("sonar.projectKey", project.property("sonar.projectKey").toString())
        property("sonar.token", project.property("sonar.token").toString())
        property("sonar.exclusions", "**/parser/Funx*, **/*Prelude*, **/testexamples/**")
    }
}