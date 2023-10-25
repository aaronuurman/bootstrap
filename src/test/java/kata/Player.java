package kata;

public class Player {

    public Cards cards = Cards.none();

    public void receiveCards(Cards cards) {
        this.cards = cards;
    }

    public void receiveCard(Card card) {
        this.cards.add(card);
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
