plugins {
    scala
    kotlin("jvm") version "1.9.20"
    application
}

repositories {
    mavenCentral()
}

val scalaVersion = property("scalaVersion").toString()

application {
    mainClass.set("example.ScalaMain")
}

dependencies {
    implementation("org.scala-lang:scala-library:$scalaVersion")
    implementation(kotlin("stdlib"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(property("javaVersion").toString()))
    }
}

sourceSets {
    main {
//        scala {
//            setSrcDirs(listOf("src/main/scala"))
//        }
        java {
            setSrcDirs(listOf<String>())
        }
        kotlin {
            setSrcDirs(listOf("src/main/kotlin"))
        }
    }
}

//tasks.named<JavaCompile>("compileJava") {
//    enabled = false
//}
