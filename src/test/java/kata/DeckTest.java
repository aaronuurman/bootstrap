package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.larseckart.tcr.TestCommitRevertExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(TestCommitRevertExtension.class)
class DeckTest {
    @Test
    void deck_size_is_150() {
        Deck deck = new Deck();
        assertThat(deck.amountOfCards()).isEqualTo(150);
    }

    @Test
    void deck_has_149_cards_when_we_take_one() {
        Deck deck = new Deck();

        deck.takeCard();

        assertThat(deck.amountOfCards()).isEqualTo(149);
    }
}
