package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class Players {

    private final List<Player> players;
    private int index;

    public Players() {
        this.players = new ArrayList<>();
    }

    public static Players create(int i) {
        Players players = new Players();
        for (int j = 0; j < i; j++) {
            players.addOne();
        }
        return players;
    }

    public boolean hasEnoughPlayers() {
        return players.size() >= 2;
    }

    public boolean hasTooManyPlayers() {
        return players.size() > 8;
    }

    private List<Player> getPlayers() {
        return players;
    }

    public void add(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        return "Players[" +
               "players=" + players + ']';
    }

    public void foreach(Consumer<Player> playerConsumer) {
        players.forEach(playerConsumer);
    }

    // what if 2 players have same score?
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

    public void advanceToNextPlayer() {
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

    public Player whoseTurnIsIt() {
        for (var player : getPlayers()) {
            if (player.isNextToPlay()) {
                return player;
            }
        }
        throw new IllegalStateException("No player has turn");
    }

    public Player addOne() {
        Player player = new Player();
        players.add(player);
        return player;
    }

    public void consumeCard(Card card) {
        Player player = players.get(index);
        player.receiveCard(card);
        if (index == players.size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    public Player getPlayer(int i) {
        return players.get(i - 1);
    }
}
