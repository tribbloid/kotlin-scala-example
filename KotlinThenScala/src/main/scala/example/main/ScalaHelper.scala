package example.main

class ScalaHelper {

  val v2 = JavaHelper.v
  val v3 = KtHelper.Companion.getV()
}

object ScalaHelper extends ScalaHelper {

  val v = 1
}
