package example.fixtures;

public class JavaHelper {
    public static int v = 1;
    public static int v2 = ScalaHelper.v();
    public static int vFromMainJava = example.main.JavaHelper.v;
    public static int vFromMainKotlin = example.main.KtHelper.Companion.v();
    public static int vFromMainScala = example.main.ScalaHelper.v();
}
