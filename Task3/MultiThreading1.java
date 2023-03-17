package Task3;

class EvenPrinter extends Thread {
	  public void run() {
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				System.out.println("even number "+i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class OddPrinter extends Thread {
	  public void run() {
		for(int i=1;i<=100;i++) {
			if(i%2!=0) {
				System.out.println("odd number "+i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}




public class MultiThreading1 {
	public static void main(String[] args) {
		EvenPrinter  evenT = new EvenPrinter();
		evenT.start();
		
		OddPrinter  oddT = new OddPrinter();
		oddT.start();
	}
}
