package Task3;
class Printer {
	synchronized public void display(String s) {
		System.out.print(s);
	}
}

public class MultiThreading2 {
	public static void main(String[] args) throws InterruptedException {
		Printer pr = new Printer();
		
		Thread tOne = new Thread() {
			public void run() {
				pr.display("[");
			}
		};
		
		Thread tTwo = new Thread() {
			public void run() {
				pr.display("------");
			}
		};
		
		Thread tThree = new Thread() {
			public void run() {
				pr.display("Message");
			}
		};
		
		Thread tFour = new Thread() {
			public void run() {
				pr.display("------");
			}
		};
		
		Thread tFive = new Thread() {
			public void run() {
				pr.display("]");
			}
		};


		tOne.start();
		tOne.join();
		
		tTwo.start();


		tThree.start();

		
		tFour.start();

		
		tFive.start();

	}
}
