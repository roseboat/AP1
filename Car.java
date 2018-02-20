
public class Car extends Vehicle {

	
	
	public Car(int direction) {
		super(direction);
		this.size = 1;
		
		if (direction == 0) {
			symbol = "o";
		} else if (direction == 1) {
			symbol = "-";
		}
		
		// put speed stuff here

	}
}
