package task2;

import java.util.Scanner;

class OutOfRangeException extends Exception{
	public OutOfRangeException(String msg) {
		super(msg);
	}
}

class Average2{
	int studentCount=10;
	int mark;
	int sum;
	int average;
	public void avgCalc() throws Exception{
		Scanner inp=new Scanner(System.in);
		for(int i=1;i<=studentCount;i++) {
			System.out.println("Enter student "+i+" mark");
			try {
				mark=Integer.parseInt(inp.next());
				if((mark<0) || (mark>100)) {
					throw new OutOfRangeException("Enter value between 0 and 100 only");
				}
				sum+=mark;
			}
			catch(OutOfRangeException o) {
				i--;
				System.out.println(o.getMessage());
			}
			catch(NumberFormatException n) {
				i--;
				System.out.println("Enter valid integer only");
			}
			finally {

			}
		}
		System.out.println("Average is "+sum/studentCount);
	}
}

public class StudentAverage2 {
	public static void main(String[] args) throws Exception{
		Average2 avg = new Average2();
		avg.avgCalc();
	}
}
