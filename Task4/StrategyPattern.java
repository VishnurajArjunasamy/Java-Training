package Task4;

import java.util.Scanner;

class ShowRoom {
	Mobile mobile;

	public ShowRoom(Mobile mobile) {
		this.mobile = mobile;
		mobile.dispaly();
		mobile.camera();
	}
}

abstract class Mobile {
	abstract void dispaly();

	abstract void camera();
}

class Redmi extends Mobile {
	public Redmi() {
		System.out.println("Redmi mobile");
	}

	void dispaly() {
		System.out.println("AMOLED display");
	}

	void camera() {
		System.out.println("Sony IMX766 OIS sensor");
	}
}

class Apple extends Mobile {
	public Apple() {
		System.out.println("Apple mobile");
	}

	void dispaly() {
		System.out.println("HDR dispaly");
	}

	void camera() {
		System.out.println("Sony cmaera sensor");
	}
}

class Samsung extends Mobile {
	public Samsung() {
		System.out.println("Samsung mobile");
	}

	void dispaly() {
		System.out.println("OLED display");
	}

	void camera() {
		System.out.println("ISOCELL HP2");
	}
}

public class StrategyPattern {
	public static void main(String[] args) throws Exception {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter brand name:");
		Mobile mobile = (Mobile) Class.forName(inp.next()).getConstructor().newInstance();
		ShowRoom showRoom = new ShowRoom(mobile);

	}
}

/*
 *  If else functionality will be removed using this pattern
 *  get  a class name form user and pass the  created object to the ShowRoom constructor
 *  Now ShowRoom constructor can use the passed object ,which achieves if else functionality
 */
