package view.console;

import java.util.Scanner;

public class Utilities {

	private static Scanner scanner;

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.flush();
	}

	public static void pause() {
		scanner = new Scanner(System.in);
		System.out.println("Press enter to continue...");
		scanner.nextLine();
	}

	public static int getIntegerInput(String prompt) {
		while (true) {
			try {
				scanner = new Scanner(System.in);
				System.out.println(prompt);
				int input = scanner.nextInt();
				return input;
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}

	public static void closeScanner() {
		scanner.close();
	}

	public static void pauseAndClear() {
		pause();
		clearScreen();
	}

	public static String getStringInput(String prompt) {
		scanner = new Scanner(System.in);
		System.out.println(prompt);
		String input = scanner.nextLine();
		return input;
	}

	public static void pause(String string) {
		scanner = new Scanner(System.in);
		System.out.println(string);
		scanner.nextLine();

	}
}
