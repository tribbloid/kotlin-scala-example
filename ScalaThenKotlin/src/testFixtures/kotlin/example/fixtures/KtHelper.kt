package example.fixtures


class KtHelper {
    companion object {

        public fun v(): Int {
            return 1
        }

        var v2: Int = JavaHelper.v
        var v3: Int = ScalaHelper.v()
        var vFromMainJava: Int = example.main.JavaHelper.v
        var vFromMainKotlin: Int = example.main.KtHelper.Companion.v()
        var vFromMainScala: Int = example.main.ScalaHelper.v()
    }
}