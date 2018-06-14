package thread.time;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date()+" ##:bombing...");
            }
        },10000,3000);
//        while (true){
//            System.out.println(new Date());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
