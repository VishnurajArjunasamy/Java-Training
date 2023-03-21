package Task4;

/*
 * Client specifying the type of object to be created to the builder
 */
public class BuilderPattern {
	public static void main(String[] args) {
		CustomBuilder.CustomCar customCar = new CustomBuilder().
				setName("Porsche").
				setDoor(new SwanDoor()).
				setTyre(new AvendatorTyre()).
				setBody(new SportsBody()).
				setEngine(new VEngine(new EngineBody(), new Piston())).Bild();;
				
		System.out.println(customCar);
	}

	@Override
	public String toString() {
		return "BuilderPattern [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}

//a bulider for building custom car
class CustomBuilder{
	CustomCar customModel;
	String name;Door door;Tyre tyre;Body body;Engine engine;
	
	CustomBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	CustomBuilder setDoor(Door door) {
		this.door=door;
		return this;
	}
	
	CustomBuilder setTyre(Tyre tyre) {
		this.tyre=tyre;
		return this;
	}
	
	CustomBuilder setBody(Body body) {
		this.body=body;
		return this;
	}
	
	CustomBuilder setEngine(Engine engine) {
		this.engine=engine;
		return this;
	}
	
	CustomCar Bild() {
		return new CustomCar(name,door,tyre,body,engine);
	}
	
	//Custom car class inside builder
	static class CustomCar{
		Door door;Tyre tyre;Body body;Engine engine;String name;
		CustomCar(String name,Door door,Tyre tyre,Body body,Engine engine){
			this.name=name;
			this.door=door;
			this.tyre=tyre;
			this.body=body;
			this.engine=engine;
		}
		
		
		@Override
		public String toString() {
			String descp = String.format("Bulit a custom %s with %s, %s, %s with a %s", name,door,tyre,body,engine);
			return descp;
		}
	}
		
}


//Door types
abstract class Door {

}

class SwanDoor extends Door{
	@Override
	public String toString() {
		return "Swan Doors";
	}
}

class ButterflyDoor extends Door{
	@Override
	public String toString() {
		return "Butterfly Doors";
	}
}

//Tyre types
abstract class Tyre {
	
}

class AvendatorTyre extends Tyre{
	@Override
	public String toString() {
		return "Avendator tyres";
	}
}

//Car type
abstract class Body {
	
}

class LuxuryBody extends Body{
	@Override
	public String toString() {
		return "Luxury car type body";
	}
}

class SportsBody extends Body{
	@Override
	public String toString() {
		return "Sports car type body";
	}
}

//car engine type
abstract class Engine {
	
}

class VEngine extends Engine{
	public VEngine(EngineBody eBody, Piston piston) {
		
	}

	@Override
	public String toString() {
		return "V-Engine";
	}
}

class EightCylinderEngine extends Engine{
	public EightCylinderEngine(EngineBody eBody, Piston piston) {
		
	}

	@Override
	public String toString() {
		return "Eight Cylinder Engine";
	}
}


//Different components of a engine
class EngineBody{

}

class Piston{

}

