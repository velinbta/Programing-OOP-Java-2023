package StackOfStrings_04_1;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        StackOfStrings alphabetBackwards = new StackOfStrings();
        IntStream.rangeClosed('A', 'Z').forEach(item -> alphabetBackwards.push(Character.toString(item)));
        alphabetBackwards.forEach(item -> System.out.print(item + " "));
        System.out.println();

        StackOfStrings alphabetIncreasing = new StackOfStrings();
        AtomicInteger repeat = new AtomicInteger(26);
        IntStream.rangeClosed('A', 'Z').boxed().sorted(Comparator.reverseOrder())
                .forEach(item -> alphabetIncreasing.push(Character.toString(item).repeat(repeat.getAndDecrement())));

        alphabetIncreasing.forEach(item -> System.out.print(item + " "));

    }

}
