package stream;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        System.out.println("-------------");
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("-------------");
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(0,9).forEach(list::add);
        list.forEach(System.out::println);
        System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));
    }

}
