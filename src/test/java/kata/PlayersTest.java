package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    // @Disabled("have to fix first the case that players only have a score when they have 12 cards")
    @Test
    void determine_who_goes_first_when_players_have_12_cards_and_two_flipped() {
        Players players = new Players();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        player1.receiveCards(get12CardsWithTwoFlippedOnes(1, 1));
        player2.receiveCards(get12CardsWithTwoFlippedOnes(2, 2));
        player3.receiveCards(get12CardsWithTwoFlippedOnes(3, 3));

        Player nextPlayer = players.whoGoesFirst();

        assertEquals(player3, nextPlayer);
    }

    private static Cards get12CardsWithTwoFlippedOnes(int... points) {
        if (points.length != 2) {
            throw new IllegalArgumentException("must have exactly two points");
        }
        Card card5 = new Card(points[0]);
        card5.flip();
        Card card6 = new Card(points[1]);
        card6.flip();
        return Cards.from(
                card5,
                card6,
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
        );
    }

}