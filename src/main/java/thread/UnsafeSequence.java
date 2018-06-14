package thread;

public class UnsafeSequence implements Runnable{
    private int value;
    /** 返回一个唯一的数值 **/
    public synchronized int getNext(){

        return value++;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" status is "+Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new UnsafeSequence());
        thread.start();
//        Thread.currentThread().wait();

//        thread.notify();
    }
}

