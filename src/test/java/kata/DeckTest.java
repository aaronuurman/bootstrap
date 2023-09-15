package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.larseckart.tcr.TestCommitRevertExtension;
import com.github.larseckart.tcr.TestCommitRevertMainExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(TestCommitRevertMainExtension.class)
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
    void applesauce(){
        int counter = 0;
        for (int i = 0; i < 150; i++) {
            var card = deck.takeCard();
            if(card.points()==1){
                counter++;
            }
        }
        assertThat(counter).isEqualTo(10);
    }

}
