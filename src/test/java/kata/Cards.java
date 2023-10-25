package kata;

import java.util.List;

public final class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean size() {
        return cards.size() == 12;
    }

    public void flip(Position position) {
        Card card = cards.get(position.toIndex());
        card.flip();
    }

    public int sum() {
        return cards.stream()
                .filter(Card::isFlipped)
                .mapToInt(Card::points)
                .sum();
    }

}
