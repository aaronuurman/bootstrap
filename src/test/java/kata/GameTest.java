package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.larseckart.tcr.TestCommitRevertMainExtension;

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
    void after_dealing_cards_discard_pile_is_created() {
        Game game = new Game();
        game.join(new Player());
        game.join(new Player());

        game.dealCards();

        assertThat(game.deckSize()).isEqualTo(150 - 12 - 12 - 1);
        assertThat(game.topOfDiscardPile()).isEqualTo(new Card(3));
    }

    // SMELL: we don't understand what Deck this game is using that players have score 2 and 5
    @Test
    void after_dealing_player_flip_two_cards_and_player_with_highest_score_starts() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.join(player1);
        game.join(player2);

        game.dealCards();

        player1.flipTwoCards(Position.inRow(0).inColumn(0), Position.inRow(0).inColumn(1));
        player2.flipTwoCards(Position.inColumn(0).inRow(0), Position.inRow(3).inColumn(2));

        assertThat(player1.score()).isNotEqualTo(player2.score());
        assertThat(game.whoGoesFirst()).isEqualTo(player2);
        assertThat(player2.isNextToPlay()).isTrue();
        assertThat(player1.isNextToPlay()).isFalse();
    }

    @Test
    void after_playing_then_next_players_turn_it_is() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.join(player1);
        game.join(player2);

        game.dealCards();

        player1.flipTwoCards(Position.inRow(0).inColumn(0), Position.inRow(0).inColumn(1));
        player2.flipTwoCards(Position.inColumn(0).inRow(0), Position.inRow(3).inColumn(2));

        game.cardTakenFromDiscardPile();
        game.replaceCardInHandWith(Position.inRow(0).inColumn(0));

        assertThat(player2.score()).isEqualTo(6);
        // TODO: continue here next time
//        assertThat(player2.isNextToPlay()).isFalse();
//        assertThat(player1.isNextToPlay()).isTrue();
    }

}
