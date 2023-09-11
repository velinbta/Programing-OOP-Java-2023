package GreedyTimes_06_1;

import java.util.Scanner;

// Задачата е решена (не е рефакторирана от друг код, като по условие)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] data = scanner.nextLine().split("\\s+");

        Treasure treasure = new Treasure(bagCapacity);

        for (int i = 0; i < data.length; i += 2) { // <- Pairs

            String item = data[i];
            long amount = Long.parseLong(data[i + 1]);

            treasure.add(item, amount);

        }

        System.out.println(treasure);

    }

}
