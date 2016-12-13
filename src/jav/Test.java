package jav;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by feng on 2016/12/10.
 */
public class Test {

    public static void main(String[] args) {
        Lambda lambda = () -> {
            System.out.print("Test");
            return 1;
        };
        lambda.test();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        evaluate(list, (Integer n) -> n % 2 == 0);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate::test).forEach(System.out::println);
    }
}
