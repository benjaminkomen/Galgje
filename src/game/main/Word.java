package game.main;

import java.util.ArrayList;

/*
 * @description: This class handles all the word guessing done by the player
 * @author: Benjamin Komen
 */
public class Word {
	// Instance variables
	String wordToGuess;
	StringBuilder wordGuessed = new StringBuilder();
	ArrayList<String> guessedLetters = new ArrayList<>();
	boolean guessed = false;
	boolean correctLetter = false;
	
	// Constructor 
	public Word(String wordToGuess) {
		this.wordToGuess = wordToGuess;
		for( int i = wordGuessed.length(); i < wordToGuess.length(); i++ ) {
			wordGuessed.append(".");
		}
	}
	
	// getter
	public String getWordToGuess() {
		return this.wordToGuess;
	}
	
	// getter
	public String getWordGuessed() {
		return this.wordGuessed.toString();
	}
	
	// function to update guessed word
	public String guessLetter(String guessInput) {
		guessInput = guessInput.toLowerCase();
		// first make sure the input is of length 1
		if (guessInput.length() > 1) {
			guessInput = guessInput.substring(0, 1);
		}
		// add letter to list of guessed letters if it is not guessed already
		if(!guessedLetters.contains(guessInput)) {
			guessedLetters.add(guessInput);
		}
		
		// now check if letter is correct
		if(wordToGuess.indexOf(guessInput) > -1) {
			correctLetter = true;
			
			int position = -1;
			// update wordGuessed with correct letters
			while(wordToGuess.indexOf(guessInput, position+1) != -1) {
				position = wordToGuess.indexOf(guessInput, position+1);
				wordGuessed.replace(position, position+1, guessInput);
			}
		} else {
			correctLetter = false;
		}
		return wordGuessed.toString();
	}
	
	// get the ArrayList of guessed letters as a comma-separated list
	public String getGuessedLetters() {
		StringBuilder guessedLettersString = new StringBuilder();
		for (int i = 0; i < guessedLetters.size(); i++) {
			guessedLettersString.append(guessedLetters.get(i));
			guessedLettersString.append(" ");
		}
		return guessedLettersString.toString();
	}
	
	// function to check if word is already guessed
	public boolean isGuessed() {
		if(this.getWordGuessed().equals(this.getWordToGuess())) {
			return true;
		} else {
			return false;
		}
	}
	
	// function to check if letter guessed was wrong
	public boolean isLetterCorrect() {
		if(correctLetter == false) {
			return false;
		} else {
			return true;
		}
	}
}
