import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jesse","Tom","Fiona","William","Steven");
        String[] sa = new String[10];
        sa[0] = "1";
        System.out.println(sa.length);
        sa[1] = "2";
        System.out.println(sa.length);

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println(names);
        //---------------------------------//
//        Collections.sort(names,(String o1,String o2) -> {return o1.compareTo(o2);});
//        System.out.println(names);

        //---------------------------------//
//        Collections.sort(names,(o1,o2) -> o1.compareTo(o2));
//        System.out.println(names);

        //---------------------------------//
        Collections.sort(names);
        System.out.println(names);
    }
}
