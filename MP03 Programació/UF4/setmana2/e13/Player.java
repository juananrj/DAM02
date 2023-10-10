package setmana2.e13;


public class Player {
    private String playerName;
    private int totalPoints;

    public Player(String playerName) {
        this.playerName = playerName;
        this.totalPoints = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
