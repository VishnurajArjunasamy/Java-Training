package task2;

import java.util.Scanner;

class CustomException extends Exception {

	public CustomException(String message) {
		super(message);
	}
}

class AgeValidation{
	public void checkAge(int age) throws CustomException{
		if(age<18) {
			throw new CustomException("Not a valid Age");
		}
		else {
			System.out.println("Eligible for voting");
		}
	}
	
}

public class OwnException {
	
	public static void main(String[] args)  {
		AgeValidation val = new AgeValidation();
		Scanner inp  = new Scanner(System.in);
		try {
			val.checkAge(17);
		}
		catch(CustomException c) {
			c.printStackTrace();
			System.out.println("Enter a valid age");
		}
	}
}
