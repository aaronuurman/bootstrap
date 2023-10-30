package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class Players {

    private final List<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    public boolean hasEnoughPlayers() {
        return players.size() >= 2;
    }

    public boolean hasTooManyPlayers() {
        return players().size() > 8;
    }

    public List<Player> players() {
        return players;
    }

    public List<Player> getPlayers() {
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
}