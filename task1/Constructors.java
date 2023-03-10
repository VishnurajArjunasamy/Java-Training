package task1;

class A{
	A(){
		System.out.println("A");
	}
}

class B{
	B(){
		System.out.println("B");
	}
}

class C extends A{
	B cobj = new B(); 
}

public class Constructors {
	public static void main(String[] args) {
		C obj = new C();
	}

}
