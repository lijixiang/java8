import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d");

        list.forEach(item -> System.out.println(item));
        System.out.println("------------------");
        list.forEach(System.out::println);
    }


}
