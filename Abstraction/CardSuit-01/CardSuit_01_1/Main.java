package CardSuit_01_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static { // <- Pre block
        System.out.println("Card Suits:");
    }

    public static String COMMAND = "Card Suits";

    public static void main(String[] args) {

        String command = new Scanner(System.in).nextLine();

        if (!command.equals(COMMAND)) { // <- Exception
            throw new IllegalArgumentException("Single available command: \"Card Suits\"");
        }

        CardSuit[] cards = CardSuit.values();

        Arrays.stream(cards).forEach(card -> // <- Iterate
                System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name()));

    }

}
