package game.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the handling of the dictionary of words.
 */
public class Dictionary {

    private static final int MAX_WORD_LENGTH = 35;
    private final Map<Integer, List<String>> wordList = loadWordList();

    /**
     * Get random word from list of words, of given length.
     */
    public String getRandomWordFromWordList(int length) {

        if (length < 2 || length > MAX_WORD_LENGTH) {
            System.out.println(String.format("Error! Please quit the game, restart and enter a length between 2 and %s", MAX_WORD_LENGTH));
            return "";
        }

        // define local variables
        double wordPosition;
        int arraySize;
        List<String> wordListOfLength;

        // initialize variables
        wordListOfLength = wordList.get(length);
        arraySize = wordListOfLength.size();
        wordPosition = Math.random() * arraySize / 1.0;

        // return the word of given length at random word position
        return wordListOfLength.get((int) wordPosition);
    }

    /**
     * Load a list of words from a text file. The resulting map is structured as: key = length of words, values = list of words with given length
     */
    private Map<Integer, List<String>> loadWordList() {
        String inputFileName = "groene_boekje.txt";
        Map<Integer, List<String>> result = new HashMap<>(MAX_WORD_LENGTH);

        // read all words from the input file and put them in the wordList
        try (BufferedReader input = new BufferedReader(new FileReader(inputFileName))) {
            String word;
            while ((word = input.readLine()) != null) {
                // create List and check if the Map wordList contains an entry with the key of the current word
                List<String> wordListOfLength = result.get(word.length());

                // if there was no entry in the HashMap with that length, create it and add the current word
                if (wordListOfLength == null) {
                    wordListOfLength = new ArrayList<>(word.length());
                    wordListOfLength.add(word);
                    result.put(word.length(), wordListOfLength);
                } else {
                    wordListOfLength.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println(String.format("Error while loading input file into list of words: %s", e.getMessage()));
        }
        return result;
    }
}
