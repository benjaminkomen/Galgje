package game.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @description: This class provides the handling of the dictionary of words
 * @author: Benjamin Komen
 */
public class Dictionary {
	private HashMap<Integer, ArrayList<String>> wordList = new HashMap<>(35);

	// Constructor
	public Dictionary() throws IOException {
		String inputFile = "groene_boekje.txt";
		// read all words from the input file and put them in the HashMap
		// wordList
		BufferedReader input = new BufferedReader(new FileReader(inputFile));
		String word;
		while ((word = input.readLine()) != null) {
			// create ArrayList and check if the HashMap wordList contains an
			// entry with the key of the current word
			ArrayList<String> wordListOfLength = wordList.get(word.length());
			// if there was no entry in the HashMap with that length, create it
			// and add the current word
			if (wordListOfLength == null) {
				wordListOfLength = new ArrayList<String>(word.length());
				wordListOfLength.add(word);
				wordList.put(word.length(), wordListOfLength);
			} else {
				wordListOfLength.add(word);
			}
		}
		input.close();
	}
	
	// function to get random word of length
	public String getWord(int length) {
		// define local variables
		Double wordPosition;
		int arraySize;
		double randomNumber;
		ArrayList<String> wordListOfLength;
		
		// initialize variables
		wordListOfLength = wordList.get(length);
		arraySize = wordListOfLength.size();
		randomNumber = Math.random();
		wordPosition = randomNumber * arraySize / 1.0;
		
		// return the word of given length at random word position
		return wordListOfLength.get(wordPosition.intValue());
		
	}
}
