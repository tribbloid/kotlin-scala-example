package example.main

class ScalaHelper {

  val v2 = JavaHelper.v
}

object ScalaHelper extends ScalaHelper {

  val v = 1
}
