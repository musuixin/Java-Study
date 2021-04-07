package top.musuixin;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CurrencyApiImpl api = new CurrencyApiImpl();
        CurrencyApi.talk();
        api.say();
        System.out.println("Hello World!");
    }
}
