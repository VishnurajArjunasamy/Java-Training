package task7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class IOStream7 {
	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("/Users/vishnuraj/eclipse-workspace/Task7/src/readfile.txt"));
			outputStream = new PrintWriter(new FileWriter("/Users/vishnuraj/eclipse-workspace/Task7/src/writefile.txt"));

			int character;
			while ((character = inputStream.read()) != -1) {
				outputStream.println(character);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
