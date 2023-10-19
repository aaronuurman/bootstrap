package kata;

import java.util.ArrayList;
import java.util.List;

import static kata.GameState.READY;
import static kata.GameState.WAITING_FOR_ADDITIONAL_PLAYERS;

public class Game {

    private GameState state = WAITING_FOR_ADDITIONAL_PLAYERS;
    private final List<Player> players = new ArrayList<>();
    private final Deck deck = new Deck();

    public GameState state() {
        if (players.size() >= 2) {
            state = READY;
        }

        if (players.size() > 8) {
            state = GameState.TOO_MANY_PLAYERS;
        }

        return state;
    }

    public void join(Player player) {
        this.players.add(player);
    }

    public void start() {
        for (Player player : players) {
            List<Card> cards = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                cards.add(deck.takeCard());
            }
            player.receiveCards(cards);
        }
    }

    public int deckSize() {
        return deck.amountOfCards();
    }
}
