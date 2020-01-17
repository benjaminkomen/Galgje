package game.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Handle all the word guessing done by the player.
 */
public class Word {

    private String wordToGuess;
    private StringBuilder wordGuessed = new StringBuilder();
    private List<String> guessedLetters = new ArrayList<>();
    private boolean correctLetter = false;

    public Word(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        intializeWordGuessed(wordToGuess);
    }

    public String getWordToGuess() {
        return this.wordToGuess;
    }

    public String getWordGuessed() {
        return this.wordGuessed.toString();
    }

    /**
    * Update guessed word, based on the guessed input.
     */
    public String guessLetter(String guessInput) {
        guessInput = guessInput.toLowerCase();

        // first make sure the input is of length 1, if not, just take the first character
        if (guessInput.length() > 1) {
            guessInput = guessInput.substring(0, 1);
        }

        // add a character to the list of guessed letters if it is not guessed already
        if (!guessedLetters.contains(guessInput)) {
            guessedLetters.add(guessInput);
        }

        // now check if the guessed character is correct
        if (wordToGuess.contains(guessInput)) {
            correctLetter = true;

            int position = -1;

            // update wordGuessed with correct characters
            while (wordToGuess.indexOf(guessInput, position + 1) != -1) {
                position = wordToGuess.indexOf(guessInput, position + 1);
                wordGuessed.replace(position, position + 1, guessInput);
            }
        } else {
            correctLetter = false;
        }
        return wordGuessed.toString();
    }

	/**
	 * Get the List of guessed letters as a space-separated string.
	 */
    public String getGuessedLetters() {
        StringBuilder guessedLettersString = new StringBuilder();
		for (String guessedLetter : guessedLetters) {
			guessedLettersString.append(guessedLetter).append(" ");
		}
        return guessedLettersString.toString();
    }

    public boolean isGuessed() {
		return Objects.equals(getWordGuessed(), getWordToGuess());
    }

    public boolean isLetterCorrect() {
		return correctLetter;
    }

    private void intializeWordGuessed(String wordToGuess) {
        for (int i = wordGuessed.length(); i < wordToGuess.length(); i++) {
            wordGuessed.append(".");
        }
    }
}
