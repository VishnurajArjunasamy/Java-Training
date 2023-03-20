package Task3;

import java.util.Scanner;

class CharacterCounter {
	int count;
 	void charCounter(char letter) {
 		try {
 			if(Character.isDigit(letter)) {
 				throw new Exception();
 			}
 			count++;
 		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
 		finally {
 			System.out.println(count);
 		}
	}
}

public class MultiThreading6 {
	public static void main(String[] args) {
		CharacterCounter charCount = new CharacterCounter();
		System.out.println("Enter a character:");
		Scanner inp = new Scanner(System.in);
		while(true) {
			charCount.charCounter(inp.next().charAt(0));
		}
	}
}

/*
 * From the input ,getting the char alone and passing to the char counter
 * If the input is char count get incremented and displayed
 * If not ,then an exception thrown
 */
