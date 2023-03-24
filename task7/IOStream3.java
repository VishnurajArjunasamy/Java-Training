package task7;

import java.io.File;

public class IOStream3 {
	public static void main(String[] args) {
		try {
			File file = new File("./sample.txt");
			// renaming a file
			File renamedFile = new File("./renamed.txt");
			file.renameTo(renamedFile);
			// finding file size
			System.out.println(renamedFile.length() + " bytes");
			// deleting the file
			renamedFile.delete();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
