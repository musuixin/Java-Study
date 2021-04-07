package top.musuixin;

/**
 * @author musuixin
 * @date 2020-10-16 00:33
 */
public interface CurrencyApi {



    static void talk() {
        System.err.println("world");
    }

    default void say() {
        System.err.println("hello");
    }

}
