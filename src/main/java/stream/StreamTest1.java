package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        Stream stream1 = Stream.of("hello","world","beijing");
        String[] myarray = new String[]{"a","b","c"};
        Stream stream3 = Arrays.stream(myarray);
        List<String> strings = Arrays.asList("a","b","c","d");
        Stream stream2 = strings.stream();
    }
}
