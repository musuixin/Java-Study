package top.musuixin;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread1 {
    public volatile static Integer i=1000;
    private static Object lock = new Object();
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(9999, 100000, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int j = 1; j <=1; j++) {
            threadPoolExecutor.execute(() -> {
                while (true) {
                    synchronized (i){
                        if (i > 0) {
                            try {
                                Thread.sleep(10L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + ":正在卖票：" + i);
                            i--;
                        } else {
                            return;
                        }
                    }
                }
            });
        }
    }
}
