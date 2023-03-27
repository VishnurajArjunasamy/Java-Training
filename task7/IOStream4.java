package task7;

import java.io.File;

public class IOStream4 {
	public static void main(String[] args) {
		try {
			File dirctory = new File(args[0]);
			String[] files = dirctory.list();

			for (String file : files) {
				System.out.println(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
