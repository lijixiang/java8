package thread;

/**
 * As an example, suppose we have a bounded buffer which supports put and take methods.
 * If a take is attempted on an empty buffer,
 * then the thread will block until an item becomes available;
 * if a put is attempted on a full buffer,
 * then the thread will block until a space becomes available.
 */
public class BoundedBuffer {
        final static Object[] items = new Object[10];
        int putptr, // 放置元素在队列中的索引
                takeptr, // 所取元素在队列中的索引
                count; // count:当前队列中的元素个数

        /**生产者，往队列中放置元素**/
        public synchronized void put(Object x) throws InterruptedException {
            while (count == items.length) {// 队列满了
                System.out.println(Thread.currentThread().getName()+" waiting...");
                wait(); //当前线程等待队列可以再次放置元素
                System.out.println("waiting...end");
            }
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count; //队列元素个数增加
            notifyAll(); // 通知 消费者从队列从取元素
            System.out.println(Thread.currentThread().getName() + " put  "+ x);
        }

        /**消费者，从队列中取元素 **/
        public synchronized Object take() throws InterruptedException {
            while (count == 0) {// 当队列中没有元素
                System.out.println(Thread.currentThread().getName()+" waiting...");
                wait(); //等待队列中有元素再取
            }
            Object x = items[takeptr];
            items[takeptr] = null;
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
//            TimeUnit.MICROSECONDS.sleep(2000); // 为了测试避免元素取太快，让线程休眠一段时间
            notifyAll();
            // 打印取出的数据
            System.out.println(Thread.currentThread().getName() + " take "+ x);
            return x;
        }
        /**显示队列当前元素**/
        public String showItems() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Object o : items) {
                sb.append(o + ",");
            }
            sb.append("]");
            sb.deleteCharAt(sb.lastIndexOf(","));
            return sb.toString();
        }
    }
