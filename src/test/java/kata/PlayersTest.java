package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    // @Disabled("have to fix first the case that players only have a score when they have 12 cards")
    @Test
    void determine_who_goes_first_when_players_have_12_cards_and_two_flipped() {
        Players players = Players.create(3);
        deal(players, 1, 2, 3, 1, 2, 3);

        assertEquals(players.getPlayer(3), players.whoGoesFirst());
    }

    private void deal(Players players, int... cards) {
        for (int card : cards) {
            Card card1 = new Card(card);
            card1.flip();
            players.consumeCard(card1);
        }
    }


}
