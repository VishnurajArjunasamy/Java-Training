package task2;

class ExceptionThrower {
	public void exceptionThrow() throws CustomException {
		throw new CustomException("Exception in method");
	}
}

public class ExceptionMethod {
	public static void main(String[] args){
		ExceptionThrower obj = new ExceptionThrower();
		try {
			obj.exceptionThrow();
		}
		finally {
			
		}
	}
}
