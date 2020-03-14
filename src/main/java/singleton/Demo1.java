package singleton;

/**
 * 饿汉式模式
 *
 * @author masaiqi
 * @date 2020/3/14 1:10 下午
 */
public class Demo1 {

    private static Demo1 instance = new Demo1();

    private Demo1() {
    }

    public static Demo1 getInstance() {
        return instance;
    }
}
