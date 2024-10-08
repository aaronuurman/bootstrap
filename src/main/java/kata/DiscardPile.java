package kata;

public class DiscardPile {

    private final Card card;

    private DiscardPile(Card card) {
        this.card = card;
    }

    // no Test that forced us to write the if statement (became necessary due to test in GameTest)
    public static DiscardPile startingWith(Card card) {
        if (!card.isFlipped()) {
            card.flip();
        }
        return new DiscardPile(card);
    }

    // SMELL: should have parameter to accept returned card that will be new discardpile
    public Card takeCard() {
        return this.card;
    }

    // TODO SMELL: should be just the view on a Card. no need to have card that can be flipped
    public Card topCard() {
        return this.card;
    }
}
