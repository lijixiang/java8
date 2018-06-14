package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello","world","hello world");
//        String[] strings = stream.toArray(length -> new String[length]);
//        String[] string1 = stream.toArray(String[]::new);
//        Arrays.asList(strings).forEach(System.out::println);
//        List<String> list = stream.collect(Collectors.toList());
//        list.forEach(System.out::println);
//        List<String> list = stream.collect(()->new ArrayList<String>()
//                ,(theList,item)->theList.add(item),(theList1,theList2)->theList1.addAll(theList2));
//        list.forEach(System.out::println);

//        List<String> list = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
//        list.forEach(System.out::println);
//        List<String> list = stream.collect(Collectors.toCollection(LinkedList::new));
//        list.forEach(System.out::println);
//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        set.forEach(System.out::println);
//        String string = stream.collect(Collectors.joining());
//        System.out.println(string);

    }
}
