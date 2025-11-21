package example.test

object ScalaHelper {

  JavaHelper.v

  val v = 1
  val vFromMainJava: Int = example.main.JavaHelper.v
  val vFromMainScala: Int = example.main.ScalaHelper.v
  val vFromFixturesJava: Int = example.fixtures.JavaHelper.v
  val vFromFixturesScala: Int = example.fixtures.ScalaHelper.v
}
