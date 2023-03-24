package task7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStream5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try (InputStream in = new FileInputStream("/Users/vishnuraj/eclipse-workspace/Task7/src/user1.png");
				OutputStream out = new FileOutputStream("/Users/vishnuraj/eclipse-workspace/Task7/src/profile.png")) {
			
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				
			}
			
			System.out.println("Image copied");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}