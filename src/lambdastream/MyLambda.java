package lambdastream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyLambda {

    public static void main(String[] args) {

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
