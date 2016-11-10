package game.main;

import java.io.IOException;

/*
 * @description: This class is the main class of the game where all other classes are called
 * @author: Benjamin Komen
 */
public class Game {

	public static void main(String[] args) {
		String inputName;
		String wordToGuess;
		boolean guessed = false;
		int wrongLetters = 0;
		
		Player player = new Player();
		
		// Display menu options in a loop.
		int option = -1;
			do {
				try {
					System.out.println();
					System.out.println("---------------------------------------------------------");
					System.out.println("1. Create player");
					System.out.println("2. Get player score");
					System.out.println("3. Start game");
					System.out.println("9. Quit");
						
					option = Helper.getInt("\nEnter option => ");
					
					switch (option) {
					
					case 1:
						inputName = Helper.getString("Enter player name: ");
						player.setName(inputName);
						System.out.println("Created player " + player.getName());
						break;
						
					case 2:
						System.out.println("Score of player " + player.getName() + " is: " + player.getScore());
						break;
						
					case 3:
						System.out.println("Starting game..");
						int inputLength = Helper.getInt("Enter length of word you want to guess (minimum: 2, maximum: 35): ");
						System.out.println("Obtaining word of length " + inputLength + " from dictionary.");
						
						// try to get a word from the dictionary
						try {
							// create Dictionary object to read text file with words and to get a word from that list
							Dictionary dict = new Dictionary();
							wordToGuess = dict.getWord(inputLength);
							
							// create Word object to handle the updating of the guessed word
							Word word = new Word(wordToGuess);
							System.out.println(word.getWordGuessed());
							
							// create a Gallows object to draw a gallow
							Gallows gallows = new Gallows();
							
							while(guessed == false) {
								String guessInput = Helper.getString("Guess a letter: ");
								String wordGuessed = word.guessLetter(guessInput);
								String guessedLetters = word.getGuessedLetters();
								System.out.println(wordGuessed);
								
								// call drawGallows function if guessed letter is not correct
								if(word.isLetterCorrect() == false) {
									System.out.println(gallows.drawGallows());
								}
								if(gallows.gameOver == true) {
									System.out.println("Game over!");
									break;
								}
								System.out.println("You already used the following characters: " + guessedLetters);
								if(word.isGuessed() == true) {
									guessed = true;
									System.out.println("Good job! You found the correct word.");
								} else {
									guessed = false;
								}
							}
							
						} catch (IOException e) {
							System.out.println("An error with the import of the list of words has occured: " + e.getMessage());
						}
						
						break;

					case 9:
						// Quit program
						break;
						
					default:
						System.out.println("Invalid option selected.");
				}
					
					
				} catch (Exception ex) {
					System.out.println("An exception occured: " + ex.getMessage());
				}			
			} while (option != 9);

	}

}
