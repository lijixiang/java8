//package thread;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class BoundedBuffer2 {
//
//
//    public static void main(String[] args) {
//        OperatBuffer ob = new OperatBuffer();
//        new Thread(()->{
//            for (int i=0;i<20;i++)
//                try {
//                    ob.put(i);
//                    System.out.println("### put "+i+" into "+ob.showItems());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        }).start();
//
//        new Thread(()->{
//           while (ob.items.length>0){
//               try {
//                   System.out.println("$$$ take "+ob.take() +" from "+ob.showItems());
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           }
//        }).start();
//    }
//
//
//    static class OperatBuffer{
//        final Lock lock = new ReentrantLock();
//        final Condition notFull  = lock.newCondition();
//        final Condition notEmpty = lock.newCondition();
//
//        volatile Object[] items = new Object[10];
//        int putptr, takeptr, count;
//
//        public void put(Object x) throws InterruptedException {
//            lock.lock();
//            try {
//                while (count == items.length)
//                    notFull.await();
//                items[putptr] = x;
//                if (++putptr == items.length) putptr = 0;
//                ++count;
//                notEmpty.signal();
//            } finally {
//                lock.unlock();
//            }
//        }
//
//        public Object take() throws InterruptedException {
//            lock.lock();
//            try {
//                while (count == 0)
//                    notEmpty.await();
//                Object x = items[takeptr];
//                items[takeptr] = null;
//                if (++takeptr == items.length) takeptr = 0;
//                --count;
//                TimeUnit.MICROSECONDS.sleep(1000);
//                notFull.signal();
//                return x;
//            } finally {
//                lock.unlock();
//            }
//        }
//
//        public String showItems(){
//            StringBuilder sb = new StringBuilder();
//            sb.append("[");
//            for(Object o:items){
//                sb.append(o+",");
//            }
//            sb.append("]");
////            if(sb.length()==0)sb.append(",");
//            sb.deleteCharAt(sb.lastIndexOf(","));
//            return sb.toString();
//        }
//    }
//
//
//
// }