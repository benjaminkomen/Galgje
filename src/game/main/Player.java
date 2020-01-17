package game.main;

/**
 * This class describes the player, who plays the game.
 */
public class Player {

    private String name = "nameless player 1";
    private int score = 0;

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
