package task1;

class Singleton{
	private static Singleton mainObj=null;
	int data;
	
	private Singleton() {
		data=30;
	}
	
	public static Singleton createObj() {
		if(mainObj==null)
			 mainObj = new Singleton();
		return mainObj;
	}
}

public class SingletonClass {

	public static void main(String[] args) {
		
		Singleton objOne=Singleton.createObj();
		
		objOne.data=50;
		System.out.println(objOne);
		
		Singleton objTwo=Singleton.createObj();
		objTwo.data=400;
		System.out.println(objTwo);
		
		System.out.println(objTwo.data);
	}

}
