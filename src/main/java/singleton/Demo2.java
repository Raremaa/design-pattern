package singleton;

/**
 * 懒汉式
 * <p>
 * synchronized关键字加在方法上
 * <p>
 * 锁颗粒度比较大，在方法外就堵塞了
 *
 * @author masaiqi
 * @date 2020/3/14 1:12 下午
 */
public class Demo2 {

    private static Demo2 instance;

    private Demo2() {
    }

    public synchronized static Demo2 getInstance() {
            if(instance == null) {
                instance = new Demo2();
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
