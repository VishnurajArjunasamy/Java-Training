package task7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class IOStream8 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferReader = null;
		PrintWriter printWriter = null;

		try {
			bufferReader = new BufferedReader(new FileReader("Task7/src/readfile.txt"));
			printWriter = new PrintWriter(new FileWriter("Task7/src/writefile.txt"));

			String line;
			while ((line = bufferReader.readLine()) != null) {
				printWriter.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferReader != null) {
				bufferReader.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
