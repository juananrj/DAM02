package setmana2.e13;
import java.util.*;
class Game {
    private int level;
    private ArrayList<Player> players;

    public Game() {
        this.level = 1;
        this.players = new ArrayList<>();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayers(int numPlayers) {
        if (numPlayers <= 4) {
            players.clear();
            for (int i = 1; i <= numPlayers; i++) {
                players.add(new Player("Player " + i));
            }
        } else {
            System.out.println("Maximum players allowed is 4.");
        }
    }

    public void play() {
        System.out.println("Current game level: " + level);
        System.out.println("Current number of players: " + players.size());
    }
}
