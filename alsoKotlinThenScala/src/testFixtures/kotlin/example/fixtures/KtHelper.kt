package example.fixtures


class KtHelper {
    companion object {
        public var v: Int = 1
        public var v2: Int = JavaHelper.v
        public var vFromMainJava: Int = example.main.JavaHelper.v
        public var vFromMainKotlin: Int = example.main.KtHelper.Companion.v
        public var vFromMainScala: Int = example.main.ScalaHelper.v()
    }
}