package Task4;

/*
 * Driver class which calls the acccept function of vechile Item Class.
 */

public class VisitorPattern {
	public static void main(String[] args) {
		VechileItem car = new Car("Honda City", 11);
		System.out.println(
				"On road Price of " + car.getModel() + " is " + car.accept(new WorkShopVisitorImp()) + " lakhs");

		VechileItem bike = new Bike("GT 650", 3);
		System.out.println(
				"On road Price of " + bike.getModel() + " is " + bike.accept(new WorkShopVisitorImp()) + " lakhs");
	}
}

/*
 * Visitor interface which accepts Vechile Item type object and perform
 * operations on them
 */

interface WorkShopVisitor {
	float visit(Car car);

	float visit(Bike bike);
}

class WorkShopVisitorImp implements WorkShopVisitor {
	@Override
	public float visit(Bike bike) {
		float cost = bike.getPrice() + 0.3f;
		return cost;
	}

	@Override
	public float visit(Car car) {
		float cost = car.getPrice() + 0.5f;
		return cost;
	}
}

/*
 * Different classes of VechicleItem interface ,each with a accept function
 * which will do the operation on the vehicle objects by passing it to visitor
 * function
 */

interface VechileItem {

	float accept(WorkShopVisitor visitor);

	String getModel();
}

class Car implements VechileItem {
	private String model;
	private int price;

	public Car(String model, int price) {
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	@Override
	public float accept(WorkShopVisitor visitor) {

		return visitor.visit(this);
	}
}

class Bike implements VechileItem {
	private String model;
	private int price;

	public Bike(String model, int price) {
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	@Override
	public float accept(WorkShopVisitor visitor) {

		return visitor.visit(this);
	}
}
