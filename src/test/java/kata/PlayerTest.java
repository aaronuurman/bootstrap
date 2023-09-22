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

}
