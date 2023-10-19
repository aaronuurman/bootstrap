package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DiscardPileTest {

    @Test
    void discard_pile_is_never_empty() {
        DiscardPile discardPile = DiscardPile.startingWith(new Card(5));
        Card card = discardPile.takeCard();
        assertThat(card.points()).isEqualTo(5);
    }

}
