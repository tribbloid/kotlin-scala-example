import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile
import java.io.File

fun jointScala(taskPrefix: String, moduleType: String) {
//    val javaTaskName = "${taskPrefix}Java"
    val scalaTaskName = "${taskPrefix}Scala"

    val ss = sourceSets.named(moduleType).get()
    ss.scala.srcDirs(listOf("src/${moduleType}/java", "src/${moduleType}/scala"))
    ss.java.setSrcDirs(emptyList<File>())

    // cut dependency of scalaCompile to JavaCompile
    tasks.named<ScalaCompile>(scalaTaskName) {
        val javaTarget = ss.java.destinationDirectory

        // Log classpath before manipulation
        println("====\nOriginal")
        println("\nclasspath for $scalaTaskName:")
        classpath.forEach { file ->
            println("  - $file")
        }
        println("\nscalaClasspath for $scalaTaskName:")
        scalaClasspath.forEach { file ->
            println("  - $file")
        }

        // Log classpath before manipulation
        println("\nsourceSets output for $moduleType:")
        ss.output.forEach { file ->
            println("  - $file")
        }
        classpath = ss.compileClasspath.minus(files(javaTarget))


        // Log classpath after manipulation
        println("\nModified classpath for $scalaTaskName:")
        classpath.forEach { file ->
            println("  - $file")
        }

//            setDependsOn(emptyList<Any>())
    }
}

fun allJointScala() {
    jointScala("compile", "main")
    jointScala("compileTest", "test")

    jointScala("compileTestFixtures", "testFixtures")
}


//tasks.compileScala {
//
//    // Log classpath before manipulation
//    println("====\nOriginal compileScala:")
//    val k = this
//    k.classpath.forEach { file ->
//        println("  - $file")
//    }
//}

allJointScala()