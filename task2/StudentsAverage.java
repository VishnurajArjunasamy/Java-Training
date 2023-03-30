package task2;

import java.util.Scanner;

class Average{
	int studentCount=10;
	int mark;
	int sum;
	int average;
	public void avgCalc() {
		Scanner inp=new Scanner(System.in);
		for(int i=1;i<=studentCount;i++) {
			System.out.println("Enter student "+i+" mark");
			try {
				mark=Integer.parseInt(inp.next());
			}
			catch(NumberFormatException n) {
				i--;
				System.out.println("Enter valid integer only");
			}
			finally {
				sum+=mark;
			}
		}
		System.out.println("Average is "+sum/studentCount);
	}
}

public class StudentsAverage {
	public static void main(String[] args) {
		Average avg = new Average();
		avg.avgCalc();
	}
}
