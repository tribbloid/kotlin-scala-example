# Example: Standalone Scala Gradle Project

This is an independent Gradle project demonstrating Scala compilation with its own Gradle wrapper.

## Structure

- `src/main/scala/` - Scala source files
  - `ScalaGreeter.scala` - Example Scala class and companion object
  - `ScalaDataProcessor.scala` - Example case class and data processing utilities
  - `ScalaMain.scala` - Main application entry point

## Build & Run

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run

# Clean and rebuild
./gradlew clean build
```

## Key Configuration

The `build.gradle.kts` configures:
- Scala plugin for Scala compilation
- Java toolchain (Java 21)
- Scala 2.13.16 dependency
- Source sets to compile both Scala and Java sources with scalac

## About Kotlin + Scala Integration

**Note:** Mixing Kotlin and Scala plugins in the same Gradle module creates circular task dependencies:
- `compileKotlin` depends on `compileJava` (Kotlin plugin default)
- `compileScala` depends on `compileJava` (Scala plugin default)
- This creates: `compileJava` → `compileKotlin` → `compileScala` → `compileJava` (circular!)

**Solutions:**
1. **Separate modules** (recommended): Put Scala in one module, Kotlin in another, with Kotlin module depending on Scala module
2. **Use parent project's approach**: See `buildSrc/src/main/kotlin/ai.acyclic.scala-mixin.gradle.kts` which configures Scala to compile Java sources, eliminating the need for `compileJava`

## Project Independence

This example is a standalone project with:
- Its own `settings.gradle.kts`
- Its own `gradle.properties`
- Its own Gradle wrapper (`gradlew`)
- No dependency on the parent lean4ij project
