package task5;

public class BridgePattern {
	public static void main(String[] args) {
		Products product = new FoodItems(new Import() , new Distibute());
		product.doWork();
		System.out.println("............");
		Products product2 = new ElectronicTems(new Import() , new Distibute());
		product2.doWork();
	}
}

abstract class Products{
	Port importJob,distibuteJob;
	Products(Port importJob,Port distibuteJob) {
		this.importJob=importJob;
		this.distibuteJob=distibuteJob;
	}
	abstract void doWork();
}

class FoodItems extends Products{
	public FoodItems(Port importJob,Port distibuteJob) {
		super(importJob, distibuteJob);
	}
	@Override
	void doWork() {
		System.out.println("Food Items");
		importJob.transport();
		distibuteJob.transport();
	}
}

class ElectronicTems extends Products{
	public ElectronicTems(Port importJob,Port distibuteJob) {
		super(importJob, distibuteJob);
	}
	
	@Override
	void doWork() {
		System.out.println("Electronic items");
		importJob.transport();
		distibuteJob.transport();
	}
}

interface Port{
	void transport();
}

class Import implements Port{
	@Override
	public void transport() {
		System.out.println("Item imported");
		
	}
}

class Distibute implements Port{
	@Override
	public void transport() {
		System.out.println("Item distibuted");
		
	}
}

/*
 * The common functionality for each item (food and electronics) import and distribute has been made into a separate interface.
 * And create a bridge between two interface.
 */
