package task5;

import java.util.HashMap;
import java.util.Scanner;

public class FlyWeightPattern {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter species type");
			String speciesType  = sc.next();
			Species species = SpeciesCreator.speciesCreation(speciesType);
			System.out.println(species);
			System.out.println();
		}

	}
}


/*
 * Creator class ,which creates  a new object for newly coming class
 * If exists already return existing object;
 */
class SpeciesCreator {
	static Species s;
	static HashMap<String, Species> hMap = new HashMap<String, Species>();
	
	static Species speciesCreation(String speciesType) throws Exception{
		if(hMap.containsKey(speciesType)) {
			s=hMap.get(speciesType);
		}
		else {
			s=(Species)Class.forName(speciesType).newInstance();
			hMap.put(speciesType, s);
		}
		return s;
	}
}


//Each species category
abstract class Species {
	
}

class Human extends Species {
	public Human() {
		System.out.println("Human species created");
	}
}

class Monkey extends Species {
	public Monkey() {
		System.out.println("Monkey species created");
	}
}

class Wolf extends Species {
	public Wolf() {
		System.out.println("Wolf species created");
	}
}
