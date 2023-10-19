package kata;

import java.util.ArrayList;
import java.util.List;

import static kata.GameState.READY;
import static kata.GameState.WAITING_FOR_ADDITIONAL_PLAYERS;

public class Game {

    private GameState state = WAITING_FOR_ADDITIONAL_PLAYERS;
    private final List<Player> players = new ArrayList<>();

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
}
