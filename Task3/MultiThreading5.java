package Task3;


class DemoThread {
	
}

public class MultiThreading5 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Thread one created");
			}
		};
		
		t1.start();
		t1.start();
		
	}
}
