import java.util.Random;

public class Car extends Vehicle {

	public Car(int direction, Intersection[][] city) {
		super(direction, city);

		Random random = new Random();
	
		int min = 200;
		int max = 500;

		this.speed = random.nextInt(max) + min;
		this.size = 1;
		int rows = city[0].length; // 20 rows
		int columns = city.length; // 20 columns

		// CARS TRAVELLING NORTH TO SOUTH
		if (direction == 0) {
			symbol = "o";
			x = random.nextInt(columns);
			y = 0;
			lastPosition = this.city[x][rows-1];

		// CARS TRAVELLING WEST TO EAST
		} else if (direction == 1) {
			symbol = "-";
			x = 0;
			y = random.nextInt(rows);
			lastPosition = this.city[columns-1][y];
		}
		this.position = this.city[x][y];
		this.prePosition = position;
	}

	public void move() {

		if (direction == 0) {
			{
			prePosition = city[x][y];
			position = city[x][y++];
			}
		} else if (direction == 1) {
			prePosition = city[x][y];
			position = city[x++][y];
		}
	}
	

	public void run() {

		// 1. get into the position
		// 2. move to the next position if it is free
		// HOW?
		// - find the next position
		// - if it is free, fill that position & leave the last position 
		// - OR leave position and set new position to next position
		// - if NOT FREE, get into new position DONT leave current position
		// WAIT until it is free, then leave last position and fill new position

		
		while (position != lastPosition) {
			position.fillPosition(this);
			prePosition.leavePosition();	
			move();
		}
		lastPosition.fillPosition(this);
		lastPosition.leavePosition();
		}
	
}

	



