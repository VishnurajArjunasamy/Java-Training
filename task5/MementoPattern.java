package task5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MementoPattern {
	public static void main(String[] args) throws Exception {
		
		CheckPoint cp = new CheckPoint();
		System.out.println("Coins in the initial level->"+cp.coins);
		
		cp.coins=5;
		System.out.println("Coins after level 1->"+cp.coins);
		//saving in the dat file
		new WriteObj().writeObj(cp);
		
		cp.coins=20;
		System.out.println("Coins before reaching checkpoint->"+cp.coins);
		
		System.out.print("Revrting to previous coins quantity after player died->");
		cp=new ReadObj().readObj("Checkpoint.dat");
		System.out.println(cp.coins);
		
	}
}


class CheckPoint implements Serializable{
	int coins;
}

class WriteObj {
	public void writeObj(CheckPoint coins) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Checkpoint.dat"));
		oos.writeObject(coins);;

	}
}

class ReadObj{
	public CheckPoint readObj(String fileName) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		return (CheckPoint) ois.readObject();
	}
}

/*
 * saves the current state of the object in a file
 * If the player died half way reverting the objects state to initial state before it got saved.
 */
