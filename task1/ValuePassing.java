package task1;

class Hotel{
	 int availableRooms=0;
}

public class ValuePassing {
	static void primitiveCheck(double db) {
		db=15.2;
	}
	
	
	static void arrayCheck(int[] arr) {
		arr[0]=100;
	}
	
	static void objectCheck(Hotel h) {
		h.availableRooms=5;
		
	}

	public static void main(String[] args) {
		//primitive check
		double db=10.8;
		primitiveCheck(db);
		System.out.println(db);//call by value ,value remains same
		
		//checking array
		int arr[]= {30,10,40,60};
		arrayCheck(arr);
		System.out.println(arr[0]);//value will be changed in original array so call by reference
		
		//object check
		Hotel h =new Hotel();
		System.out.println("class vatriable before "+h.availableRooms);
		objectCheck(h);
		System.out.println("class vatriable after "+h.availableRooms);//original value changed 
		
	}
}
