package top.musuixin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
class MyThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i);
        }
    }
}

public class App {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, runnables);
        threadPoolExecutor.execute(new MyThread1());
    }
}
