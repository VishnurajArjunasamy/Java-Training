package Task4;

public class CommandPattern {
	public static void main(String[] args) {
		Controller ctrl = new Controller();
		
		SpeedLimit speedLimit = new SpeedLimit();
		SoundSystem soundSystem = new SoundSystem();
		
		ctrl.setCommand(1, new TrafficAreaCommand(speedLimit,soundSystem));
		ctrl.setCommand(2, new HighWayCommand(speedLimit,soundSystem));
		ctrl.setCommand(3, new OffRoadCommand(speedLimit,soundSystem));
		
		ctrl.executeCommand(2);
		
	}
}


/*
 * Controller which does all the job of client ,based on the input
 * Initially assigning a command and executing the command if client requested
 */

class Controller{
	Command C[] = new Command[4];
	
	public Controller() {
		for(int i = 0; i<C.length; i++) {
			C[i] = new Command() {
				@Override
				void execute() {
					System.out.println("Vehicle is idle...");
				}};
		}
	}
	
	public void setCommand(int idx,Command command) {
		C[idx] = command;
	}
	
	public void executeCommand(int idx) {
		C[idx].execute();
	}
}

/*
 * listing all type of commands 
 */
abstract class Command {
	SpeedLimit speedLimit;SoundSystem soundSystem;
	abstract void execute();
}

class TrafficAreaCommand extends Command {
	public TrafficAreaCommand(SpeedLimit speedLimit,SoundSystem soundSystem) {
		this.speedLimit=speedLimit;
		this.soundSystem=soundSystem;
	}
	void execute() {
		System.out.println("Driving in a Heavy Traffic Area");
		speedLimit.LowSpeed();
		soundSystem.LowVolume();
	}
}

class HighWayCommand extends Command {
	public HighWayCommand(SpeedLimit speedLimit,SoundSystem soundSystem) {
		this.speedLimit=speedLimit;
		this.soundSystem=soundSystem;
	}
	void execute() {
		System.out.println("Driving in a Highway Area");
		speedLimit.HighSpeed();
		soundSystem.HighVolume();
	}
}

class OffRoadCommand extends Command {
	public OffRoadCommand(SpeedLimit speedLimit,SoundSystem soundSystem) {
		this.speedLimit=speedLimit;
		this.soundSystem=soundSystem;
	}
	void execute() {
		System.out.println("Driving in a off road Area");
		speedLimit.MediumSpeed();
		soundSystem.MedimVolume();
	}
}

//set of micro commands
class SpeedLimit {
	void HighSpeed() {
		System.out.println("Maximum speed");
	}
	void MediumSpeed() {
		System.out.println("Medium speed");
	}
	void LowSpeed() {
		System.out.println("Low speed");
	}
}

class SoundSystem {
	void HighVolume() {
		System.out.println("High Volume");
	}
	void MedimVolume() {
		System.out.println("Medium Volume");
	}
	void LowVolume() {
		System.out.println("Low volume");
	}
}


/*
 * client tells the Controller  to do the operation based on the input he has given 
 * Like in heavy traffic area maintain slow speed
 * Or in Highway it can go in speed above average
 * Or maintain a moderate speed.
 */
