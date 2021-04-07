package Single;

/**
 * 线程不安全的懒汉式
 * @author musuixin
 * @date 2020-02-13 22:01
 */
public class Singleton4 {

    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
