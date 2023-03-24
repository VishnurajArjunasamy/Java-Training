package task7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class IOStream9 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream("/Users/vishnuraj/eclipse-workspace/Task7/src/date.txt"))) {

			Date date = new Date();
			outputStream.writeObject(date);
			System.out.println("written to file");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (ObjectInputStream inputStream = new ObjectInputStream(
				new FileInputStream("/Users/vishnuraj/eclipse-workspace/Task7/src/date.txt"))) {

			Date date = (Date) inputStream.readObject();
			System.out.println("Object read from file " + date);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
