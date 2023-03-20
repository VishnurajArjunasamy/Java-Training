package Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;
import java.util.Date;

class Clock {
	int hours,minutes,seconds;
	LocalDateTime d = LocalDateTime.now();

	Clock(){
		hours = d.getHour();
		minutes=d.getMinute();
		seconds=d.getSecond();
	}
	
	void calcTime() {
		while(true) {
			if(seconds==60) {
				seconds=0;
				minutes++;
			}
			
			if(minutes==60) {
				minutes=0;
				hours++;
			}
			
			if(hours==24) {
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
