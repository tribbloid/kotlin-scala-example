package example

object ScalaMain {
  def main(args: Array[String]): Unit = {
    println("=== Scala + Kotlin Example ===\n")
    
    println("--- Scala Classes ---")
    val greeter = new ScalaGreeter("World")
    println(greeter.greet())
    println(greeter.greetWithMessage("Hello"))
    println(s"Calculation: ${greeter.calculate(5, 10)}")
    
    println("\n--- Scala Case Classes ---")
    val person = Person("Alice", 25)
    println(person.description)
    println(s"Is adult: ${person.isAdult}")
    
    println("\n--- Scala Collections ---")
    val people = Seq(
      Person("Alice", 25),
      Person("Bob", 17),
      Person("Charlie", 30)
    )
    val adults = DataProcessor.filterAdults(people)
    println(s"Adults: ${adults.map(_.name).mkString(", ")}")
    println(s"Average age: ${DataProcessor.averageAge(people)}")
  }
}
