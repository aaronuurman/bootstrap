package kata;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    public Deck() {
        this.cards = initializeDeck();
    }

    private List<Card> cards;

    public int amountOfCards() {
        return cards.size();
    }

    public Card takeCard() {
        return cards.remove(0);
    }

    private List<Card> initializeDeck() {
        var cards = new ArrayList<Card>();
        for (int p = 1; p <= 12; p++) {
            for (int i = 0; i < 10; i++) {
                cards.add(new Card(p));
            }
        }
        for (int i = 1; i <= 10; i++) {
            cards.add(new Card(-1));
        }
        for (int i = 1; i <= 5; i++) {
            cards.add(new Card(-2));
        }
        for (int i = 1; i <= 15; i++) {
            cards.add(new Card(0));
        }
        return cards;
    }
}
