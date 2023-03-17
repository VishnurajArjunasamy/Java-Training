package Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Inventory{
	int productQuantity;
	synchronized  public void addItem () {
		if(productQuantity==1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		productQuantity++;
		System.out.println(productQuantity);
		notify();
	}
	
	synchronized public void getItem () {
		if(productQuantity==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		productQuantity--;
		System.out.println(productQuantity);
		notify();
	}
	 
}

public class MultiThreading3 {
	public static void main(String[] args) {
		
		Inventory inv = new Inventory();
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			for(int i = 0;i < 5;i++) {
				inv.addItem();
			}
		
		});
		
		es.execute(()->{
			for(int i = 0;i < 5;i++) {
				inv.getItem();
			}
		});
		
		es.shutdown();
		
		System.out.println(inv.productQuantity);
	}
}
