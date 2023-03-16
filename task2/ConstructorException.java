package task2;

class Super {
	Super(){
		int c = 5/0;
	}
}

class Child extends Super {
	Child(){
		try {
			 super();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("hhh");
		}
	}
}


public class ConstructorException {
	public static void main(String[] args) throws Exception {
		new Child();


	}
}
