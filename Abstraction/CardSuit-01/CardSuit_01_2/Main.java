package CardSuit_01_2;

import java.util.Scanner;

public class Main {

    static { // <- Pre block
        System.out.println("Card Suits:");
    }

    public static String COMMAND = "Card Suits";

    public static void main(String[] args) {

        String command = new Scanner(System.in).nextLine();

        if (!command.equals(COMMAND)) { // <- Command exception
            throw new IllegalArgumentException("Single available command: \"Card Suits\"");
        }

        CardSuit.iterateOverCards();

    }

}
