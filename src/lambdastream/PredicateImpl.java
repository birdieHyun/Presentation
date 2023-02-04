package lambdastream;

import java.util.function.Predicate;

public class PredicateImpl {

    private final static int testNumber1 = 70;
    private final static int testNumber2 = 75;

    public static void main(String[] args) {
        Predicate<Integer> lessThan100 = i -> i < 100;
        Predicate<Integer> moreThan50 = i -> i > 50;
        Predicate<Integer> evenNum = i -> i % 2 == 0;
        Predicate<Integer> oddNum = i -> i % 2 != 0;

        Predicate<Integer> sample = lessThan100.and(moreThan50);

        Predicate<Integer> and = lessThan100.and(moreThan50.and(evenNum));

        boolean bool = true;
        if (testNumber1 < 100 && testNumber1 > 50 && testNumber1 % 2 == 0) {
            bool = true;
        }else {
            bool = false;
        }


        boolean test = and.test(testNumber1);
        boolean test2 = and.test(testNumber2);

        System.out.println("bool = " + bool);
        System.out.println("test = " + test);
        System.out.println("test2 = " + test2);
    }

}
