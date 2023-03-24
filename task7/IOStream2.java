package task7;

/**
 * the split method splits the string based on the regex given
 * \\s for space and \\s+ for multiple spaces
 * and array length gives the no of words count
 */

public class IOStream2 {
	public static void main(String[] args) {
		String str = "Hello";
		String[] words = str.split("\\s+");
		System.out.println(words.length);
	}
}


