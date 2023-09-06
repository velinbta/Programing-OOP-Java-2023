package CardsWithPower_03_1;

// Calculates power of two
public class CardCalculator {

    private final CardRank rank;
    private final CardSuit suit;

    public CardCalculator(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int calculatePower() {
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(), this.suit.name(), this.calculatePower());
    }

}
