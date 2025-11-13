import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


// Shared configuration for all subprojects
allprojects {

    // Configure Scala compilation
    fun kotlinThenScala(
        taskPrefix: String,
        sourceSetName: String
    ) {
        val kotlinTaskName = if (sourceSetName == "main") "compileKotlin" else "${taskPrefix}Kotlin"
        val javaTaskName = if (sourceSetName == "main") "compileJava" else "${taskPrefix}Java"


        tasks.named<ScalaCompile>("${taskPrefix}Scala") {
            val kotlinCompile = tasks.named<KotlinCompile>(kotlinTaskName)
            val javaCompile = tasks.named<JavaCompile>(javaTaskName)

            dependsOn(kotlinCompile, javaCompile)
        }

        sourceSets {

            named(sourceSetName) {
                scala.srcDirs("src/${sourceSetName}/java", "src/${sourceSetName}/kotlin")
            }
        }
    }

    fun allKotlinThenScala() {
        // Configure all Scala compilation tasks
        kotlinThenScala("compile", "main")
        kotlinThenScala("compileTest", "test")
        kotlinThenScala("compileTestFixtures", "testFixtures")
    }

    allKotlinThenScala()
}