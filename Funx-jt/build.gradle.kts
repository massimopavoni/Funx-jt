plugins {
    java
    antlr
    application
}

group = "com.github.massimopavoni.funx.jt"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.13.1")
    implementation("org.antlr:antlr4-runtime:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.generateGrammarSource {
    val packageName = project.group.toString().plus(".parser")
    maxHeapSize = "256m"
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

tasks.register("cleanGeneratedGrammarSource") {
    doLast {
        delete(layout.buildDirectory.dir("generated-src"))
    }
}

tasks.compileJava {
    dependsOn(tasks.generateGrammarSource)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.github.massimopavoni.funx.jt.Main")
}