package game.main;
/*
 * @description: This class describes the player, who plays the game
 * @author: Benjamin Komen
 */
public class Player {
	// Instance variables.
	private String name = "nameless player 1";
	private int score = 0;
	
	// method to obtain player score
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
