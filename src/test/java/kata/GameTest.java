package kata;

import javax.print.DocFlavor;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameTest {

    @Test
    void when_game_is_created_then_state_is_waiting_for_additional_players() {
        Game game = new Game();
        GameState gameState = game.state();
        assertThat(gameState).isEqualTo(GameState.WAITING_FOR_ADDITIONAL_PLAYERS);
    }

    @Test
    void when_game_has_at_least_two_players_it_can_be_started() {
        Game game = new Game();
        game.join(new Player());
        game.join(new Player());

        GameState gameState = game.state();

        assertThat(gameState).isEqualTo(GameState.READY);
    }

}
