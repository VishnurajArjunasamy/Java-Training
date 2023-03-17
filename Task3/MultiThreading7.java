package Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counting {
	int count=1;
	synchronized public void counter() {
		System.out.println(Thread.currentThread());
		for(;count<=100;count++) {
			System.out.println(count);
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count%10==0) {
				System.out.println("I will print for every ten seconds");
			}
			
		}
		
	}
	
}

public class MultiThreading7 {
	public static void main(String[] args) {
		Counting c = new Counting();
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		es.execute(()->{
			c.counter();
		});
		es.shutdown();
	}
}
