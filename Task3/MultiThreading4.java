package Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Date;

class Clock {
	int hours,minutes,seconds;
	Date d = new Date();
	@SuppressWarnings("deprecation")
	Clock(){
		hours = d.getHours();
		minutes=d.getMinutes();
		seconds=d.getSeconds();
	}
	
	void calcTime() {
		while(true) {
			if(seconds==60) {
				seconds=0;
				minutes++;
			}
			
			if(minutes==60) {
				minutes=0;
				seconds=0;
				hours++;
			}
			
			if(hours==24) {
				minutes=0;
				seconds=0;
				hours=0;
			}
			System.out.println(hours+":"+minutes+":"+seconds);
				
			seconds++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreading4 {
	public static void main(String[] args) {
		Clock c = new Clock();
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			c.calcTime();
		});
		es.shutdown();
	}
}
