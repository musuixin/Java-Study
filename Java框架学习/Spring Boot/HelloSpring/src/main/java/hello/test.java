package hello;

public class test {
    public static void main(String[] args) {
        System.out.println("applactoion");
        MessgePrint print = new MessgePrint();
        MessgeService service = new MessgeService();
        print.setService(service);
        print.printMessage();
    }
}
