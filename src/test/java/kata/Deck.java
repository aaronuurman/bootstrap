package kata;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    public Deck() {
        this.cards = initializeDeck();
        this.amountOfCards = 150;
    }

    private List<Card> cards;
    private int amountOfCards;

    public int amountOfCards() {
        return amountOfCards;
    }

    public Card takeCard() {
        amountOfCards--;
        return cards.get(amountOfCards);
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
