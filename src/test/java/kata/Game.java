package kata;

import static kata.GameState.WAITING_PLAYERS_TO_BE_READY;

public class Game {

    private final GameState state = WAITING_PLAYERS_TO_BE_READY;
    public GameState state() {
        return state;
    }
}
