plugins {
    scala
    kotlin("jvm") version "1.9.24"
    application
    id("com.dorongold.task-tree") version "2.1.1"
    `java-test-fixtures`
}

val scalaVersion = "2.13.17"

// Common repositories configuration
allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}


allprojects {

    apply(plugin = "scala")

    // Configure common dependencies
    dependencies {
        implementation("org.scala-lang:scala-library:$scalaVersion")
        implementation(kotlin("stdlib"))
    }
}

// Shared configuration for all subprojects
subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java-test-fixtures")


    // Configure Java toolchain
    configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of("17"))
        }
    }
}
