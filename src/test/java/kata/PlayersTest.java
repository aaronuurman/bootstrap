package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    // @Disabled("have to fix first the case that players only have a score when they have 12 cards")
    @Test
    void determine_who_goes_first_when_players_have_12_cards_and_two_flipped() {
        Players players = new Players();
        var player1 = players.addOne();
        var player2 = players.addOne();
        var player3 = players.addOne();

        // TODO: continue from here, expand Cards so that it can be flipped...
        players.consumeCard(new Card(1));
        players.consumeCard(new Card(2));
        players.consumeCard(new Card(3));
        players.consumeCard(new Card(1));
        players.consumeCard(new Card(2));
        players.consumeCard(new Card(3));

        Player nextPlayer = players.whoGoesFirst();

        assertEquals(player3, nextPlayer);
    }

    private static Cards twoFlippedCardsWithValue(int points) {
        Card card5 = new Card(points);
        card5.flip();
        return Cards.from(card5);
    }

}