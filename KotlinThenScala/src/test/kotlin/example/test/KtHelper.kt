package example.test


class KtHelper {
    companion object {
        public var v: Int = 1
        public var v2: Int = JavaHelper.v
        public var vFromMainJava: Int = example.main.JavaHelper.v
        public var vFromMainKotlin: Int = example.main.KtHelper.Companion.v
        public var vFromMainScala: Int = example.main.ScalaHelper.v()
        public var vFromFixturesJava: Int = example.fixtures.JavaHelper.v
        public var vFromFixturesKotlin: Int = example.fixtures.KtHelper.Companion.v
        public var vFromFixturesScala: Int = example.fixtures.ScalaHelper.v()
    }
}