plugins {
    kotlin("jvm")
}

// Configure compilation order: Java → Kotlin → Scala
// Java must compile first since Kotlin references Java classes
//tasks.named("compileKotlin") {
//    dependsOn("compileJava")
//}
//tasks.named("compileTestKotlin") {
//    dependsOn("compileTestJava")
//}
//tasks.named("compileTestFixturesKotlin") {
//    dependsOn("compileTestFixturesJava")
//}

// Shared configuration for all subprojects

BuildMapping.getAll().forEach { kotlinThenScala(it) }
