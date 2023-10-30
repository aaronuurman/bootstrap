package kata;

public class Player {

    public Cards cards = Cards.none();
    public boolean yourTurn = false;
    private Card cardInHand;

    public void receiveCards(Cards cards) {
        this.cards = cards;
    }

    public void receiveCard(Card card) {
        this.cards.add(card);
    }

    public void flipCard(Position position) {
        cards.flip(position);
    }

    public void flipTwoCards(Position position, Position position1) {
        flipCard(position);
        flipCard(position1);
    }

    public int score() {
        return cards.sum();
    }

    public boolean isReady() {
        return cards.size();
    }

    public boolean isNextToPlay() {
        return yourTurn;
    }

    public void youGoNext() {
        this.yourTurn = true;
    }

    public void holdTemporarily(Card card) {
        this.cardInHand = card;
    }

    public Card swapAt(Position position) {
        return cards.swapAt(position, cardInHand);
    }

    public void endTurn() {
        this.yourTurn = false;
    }
}
