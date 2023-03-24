package task7;

public class IOStream2 {
	public static void main(String[] args) {
		String str = "Hello there  fellas";

		String[] wordsArray = str.split("\\s+");
		System.out.println(wordsArray.length);
	}
}

/**
 * the split method splits the string based on the regex given
 * \\s for space and \\s+ for multiple spaces
 * and array lenght gives the no of words count
 */
