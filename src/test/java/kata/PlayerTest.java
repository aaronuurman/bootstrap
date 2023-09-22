package kata;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void apple_sauce() {
        Player player = new Player();
        player.receiveCards(List.of(new Card(1)));
        Assertions.assertThat(player.score()).isZero();
    }

    @Test
    void player_cant_start_game_with_less_than_12_cards() {
        Player player = new Player();
        player.receiveCards(List.of(new Card(1)));
        Assertions.assertThat(player.isReady()).isFalse();
    }

    @Test
    void player_can_start_game_when_he_has_12_cards() {
        Player player = new Player();
        player.receiveCards(List.of(
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1)
        ));
        Assertions.assertThat(player.isReady()).isTrue();
    }

    @Test
    void player_flips_positive_card_then_score_increases() {
        Player player = new Player();
        player.receiveCards(List.of(
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1),
                new Card(1)
        ));
        player.flipCard(3);
        Assertions.assertThat(player.score()).isPositive();
    }

}
