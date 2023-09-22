package kata;

public class Card {

    private final int points;
    private boolean flipped = false;

    public Card(int points) {
        this.points = points;
    }

    public int points() {
        return points;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    public void flip() {
        this.flipped = true;
    }
}
