package Task4;

import java.util.Scanner;

//Client Specifying what type of object he wants to the factory
public class FactoryPattern {
	public static void main(String[] args) {
		ShoeFactory factory = new ShoeFactory();
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the type of sneaker");
		Sneakers shoe = null;
		try {
			shoe = factory.createSneaker(inp.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		shoe.sneakerType();
		inp.close();
	}
}

//factory for creating user specific object
class ShoeFactory {
	Sneakers sneaker;

	public Sneakers createSneaker(String type) throws Exception {
		sneaker = (Sneakers) Class.forName(type).getConstructor().newInstance();
		return sneaker;
	}
}

abstract class Sneakers {
	void sneakerType() {
	};
}

class RunningShoe extends Sneakers {
	@Override
	void sneakerType() {
		System.out.println("Running shoes");
	}
}

class Jordan extends Sneakers {
	@Override
	void sneakerType() {
		System.out.println("Jordan shoes");
	}
}

class GymShoe extends Sneakers {
	@Override
	void sneakerType() {
		System.out.println("Gym training shoes");
	}
}

/*
 * Client only asks what type of shoe he wants Factory creates the shoe without
 * showing the implementation to the client
 */
