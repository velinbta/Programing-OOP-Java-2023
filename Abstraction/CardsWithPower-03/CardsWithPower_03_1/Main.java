package CardsWithPower_03_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(scanner.nextLine());
        CardSuit suit = CardSuit.valueOf(scanner.nextLine());

        CardCalculator calculator = new CardCalculator(rank, suit);
        System.out.println(calculator);

    }

}
