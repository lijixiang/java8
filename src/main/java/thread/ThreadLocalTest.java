package thread;

import java.util.Random;

public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + ",has put data " + data);
                    MyThreadLocalScope myThreadLocalScope = MyThreadLocalScope.getThreadInstance();
                    myThreadLocalScope.setName("name"+data);
                    myThreadLocalScope.setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            MyThreadLocalScope myThread = MyThreadLocalScope.getThreadInstance();
            System.out.println(this.getClass().getName() + " from " + Thread.currentThread().getName() + ",get data " + myThread.getName()+",age:"+myThread.getAge());
        }
    }

    static class B {
        public void get() {
            MyThreadLocalScope myThread = MyThreadLocalScope.getThreadInstance();
            System.out.println(this.getClass().getName() + " from " + Thread.currentThread().getName() + ",get data " + myThread.getName()+",age:"+myThread.getAge());
        }
    }
}


class MyThreadLocalScope{

    private static ThreadLocal<MyThreadLocalScope> map = new ThreadLocal<>();
    private MyThreadLocalScope(){
    }
    public static MyThreadLocalScope getThreadInstance(){
        MyThreadLocalScope instance = map.get();
        if(null == instance){
            instance = new MyThreadLocalScope();
            map.set(instance);
        }
        return instance;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
