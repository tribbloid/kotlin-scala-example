package example.test


object ScalaHelper {

  JavaHelper.v
  KtHelper.Companion.getV()

  val v = 1
  val vFromMainJava: Int = example.main.JavaHelper.v
  val vFromMainKotlin: Int = example.main.KtHelper.Companion.getV()
  val vFromMainScala: Int = example.main.ScalaHelper.v
  val vFromFixturesJava: Int = example.fixtures.JavaHelper.v
  val vFromFixturesKotlin: Int = example.fixtures.KtHelper.Companion.getV()
  val vFromFixturesScala: Int = example.fixtures.ScalaHelper.v
}
