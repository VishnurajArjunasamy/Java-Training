package task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class LorryArrival {
	public static void main(String[] args) throws IOException {
		int distance,speed;
		String departDate;
		LocalDate date;
		LocalTime time;
		LocalDateTime dateTime;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		Scanner inp = new Scanner(System.in);
		
		try {
			System.out.println("Enter ditance to be covered->");
			distance=inp.nextInt();
			
			System.out.println("Enter speed of the vechile->");
			speed=inp.nextInt();
			
			System.out.println("Enter the date of the lorry deporting->");
			date=LocalDate.parse(inp.next());//2023-03-23

			System.out.println("Enter the time of the lorry deporting->");
			time=LocalTime.parse(inp.next());//02:01:50.63
			
			dateTime=LocalDateTime.parse(date+"T"+time);

			Destination des = new Destination(dateTime);
			des.findArrivalTime(distance, speed);
		}
		catch (java.time.format.DateTimeParseException de) {
			System.out.println();
			System.out.println("Not a valid date and time format!!");
			System.out.println("Enter the date and time in format yy-mm-dd and hh:mm:ss only!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			inp.close();	
		}
	}
}

class Destination {
	int actualHours,remainingHours, holidayCount,dayCount, currentDayDuration;
	
	LocalDateTime d = LocalDateTime.now();
	Calendar calander = Calendar.getInstance();
	DayOfWeek day = d.getDayOfWeek();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
   
	public Destination(LocalDateTime d) {
		this.d=d;
	}


	//function for finding holidays
	boolean isHoliday(LocalDateTime d) {
		return (d.getDayOfWeek() == DayOfWeek.SUNDAY 
				|| (d.getDayOfWeek() == DayOfWeek.SATURDAY )&&(d.getDayOfMonth()>7&&d.getDayOfMonth()<=15)
				|| (d.getMonthValue() == 1 && d.getDayOfMonth() == 26)
				|| (d.getMonthValue() == 8 && d.getDayOfMonth() == 15))
				|| (d.getMonthValue() == 1 && d.getDayOfMonth() == 1);
	}

	void findArrivalTime(int distance, int speed) {
		actualHours = distance / speed;
		remainingHours = actualHours % 8;
		
		// get remaining hours in current day
		currentDayDuration = 24 - d.getHour() - 1;
		
		System.out.println(currentDayDuration);
				
		//if remaining hour is less than 8 start the vehicle from next day
		//else start from today itself 
		if (currentDayDuration < 8) {
			System.out.println("Starting Date " + d.plusDays(1).format(format)); 
		}
		else {
			System.out.println("Starting Date " + d.format(format)); 
		}
		
		while ((actualHours / 8 > dayCount)) {
			d = d.plusDays(1);

			if (isHoliday(d)) {
				holidayCount++; 
			}

			dayCount++;
		}
		
		//adding the holiday count and remaining hours to the date
		d=d.plusDays(holidayCount).plusHours(remainingHours);
		
		System.out.println("Reaching Date " + d.format(format));
	}
}
