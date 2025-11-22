plugins {
    kotlin("jvm")
}

BuildMapping.getAll().forEach { kotlinThenScala(it) }
