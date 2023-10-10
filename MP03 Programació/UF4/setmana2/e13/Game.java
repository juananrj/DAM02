
package setmana2.e13;



public class Game {
    private int currentGameLevel;
    private int currentNumPlayers;

    public Game() {
        this.currentGameLevel = 1;
        this.currentNumPlayers = 1;
    }

    public int getCurrentGameLevel() {
        return currentGameLevel;
    }

    public int getCurrentNumPlayers() {
        return currentNumPlayers;
    }

    public void setCurrentGameLevel(int currentGameLevel) {
        this.currentGameLevel = currentGameLevel;
    }

    public void setCurrentNumPlayers(int currentNumPlayers) {
        this.currentNumPlayers = currentNumPlayers;
    }
}
