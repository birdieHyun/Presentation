package lambdastream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MyLambda {
    static Predicate<Integer> p = i -> i < 100;

    public static void main(String[] args) {

        Predicate<Integer> or = p.and(i -> i < 200).or(i -> i % 2 == 0);

        boolean test = or.test(202);

        System.out.println(test);
        List<String> list = new ArrayList<>();
        list.add("1000");
        list.add("100");
        list.add("10");
        list.add("1");

        // list 를 문자열 길이순으로 정렬하고 싶다면?
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : list) {
            System.out.println(s); // 1, 10, 100, 1000 순으로 정렬된다.
        }
    }

}
