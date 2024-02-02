package kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Cards {
    private final List<Card> cards = new ArrayList<>();

    private Cards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    public static Cards none() {
        return new Cards();
    }

    public static Cards of(Card card) {
        return new Cards(card);
    }

    public static Cards from(Card... cards) {
        return new Cards(cards);
    }

    public void add(Card card) {
        this.cards.add(card);
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

    public Card swapAt(Position position, Card cardInHand) {
        return cards.set(position.toIndex(), cardInHand);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + cards +
                '}';
    }
}
