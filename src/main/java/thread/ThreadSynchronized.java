package thread;

import java.util.Date;

public class ThreadSynchronized {

    public synchronized void synMethod1(){
        for(int i=0;i<50;i++){
            System.out.println("$$$ ynMethod1 $$$ 第"+i+"次");
        }
    }

    public void synMethod2(){


            for (int i=0;i<50;i++){
                if(i==10){
                    try {
                        System.out.println("开始第10次"+new Date());
                        Thread.currentThread().sleep(10000);
                        synchronized (this){
                            System.out.println("############### synMethod2 第"+i+"次");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第10次结束"+new Date());
                }
                    System.out.println("############### synMethod2 第"+i+"次");
            }
    }

    public static void main(String[] args) {
        ThreadSynchronized ts = new ThreadSynchronized();
        new Thread(ts::synMethod2).start();
        new Thread(()->{ts.synMethod1();}).start();
    }
}
