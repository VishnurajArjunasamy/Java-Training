package Task4;

class Singleton{
	private static Singleton singleObj=null;
	private Singleton() {
		
	}
	
	synchronized static Singleton createObj() {
		if(singleObj==null) {
			singleObj = new Singleton();
		}
		return singleObj;
	}
	
}

public class SingleltonPattern {
	public static void main(String[] args) {
		
		Thread t1 = new Thread() {
			public void run() {
				Singleton singleton= Singleton.createObj();
				System.out.println(singleton);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				Singleton singleton= Singleton.createObj();
				System.out.println(singleton);
			}
		};
		
		t1.start();
		t2.start();
	}
}
