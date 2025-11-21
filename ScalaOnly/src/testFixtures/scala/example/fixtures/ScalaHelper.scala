package example.fixtures

object ScalaHelper {

  JavaHelper.v

  val v = 1
  val vFromMainJava: Int = example.main.JavaHelper.v
  val vFromMainScala: Int = example.main.ScalaHelper.v
}
