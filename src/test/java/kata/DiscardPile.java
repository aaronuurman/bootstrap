package kata;

public class DiscardPile {

    private final Card card;

    private DiscardPile(Card card) {
        this.card = card;
    }

    public static DiscardPile startingWith(Card card) {
        return new DiscardPile(card);
    }

    // SMELL: should have parameter to accept returned card that will be new discardpile
    public Card takeCard() {
        return this.card;
    }

    // SMELL: should be just the view on a Card. no need to have card that can be flipped
    public Card topCard() {
        return this.card;
    }
}
