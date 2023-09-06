package CardRank_02_1;

import java.util.Scanner;

public class Main {

    static { // <- Pre block
        System.out.println("Card Ranks:");
    }

    public static String COMMAND = "Card Ranks";

    public static void main(String[] args) {

        String command = new Scanner(System.in).nextLine();

        if (!command.equals(COMMAND)) { // <- Exception
            throw new IllegalArgumentException("Single possible command: \"Card Ranks\"");
        }

        CardRank.iterateOverCards();

    }

}
