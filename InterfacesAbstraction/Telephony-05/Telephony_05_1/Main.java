package Telephony_05_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = readList(scanner);
        List<String> urls = readList(scanner);

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.println(smartphone.call()); // <- digits only
        System.out.println(smartphone.browse()); // <- anything but digits

    }

    private static List<String> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
    }

}
