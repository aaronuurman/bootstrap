package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameTest {

    @Test
    void when_game_is_created_then_state_is_waiting_for_players_to_be_ready() {
        Game game = new Game();
        GameState gameState = game.state();
        assertThat(gameState).isEqualTo(GameState.WAITING_PLAYERS_TO_BE_READY);
    }

}
