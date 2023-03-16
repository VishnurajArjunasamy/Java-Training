package task2;


public class IOExceptionClass {
	public  static void error(){
		throw new IOException();
	}
	
	public static void main(String[] args) {
		error();
	}
}
