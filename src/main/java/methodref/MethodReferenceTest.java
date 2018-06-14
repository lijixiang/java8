package methodref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier){
        return supplier.get()+"test";
    }

    public String getString2(String str,Function<String,String> function){
        return function.apply(str);
    }



    public static void main(String[] args) {




        Student s1 = new Student("zhangsan",10);
        Student s2 = new Student("lisi",90);
        Student s3 = new Student("wangwu",50);
        Student s4 = new Student("zhaoliu",60);
        List<Student> students = Arrays.asList(s1,s2,s3,s4);
//        students.sort((student1,student2)->Student.compareStudentByScore(student1,student2));
//        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("-----------------");

//        students.sort(Student::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(new StudentComparator()::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(Student::compareByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        List<String> cities = Arrays.asList("qingdao","beijing","shanghai","tianjin");
//        Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
//        cities.forEach(city -> System.out.println(city));
//        Collections.sort(cities,String::compareToIgnoreCase);
//        cities.forEach(System.out::println);

        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello",String::new));

    }
}
