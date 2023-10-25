package kata;

import com.github.larseckart.tcr.TestCommitRevertMainExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(TestCommitRevertMainExtension.class)
class GameTest {

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

    @Test
    void game_can_have_up_to_eight_players() {
        Game game = new Game();
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());

        GameState gameState = game.state();

        assertThat(gameState).isEqualTo(GameState.READY);
    }

    @Test
    void when_more_than_eight_player_join_game_then_game_is_in_state_too_many_players() {
        Game game = new Game();
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());
        game.join(new Player());

        GameState gameState = game.state();

        assertThat(gameState).isEqualTo(GameState.TOO_MANY_PLAYERS);
    }

    @Test
    void game_starts_with_cards_dealing() {
        Game game = new Game();
        game.join(new Player());
        game.join(new Player());

        game.start();

        assertThat(game.deckSize()).isEqualTo(150 - 12 - 12);
    }

    // SMELL: we dont understand what Deck this game is using that players have score 2 and 5
    @Test
    void after_dealing_player_flip_two_cards_and_player_with_highest_score_starts() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.join(player1);
        game.join(player2);

        game.start();

        player1.flipCard(Position.inRow(0).inColumn(0));
        player1.flipCard(Position.inRow(0).inColumn(1));
        player2.flipCard(Position.inColumn(0).inRow(0));
        player2.flipCard(Position.inRow(3).inColumn(2));

        assertThat(player1.score()).isNotEqualTo(player2.score());
        assertThat(game.whoGoesFirst()).isEqualTo(player2);
    }
}
