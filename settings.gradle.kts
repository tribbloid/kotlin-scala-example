plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "kotlin-scala-example"
include(
    ":KotlinThenScala",
//    ":alsoKotlinThenScala",
    ":ScalaThenKotlin"
)
