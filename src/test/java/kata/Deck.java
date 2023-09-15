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
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(1));
        }
        for (int i = 0; i < 140; i++) {
            cards.add(new Card(14));
        }
        return cards;
    }
}
