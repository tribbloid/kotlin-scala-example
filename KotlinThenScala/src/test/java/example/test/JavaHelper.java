package example.test;

import example.test.KtHelper;

public class JavaHelper {
    public static int v = 1;
    public static int v2 = KtHelper.Companion.getV();
    public static int vFromMainJava = example.main.JavaHelper.v;
    public static int vFromMainKotlin = example.main.KtHelper.Companion.getV();
    public static int vFromMainScala = example.main.ScalaHelper.v();
    public static int vFromFixturesJava = example.fixtures.JavaHelper.v;
    public static int vFromFixturesKotlin = example.fixtures.KtHelper.Companion.getV();
    public static int vFromFixturesScala = example.fixtures.ScalaHelper.v();
}
