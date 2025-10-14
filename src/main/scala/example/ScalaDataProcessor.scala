package example

case class Person(name: String, age: Int) {
  def isAdult: Boolean = age >= 18
  
  def description: String = s"$name is $age years old"
}

object DataProcessor {
  
  def processPeople(people: Seq[Person]): Map[String, Int] = {
    people.map(p => p.name -> p.age).toMap
  }
  
  def filterAdults(people: Seq[Person]): Seq[Person] = {
    people.filter(_.isAdult)
  }
  
  def averageAge(people: Seq[Person]): Double = {
    if (people.isEmpty) 0.0
    else people.map(_.age).sum.toDouble / people.size
  }
}
