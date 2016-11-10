package game.main;

import java.util.Scanner;

/*
 * @description: this is a helper class with some functionality for user interaction
 * @author: Benjamin Komen
 */
public class Helper {
	// Create a Scanner object, to get keyboard input.
	private static Scanner scanner = new Scanner(System.in);

	// Get a String from the user.
	public static String getString(String promptMsg) {
		System.out.printf("%s", promptMsg);
		return scanner.next();
	}

	// Get a double from the user.
	public static double getDouble(String promptMsg) {
		System.out.printf("%s", promptMsg);
		return scanner.nextDouble();
	}

	// Get an int from the user.
	public static int getInt(String promptMsg) {
		System.out.printf("%s", promptMsg);
		return scanner.nextInt();
	}
}
