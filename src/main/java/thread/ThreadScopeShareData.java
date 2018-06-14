package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {

//        private static int data = 0;
    private static Map<Thread, Integer> threadMap = new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + ",has put data " + data);
                    threadMap.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    static class A {
        public void get() {
            int data = threadMap.get(Thread.currentThread());
            System.out.println(this.getClass().getName() + " from " + Thread.currentThread().getName() + ",get data " + data);
        }
    }

    static class B {
        public void get() {
            int data = threadMap.get(Thread.currentThread());
            System.out.println(this.getClass().getName() + " from " + Thread.currentThread().getName() + ",get data " + data);
        }
    }
}