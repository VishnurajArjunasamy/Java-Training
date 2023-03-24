package task7;

import java.util.Scanner;

public class IOStream1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String character;
		int count = 0;

		while (true) {
			System.out.println("Enter a character");
			character = scanner.next();

			if (character.equalsIgnoreCase("CTRL+Z")) {
				break;
			}
			System.out.println("Count " + ++count);
		}
	}
}
