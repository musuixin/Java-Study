package Single;

import java.io.Serializable;

/**
 * 饿汉式 线程安全
 * 对反射和序列号不安全，会产生两个对象
 *
 * @author musuixin
 * @date 2020-02-13 20:42
 */
public class Singleton1 implements Serializable {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    //可以解决序列化不安全问题
    private Object readResovle() {
        return instance;
    }
}