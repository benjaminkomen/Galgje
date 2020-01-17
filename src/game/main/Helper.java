package game.main;

import java.util.Scanner;

/**
 * Some helper functionality for user interaction.
 */
public class Helper {

    private Helper() {
        // intentionally private, this class has only static members
    }

    // Create a Scanner object, to get keyboard input.
    private static Scanner scanner = new Scanner(System.in);

    // Get a String from the user.
    public static String getString(String promptMsg) {
        System.out.printf("%s", promptMsg);
        return scanner.next();
    }

    // Get an int from the user.
    public static int getInt(String promptMsg) {
        System.out.printf("%s", promptMsg);
        return scanner.nextInt();
    }
}
