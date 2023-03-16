package task2;

import java.util.Scanner;

class Division{
	String numerator;int divisor;int temp;
	public void loopingDivision() {
		Scanner inp = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("Enter numerator");
				numerator=inp.next();
				System.out.println("Enter divisor");
				divisor=inp.nextInt();
				
				if(!(numerator.charAt(0)=='q'||numerator.charAt(0)=='Q')) {
					System.out.println(Integer.parseInt(numerator)/divisor);
				}
				else {
					break;
				}
			}catch(ArithmeticException ae){
				System.out.println("Divison by zero or poor Input data");
			}
			finally {

			}
		}
	}
}

public class LoopingDivision {
	public static void main(String[] args) {
		Division div = new Division();
		div.loopingDivision();
	}
}
