package task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOStream6 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("Task7/src/task7/renamed.txt"));
		
		String line;

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
