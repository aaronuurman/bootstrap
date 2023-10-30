package kata;

import java.util.ArrayList;

import static kata.GameState.READY;
import static kata.GameState.WAITING_FOR_ADDITIONAL_PLAYERS;

public class Game {

    private GameState state = WAITING_FOR_ADDITIONAL_PLAYERS;
    private final Players players = new Players();
    private final Deck deck = new Deck();
    private DiscardPile discardPile;

    public GameState state() {
        if (players.hasEnoughPlayers()) {
            state = READY;
        }

        if (players.hasTooManyPlayers()) {
            state = GameState.TOO_MANY_PLAYERS;
        }

        return state;
    }

    public void join(Player player) {
        players.add(player);
    }

    public void dealCards() {

        for (int i = 0; i < 12; i++) {
            players.foreach(p -> p.receiveCard(deck.takeCard()));
        }
        Card card = deck.takeCard();
        this.discardPile = DiscardPile.startingWith(card);
    }

    public int deckSize() {
        return deck.amountOfCards();
    }

    public Player whoGoesFirst() {
        return players.whoGoesFirst();
    }

    public Card topOfDiscardPile() {
        return discardPile.topCard();
    }

    public void cardTakenFromDiscardPile() {
        Card card = discardPile.takeCard();
        Player player = whoGoesFirst();
        player.holdTemporarily(card);
    }

    public void replaceCardInHandWith(Position position) {
        Player player = whoseTurnIsIt();
        Card discardedCard = player.swapAt(position);
        this.discardPile = DiscardPile.startingWith(discardedCard);
        endTurn();
    }

    private void endTurn() {
        players.advanceToNextPlayer();
    }

    private Player whoseTurnIsIt() {
        return players.whoseTurnIsIt();
    }

}
