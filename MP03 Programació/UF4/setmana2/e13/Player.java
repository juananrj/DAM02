package setmana2.e13;

class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return name + " - Points: " + points;
    }
}
