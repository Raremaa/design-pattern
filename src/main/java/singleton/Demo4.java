package singleton;

/**
 * 懒汉式
 * <p>
 * Double-Check的模式
 * <p>
 * 比Demo2 性能更好，进一步缩小锁的颗粒度
 *
 * @author masaiqi
 * @date 2020/3/14 1:12 下午
 */
public class Demo4 {

    /**
     * 这里用 volatile 阻止指令重排序
     */
    private static volatile Demo4 instance;

    /**
     * 之所以检查两次是为了防止同时进入第一个if里面造成实例化两次，避免不必要的内存开销
     */
    public static Demo4 getInstance() {
        if (instance == null) {
            synchronized (Demo4.class) {
                if (instance == null) {
                    instance = new Demo4();
                }
            }
        }
        return instance;
    }

    public static String doOtherJob() {
        return "其他方法";
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.err.println(getInstance());
        });
        Thread thread2 = new Thread(() -> {
            System.err.println(getInstance());
        });
        Thread thread3 = new Thread(() -> {
            System.err.println(doOtherJob());
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 防止序列化破坏单例
     */
    private Object readResolve() {
        return instance;
    }
}
