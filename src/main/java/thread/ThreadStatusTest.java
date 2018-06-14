package thread;

import java.util.concurrent.locks.Condition;

public class ThreadStatusTest {

    Thread putThread = new Thread();
    final Object[] items = new Object[100];
    int putptr, takeptr, count;
    public void put(Object o){
        synchronized (this){
            while (count == items.length){

            }
        }
    }

}
