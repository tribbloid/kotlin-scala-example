package example

class ScalaGreeter(val name: String) {
  
  def greet(): String = s"Hello from Scala, $name!"
  
  def greetWithMessage(message: String): String = {
    s"$message from Scala to $name"
  }
  
  def calculate(x: Int, y: Int): Int = {
    x * y + 42
  }
}

object ScalaGreeter {
  
  def createDefault(): ScalaGreeter = new ScalaGreeter("World")
  
  def formatList(items: List[String]): String = {
    items.mkString("[", ", ", "]")
  }
}
