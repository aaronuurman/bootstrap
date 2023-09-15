package kata;

public class Deck {

    private int amountOfCards = 150;

    public int amountOfCards() {
        return amountOfCards;
    }

    public void takeCard() {
        amountOfCards--;
    }
}
