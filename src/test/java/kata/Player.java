package kata;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int score = 0;
    private List<Card> cards = new ArrayList<>();

    public void receiveCards(List<Card> cards) {
        this.cards = List.copyOf(cards);
    }

    public int score() {
        return this.score;
    }

    public boolean isReady() {
        return cards.size() == 12;
    }

    public void flipCard(int cardIndex) {
        Card card = cards.get(cardIndex);
        score += card.points();
    }
}
