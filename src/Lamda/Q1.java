package Lamda;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(10, 11, 30, 15);

        li.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
