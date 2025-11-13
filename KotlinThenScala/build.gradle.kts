import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


// Shared configuration for all subprojects
allprojects {
    // Configure Scala compilation
    fun kotlinThenScala(
        taskPrefix: String
    ) {
        val kotlinTaskName = "${taskPrefix}Kotlin"
        val javaTaskName = "${taskPrefix}Java"
        val scalaTaskName = "${taskPrefix}Scala"

        tasks {

            named<ScalaCompile>(scalaTaskName) {
                val kotlinCompile = named<KotlinCompile>(kotlinTaskName)
                val javaCompile = named<JavaCompile>(javaTaskName)

                dependsOn(kotlinCompile)

                classpath = classpath +
                        files(kotlinCompile.get().destinationDirectory) +
                        files(javaCompile.get().destinationDirectory)

            }
        }
    }

    fun allKotlinThenScala() {
        // Configure all Scala compilation tasks
        kotlinThenScala("compile")
        kotlinThenScala("compileTest")
        kotlinThenScala("compileTestFixtures")
    }

    allKotlinThenScala()
}