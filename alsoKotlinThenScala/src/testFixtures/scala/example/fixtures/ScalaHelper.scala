package example.fixtures


object ScalaHelper {

  JavaHelper.v
  KtHelper.Companion.getV()

  val v = 1
  val vFromMainJava: Int = example.main.JavaHelper.v
  val vFromMainKotlin: Int = example.main.KtHelper.Companion.getV()
  val vFromMainScala: Int = example.main.ScalaHelper.v
}
