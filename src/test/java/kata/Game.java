package kata;

import java.util.ArrayList;
import java.util.List;

import static kata.GameState.READY;
import static kata.GameState.WAITING_FOR_ADDITIONAL_PLAYERS;

public class Game {

    private GameState state = WAITING_FOR_ADDITIONAL_PLAYERS;
    private final List<Player> players = new ArrayList<>();
    private final Deck deck = new Deck();
    private DiscardPile discardPile;

    public GameState state() {
        if (players.size() >= 2) {
            state = READY;
        }

        if (players.size() > 8) {
            state = GameState.TOO_MANY_PLAYERS;
        }

        return state;
    }

    public void join(Player player) {
        this.players.add(player);
    }

    public void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 12; i++) {
                Card e = deck.takeCard();
                player.receiveCard(e);
            }
        }
        Card card = deck.takeCard();
        this.discardPile = DiscardPile.startingWith(card);
    }

    public int deckSize() {
        return deck.amountOfCards();
    }

    public Player whoGoesFirst() {
        Player highestScorePlayer = players.get(0);
        for (var player : players) {
            if (player.score() > highestScorePlayer.score()) {
                highestScorePlayer = player;
            }
        }
        highestScorePlayer.youGoNext();
        return highestScorePlayer;
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
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.isNextToPlay()) {
                if (i == players.size() - 1) {
                    players.get(0).youGoNext();
                } else {
                    players.get(i + 1).youGoNext();
                }
                player.endTurn();
                break;
            }
        }
    }

    private Player whoseTurnIsIt() {
        for (var player : players) {
            if (player.isNextToPlay()) {
                return player;
            }
        }
        throw new IllegalStateException("No player has turn");
    }
}
