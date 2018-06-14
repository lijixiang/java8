public class AbstractAction {

    /**
     * 此处 myAction的参数是AbstractActionInterface类型的对象，
     * 所以说JAVA中 Lambda 表达式是对象，而不像JavaScript中是函数
     * 但是，这个对象特殊的地方在于 它表达的是一种行为或动作
     * @param abstractAct
     */
    public void myAction(AbstractActionInterface abstractAct){
        System.out.println("before");
        abstractAct.action();
        System.out.println("after");
    }

    public static void main(String[] args) {
        AbstractAction action = new AbstractAction();
        action.myAction(() -> System.out.println("action"));
    }

}

@FunctionalInterface
interface AbstractActionInterface{
    void action();
}
