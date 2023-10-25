package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.larseckart.tcr.TestCommitRevertMainExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DeckTest {

    private final Deck deck = new Deck();

    @Test
    void deck_size_is_150() {
        assertThat(deck.amountOfCards()).isEqualTo(150);
    }

    @Test
    void deck_has_149_cards_when_we_take_one() {
        deck.takeCard();

        assertThat(deck.amountOfCards()).isEqualTo(149);
    }

    @Test
    void deck_contains_10_cards_with_1_point() {
        int counter = 0;
        for (int i = 0; i < 150; i++) {
            var card = deck.takeCard();
            if (card.points() == 1) {
                counter++;
            }
        }
        assertThat(counter).isEqualTo(10);
    }

    @Test
    void deck_contains_5_cards_with_minus_2_point() {
        int counter = 0;
        for (int i = 0; i < 150; i++) {
            var card = deck.takeCard();
            if (card.points() == -2) {
                counter++;
            }
        }
        assertThat(counter).isEqualTo(5);
    }

    @Test
    void deck_contains_15_cards_with_0_point() {
        int counter = 0;
        for (int i = 0; i < 150; i++) {
            var card = deck.takeCard();
            if (card.points() == 0) {
                counter++;
            }
        }
        assertThat(counter).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12 })
    void deck_contains_10_cards_with_1_point(int points) {
        int counter = 0;
        for (int i = 0; i < 150; i++) {
            var card = deck.takeCard();
            if (card.points() == points) {
                counter++;
            }
        }
        assertThat(counter).isEqualTo(10);
    }

    // TODO: test to verify that card in discard pile is flipped.

}
