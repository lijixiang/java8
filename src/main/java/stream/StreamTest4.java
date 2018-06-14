package stream;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","helloworld","test");
        list.stream().map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------");
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        list2.stream().map(i->i*i)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),
                Arrays.asList(2,3),Arrays.asList(4,5,6));
        stream.flatMap(theList-> theList.stream()).map(item->item*item).forEach(System.out::println);
        System.out.println("---------------");
        Stream<String> stream1 = Stream.generate(UUID.randomUUID()::toString);
        stream1.findFirst().ifPresent(System.out::println);
        System.out.println("---------------");
        Stream.iterate(1,item->item +2).limit(6).forEach(System.out::println);

        System.out.println("-----------------------");
        //1,3,5,7,9,11 找出该数组中大于2的元素，然后将每个元素乘以2，然后忽略掉前两个元素，然后再取前两个元素，然后求和。
        int result = Stream.iterate(1,item->item+2).limit(6)
                .filter(item -> item>2)
                .mapToInt(item -> item*2)
                .skip(2)
                .limit(2)
                .sum();
        System.out.println(result);

    }
}
