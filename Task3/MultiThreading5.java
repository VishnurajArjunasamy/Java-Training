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

/*
 * It throws IllegalThreadStateException as the state of the thread 
 * changed to Runnable from New ,We cannot start Runnable state thread 
 * again,new state is only possible for thread start.
 */
