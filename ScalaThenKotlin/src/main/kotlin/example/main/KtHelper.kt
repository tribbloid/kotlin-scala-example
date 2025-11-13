package example.main

class KtHelper {
    companion object {

        public fun v(): Int {
            return 1
        }

        var v2: Int = JavaHelper.v
        var v3: Int = ScalaHelper.v()
    }
}