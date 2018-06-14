package thread;

/**
 * 子线程循环5次，主线程循环10次，接着子线程再循环5次，主线程再循环10次, 总共循环5次
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        final Business business = new Business();

        new Thread(()-> {
            for (int i = 1; i <= 5; i++) {
                business.sub();
            }
        }).start();

        for (int i = 1; i <= 5; i++) {
            business.main();
        }

    }

}

class Business{

    private static boolean isShouldSub = true;
    public synchronized void sub(){
        while(!isShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j=1;j<=5;j++){
            System.out.println("$$$$ sub of "+(j)+",loop of 25");
        }

        isShouldSub = false;
        this.notify();
    }

    public synchronized void main(){
        while(isShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j=1;j<=10;j++){
            System.out.println("####################   main of "+(j)+",loop of 50");
        }
        isShouldSub = true;
        this.notify();
    }
}
