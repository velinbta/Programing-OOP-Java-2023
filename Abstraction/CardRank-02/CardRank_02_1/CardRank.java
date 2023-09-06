package CardRank_02_1;

import java.util.Arrays;

public enum CardRank {

    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public static void iterateOverCards() {

        Arrays.stream(CardRank.values()).forEach(card ->
                System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name()));

    }

}
