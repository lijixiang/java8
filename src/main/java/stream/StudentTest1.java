package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class StudentTest1 {
    public static void main(String[] args) {
        Student stduent = new Student("zhangsan",80);
        Student stduent1 = new Student("lisi",90);
        Student stduent2 = new Student("wangwu",100);
        Student stduent3 = new Student("zhaoliu",90);

        List<Student> list = Arrays.asList(stduent,stduent1,stduent2,stduent3);

        List<Student> list1 = list.stream().collect(toList());
        list1.forEach(System.out::println);
        System.out.println("------------");
        System.out.println("count: "+list.stream().collect(counting()));
        System.out.println("count: "+list.stream().count());

    }
}
