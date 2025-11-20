import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile

fun jointScala(taskPrefix: String, moduleType: String) {
    val javaTaskName = "${taskPrefix}Java"
    val scalaTaskName = "${taskPrefix}Scala"

    val ss = sourceSets.named(moduleType).get()
    ss.scala.srcDirs(listOf("src/${moduleType}/java"))

    afterEvaluate {
        // cut dependency of scalaCompile to JavaCompile
        tasks.named<ScalaCompile>(scalaTaskName) {
            val javaTarget = ss.java.destinationDirectory

            // Log classpath before manipulation
//            println("====\nOriginal classpath for $scalaTaskName:")
//            classpath.files.forEach { file ->
//                println("  - $file")
//            }

            // Log classpath before manipulation
//            println("\nOriginal output for $scalaTaskName:")
//            ss.output.files.forEach { file ->
//                println("  - $file")
//            }

            classpath = ss.compileClasspath.minus(files(javaTarget))

            // Log classpath after manipulation
//            println("\nModified classpath for $scalaTaskName:")
//            classpath.files.forEach { file ->
//                println("  - $file")
//            }

//            setDependsOn(emptyList<Any>())
        }

        tasks.named<JavaCompile>(javaTaskName) {
            enabled = false
        }

    }
}

fun scalaThenKotlin(taskPrefix: String, srcType: String) {
    jointScala(taskPrefix, srcType)

    val kotlinTaskName = "${taskPrefix}Kotlin"
    val scalaTaskName = "${taskPrefix}Scala"

    afterEvaluate {
        tasks.named<KotlinCompile>(kotlinTaskName) {
            val scalaCompile = tasks.named<ScalaCompile>(scalaTaskName)
            dependsOn(scalaCompile)
            libraries.from(scalaCompile.flatMap { it.destinationDirectory })
        }
    }
}

fun allScalaThenKotlin() {
    scalaThenKotlin("compile", "main")
    scalaThenKotlin("compileTest", "test")

    scalaThenKotlin("compileTestFixtures", "testFixtures")
}

allScalaThenKotlin()