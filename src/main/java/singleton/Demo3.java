package singleton;

/**
 * 懒汉式
 * <p>
 * synchronized关键字加在方法内
 * <p>
 * 比Demo2 性能更好一点，锁的颗粒度更小，可以进方法内堵塞
 *
 * @author masaiqi
 * @date 2020/3/14 1:12 下午
 */
public class Demo3 {

    private static Demo3 instance;

    private Demo3() {
    }

    public static Demo3 getInstance() {
        synchronized (Demo3.class) {
            if (instance == null) {
                instance = new Demo3();
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
}
