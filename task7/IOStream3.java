package task7;

import java.io.File;

public class IOStream3 {
	public static void main(String[] args) {
		try {
			File file = new File("/Users/vishnuraj/eclipse-workspace/Task7/src/task7/sample.txt");

			// renaming a file
			File renameFile = new File("/Users/vishnuraj/eclipse-workspace/Task7/src/task7/renamed.txt");
			file.renameTo(renameFile);

			// finding file size
			System.out.println(renameFile.length() + " bytes");

			// deleting the file
			file.delete();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
