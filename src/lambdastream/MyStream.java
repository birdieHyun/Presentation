package lambdastream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStream {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("c");
        a.add("b");
        a.add("a");

        List<String> collect = a.stream().sorted().distinct().collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }

}
