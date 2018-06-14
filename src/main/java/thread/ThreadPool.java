package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i=0;i<=10;i++)
        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" loop of "+i);
                }
            }
        });
    pool.shutdownNow();
    }
}
