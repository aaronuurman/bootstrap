package kata;

public class DiscardPile {

    private final Card card;

    private DiscardPile(Card card) {
        this.card = card;
    }

    public static DiscardPile startingWith(Card card) {
        return new DiscardPile(card);
    }

    public Card takeCard() {
        return this.card;
    }
}
