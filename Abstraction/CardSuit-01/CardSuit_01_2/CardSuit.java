package CardSuit_01_2;

import java.util.Arrays;

public enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static void iterateOverCards() {
        // Итерира с необходимия текст
        Arrays.stream(CardSuit.values()).forEach(card ->
                System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name()));

    }

}
