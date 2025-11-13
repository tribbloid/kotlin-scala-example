package example.test


object ScalaHelper {
  val v: Int = 1

  val v2: Int = JavaHelper.v
  val vFromMainJava: Int = example.main.JavaHelper.v
  val vFromMainKotlin: Int = example.main.KtHelper.Companion.v()
  val vFromMainScala: Int = example.main.ScalaHelper.v
  val vFromFixturesJava: Int = example.fixtures.JavaHelper.v
  val vFromFixturesKotlin: Int = example.fixtures.KtHelper.Companion.v()
  val vFromFixturesScala: Int = example.fixtures.ScalaHelper.v
}
