package Task4;

class Singleton {
	private static Singleton singleObj = null;

	// making the constructor private to prevent obj creation from outside
	private Singleton() {

	}

	// create obj will let only one obj creation
	synchronized static Singleton createObj() {
		if (singleObj == null) {
			singleObj = new Singleton();
		}
		return singleObj;
	}

}

public class SingleltonPattern {
	public static void main(String[] args) {

		// creating two threads to access createObj
		Thread t1 = new Thread() {
			public void run() {
				Singleton singleton = Singleton.createObj();
				System.out.println(singleton);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				Singleton singleton = Singleton.createObj();
				System.out.println(singleton);
			}
		};

		t1.start();
		t2.start();
	}
}
