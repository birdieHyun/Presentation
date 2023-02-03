package lambdastream;

import java.util.function.Predicate;

public class PredicateImpl {

    public static void main(String[] args) {
        Predicate<Integer> lessThan100 = i -> i < 100;
        Predicate<Integer> moreThan50 = i -> i > 50;
        Predicate<Integer> evenNum = i -> i % 2 == 0;
        Predicate<Integer> oddNum = i -> i % 2 != 0;

        Predicate<Integer> sample = lessThan100.and(moreThan50);

        Predicate<Integer> and = lessThan100.and(moreThan50.and(evenNum));

        boolean test = and.test(70);
        boolean test2 = and.test(75);

        System.out.println("test = " + test);
        System.out.println("test2 = " + test2);
    }

}
