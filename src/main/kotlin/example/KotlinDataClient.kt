package example

data class KotlinPerson(val name: String, val age: Int) {
    val isAdult: Boolean get() = age >= 18
    val description: String get() = "$name is $age years old"
}

class KotlinDataClient {

    fun demonstratePersonUsage() {
        val alice = KotlinPerson("Alice", 25)
        val bob = KotlinPerson("Bob", 16)
        
        println("=== Kotlin data class ===")
        println("${alice.name} is ${if (alice.isAdult) "an adult" else "not an adult"}")
        println(alice.description)
        println("${bob.name} is ${if (bob.isAdult) "an adult" else "not an adult"}")
        println(bob.description)
        println("Age sum (via Java): ${JavaHelper.calculateSum(alice.age, bob.age)}")
    }
    
    fun demonstrateDataProcessor() {
        val people = listOf(
            KotlinPerson("Alice", 25),
            KotlinPerson("Bob", 16),
            KotlinPerson("Charlie", 30),
            KotlinPerson("Diana", 17)
        )
        
        println("\n=== Kotlin using DataProcessor ===")
        
        val nameAgeMap = people.associate { it.name to it.age }
        println("Name-Age Map:")
        nameAgeMap.forEach { (name, age) ->
            println("  $name -> $age")
        }
        
        val adults = people.filter { it.isAdult }
        println("\nAdults only:")
        adults.forEach { person ->
            println("  ${person.description}")
        }
        
        val avgAge = if (people.isEmpty()) 0.0 else people.map { it.age }.average()
        println("\nAverage age: $avgAge")
    }
    
    fun createAndProcessPeople(): List<String> {
        val people = listOf(
            KotlinPerson("Emma", 28),
            KotlinPerson("Frank", 35),
            KotlinPerson("Grace", 22)
        )
        
        return people.map { person ->
            "${person.name} (${person.age}) - ${if (person.isAdult) "Adult" else "Minor"}"
        }
    }
}

fun main() {
    val client = KotlinDataClient()
    client.demonstratePersonUsage()
    client.demonstrateDataProcessor()
    
    println("\n=== Kotlin processing data ===")
    client.createAndProcessPeople().forEach { println(it) }
}
