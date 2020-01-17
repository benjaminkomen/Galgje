package game.main;

/**
 * Main entry point of the game
 */
public class Game {

    private Player player;
    private Word word;
    private Gallows gallows;
    private String inputName;
    private String wordToGuess;
    private boolean guessed = false;

    public static void main(String[] args) {

        Game game = new Game();

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
                        createPlayer(game);
                        break;
                    case 2:
                        getScoreOfPlayer(game);
                        break;
                    case 3:
                        startGame(game);
                        playGame(game);
                        break;
                    case 9:
                        // Quit program
                        break;
                    default:
                        System.out.println("Invalid option selected.");
                }

            } catch (Exception ex) {
                System.out.println("An exception occurred: " + ex.getMessage());
            }
        } while (option != 9);
    }

    private static void createPlayer(Game game) {
        game.player = new Player();
        game.inputName = Helper.getString("Enter player name: ");
        game.player.setName(game.inputName);
        System.out.println("Created player " + game.player.getName());
    }

    private static void getScoreOfPlayer(Game game) {
        if (game.player == null) {
            System.out.println("Could not determine score of player, please create a player first.");
            return;
        }

        System.out.println("Score of player " + game.player.getName() + " is: " + game.player.getScore());
    }

    private static void startGame(Game game) {
        System.out.println("Starting game..");
        int inputLength = Helper.getInt("Enter length of word you want to guess (minimum: 2, maximum: 35): ");
        System.out.println("Obtaining word of length " + inputLength + " from dictionary.");

        // create Dictionary object to read text file with words and to get a word from that list
        Dictionary dict = new Dictionary();
        game.wordToGuess = dict.getRandomWordFromWordList(inputLength);

        // create Word object to handle the updating of the guessed word
        game.word = new Word(game.wordToGuess);
        System.out.println(game.word.getWordGuessed());

        // create a Gallows object to draw a gallows
        game.gallows = new Gallows();
    }

    private static void playGame(Game game) {
        while (!game.guessed) {
            String guessInput = Helper.getString("Guess a letter: ");
            String wordGuessed = game.word.guessLetter(guessInput);
            String guessedLetters = game.word.getGuessedLetters();
            System.out.println(wordGuessed);

            // call drawGallows function if guessed letter is not correct
            if (!game.word.isLetterCorrect()) {
                System.out.println(game.gallows.drawGallows());
            }

            if (game.gallows.isGameOver()) {
                System.out.println(String.format("Game over! The word was %s", game.word.getWordToGuess()));
                break;
            }

            System.out.println("You already used the following characters: " + guessedLetters);
            if (game.word.isGuessed()) {
                game.guessed = true;
                System.out.println("Good job! You found the correct word.");
            } else {
                game.guessed = false;
            }
        }
    }
}
