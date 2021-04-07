package Single;

/**
 * 线程不安全的懒汉式
 *
 * @author musuixin
 * @date 2020-02-13 22:01
 */
public class Singleton5 {

    private static Singleton5 instance = null;

    private Singleton5() {
    }

    //方法加上同步锁
    public synchronized static Singleton5 getInstance() {
        if (instance == null) {
            instance = new Singleton5();
        }
        return instance;
    }
}
