package defaultmethod;

public class MyClass extends MyInterface1Impl implements MyInterface2{
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

//    @Override
//    public void myMethod() {
//        System.out.println("MyClass");
//        MyInterface2.super.myMethod();
//    }
}
