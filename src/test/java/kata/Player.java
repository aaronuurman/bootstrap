package kata;

public class Player {

    public Cards cards;

    public void receiveCards(Cards cards) {
        this.cards = cards;
    }

    public int score() {
        return cards.sum();
    }

    public boolean isReady() {
        return cards.size();
    }

    public void flipCard(Position position) {
        cards.flip(position);
    }

}
