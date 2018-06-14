package thread;

public class BoundedBufferTest {

    private static BoundedBuffer bb = new BoundedBuffer();

    public static void main(String[] args) {
        // 启动20个“写线程”，向BoundedBuffer中不断的写数据(写入0-19)；
        // 启动20个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i=0; i<20; i++) {
            new PutThread("thread-put"+i, i).start();
            new TakeThread("thread-take").start();
        }

    }
    static class PutThread extends Thread {
        private int num;
        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }
        public void run() {
            try {
                Thread.sleep(1);    // 线程休眠1ms
                bb.put(num);        // 向BoundedBuffer中写入数据
                System.out.println("### put " + num + " into " + bb.showItems());
            } catch (InterruptedException e) {
            }
        }
    }

    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }
        public void run() {
            try {
                Thread.sleep(10);                    // 线程休眠1ms
                System.out.println("$$$ take " + bb.take() + " from " + bb.showItems());
            } catch (InterruptedException e) {
            }
        }
    }
}
