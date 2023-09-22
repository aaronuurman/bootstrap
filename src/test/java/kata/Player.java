package kata;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards = new ArrayList<>();

    public void receiveCards(List<Card> cards) {
        this.cards = List.copyOf(cards);
    }

    public int score() {
        return this.cards.stream()
                .filter(Card::isFlipped)
                .mapToInt(Card::points)
                .sum();
    }

    public boolean isReady() {
        return cards.size() == 12;
    }

    public void flipCard(int cardIndex) {
        Card card = cards.get(cardIndex);
        card.flip();
    }
}
