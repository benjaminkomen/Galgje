package game.main;
/*
 * @description: This class draws and saves the progression of the gallows, which is constructed when the player guesses wrong
 * @author: Benjamin Komen
 */
public class Gallows {
	// Instance variables
	int wrongLetters = 0;
	StringBuilder gallowsDrawing = new StringBuilder();
	boolean gameOver = false;
	
	// function to draw gallows depending on amount of wrong letters
	public String drawGallows() {
		// if this function is called, this means a wrong letter has been entered
		wrongLetters++;
		
		switch(this.wrongLetters) {
		case 0:
			break;
		case 1:
			gallowsDrawing.append("|----|\n|\n|\n|\n|__");
			break;
		case 2:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|\n|\n|__");
			break;
		case 3:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|    0\n|\n|__");
			break;
		case 4:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|   /0\n|\n|__");
			break;
		case 5:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|   /0\\\n|\n|__");
			break;
		case 6:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|   /0\\\n|   /\n|__");
			break;
		case 7:
			gallowsDrawing.replace(0, gallowsDrawing.length(), "|----|\n|    o\n|   /0\\\n|   / \\\n|__");
			gameOver = true;
			break;
		default:
			System.out.println("Invalid amount of wrong letters.");
		}
		return gallowsDrawing.toString();
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
}
