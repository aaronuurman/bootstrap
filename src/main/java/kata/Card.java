package kata;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return points == card.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Card{" +
               "points=" + points +
               ", flipped=" + flipped +
               '}';
    }
}
