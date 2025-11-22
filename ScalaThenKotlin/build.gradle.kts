plugins {
    kotlin("jvm")
}

BuildMapping.getAll().forEach { scalaThenKotlin(it) }