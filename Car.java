/**
 * Car class which extends from Vehicle. This class sets up its own run and move
 * methods particular to a car object, as well as elaborating on the Vehicle's
 * default constructor.
 * 
 * @author RosaDowning
 *
 */

public class Car extends Vehicle {

	/**
	 * Constructor for a car object. Sets the car's size to 1 as it only takes up
	 * one Intersection object.
	 * 
	 * @param direction,represented by an integer
	 * @param city, a 2D array of Intersection objects
	 */
	public Car(int direction, Intersection[][] city) {
		super(direction, city);
		
		this.size = 1; // a car will only take up one intersection
		setDirection();
	}

	/**
	 * setDirection method sets the symbol of the car depending on its direction. It
	 * then sets the car's starting x and y coordinates and then sets what the car's
	 * last position on the grid will be.
	 */
	public void setDirection() {
		
		int rows = city[0].length; // the total number of rows in the grid
		int columns = city.length; // the total number of columns in the grid
		int 	rowSection = (rows / 2) - 1; // splits the rows in half & takes away 1 to find where the half point in the
		// array is
		int columnSection = (columns / 2) - 1; // does the same with columns

		// X = columns
		// Y = rows

		// CARS TRAVELLING NORTH TO SOUTH ON LEFT OF GRID
		if (direction == 0) {
			symbol = "o";
			x = random.nextInt(columnSection);
			y = 0;
			lastPosition = this.city[x][rows - 1];

		// CARS TRAVELLING WEST TO EAST AT TOP OF GRID
		} else if (direction == 1) {
			symbol = "-";
			x = 0;
			y = random.nextInt(rowSection);
			lastPosition = this.city[columns - 1][y];

		// CARS TRAVELLING SOUTH TO NORTH ON RIGHT OF GRID
		} else if (direction == 2) {
			symbol = "o";
			x = columns - (random.nextInt(columnSection) + 1); // sets the starting column to be somewhere on the right
																// hand side of the grid
			y = rows - 1;
			lastPosition = this.city[x][0];

			// CARS TRAVELLING EAST TO WEST AT BOTTOM OF GRID
		} else if (direction == 3) {
			symbol = "-";
			x = columns - 1;
			y = rows - (random.nextInt(rowSection) + 1);
			lastPosition = this.city[0][y];
		}
		this.position = this.city[x][y]; // sets the starting position in the city array
	}
	
	/**
	 * Move method is called by the car's run method. It sets a variable prePosition
	 * to be whatever the current position of the car is. It then increments or
	 * decrements the car's position depending on it's direction.
	 */
	public void move() {

		prePosition = this.city[x][y];

		if (direction == 0) {
			position = this.city[x][++y];
		} else if (direction == 1) {
			position = this.city[++x][y];
		} else if (direction == 2) {
			position = this.city[x][--y];
		} else if (direction == 3) {
			position = this.city[--x][y];
		}
	}
	
	/**
	 * The car's run method is responsible for the movement and action of a car
	 * object. It ensures that a car does not leave its current intersection until it has
	 * successfully filled the position of the next intersection.
	 */
	public void run() {

		long startTime = System.currentTimeMillis(); // Starts recording the car's time
		
		try {
			Thread.sleep(speed);
			position.fillPosition(this); // fills its starting position in the grid
			while (position != lastPosition) {
				move(); // increments its position and sets the prePosition variable
				Thread.sleep(speed);
				position.fillPosition(this); // fill the next position
				prePosition.leavePosition(); // once it has filled the next position it leaves its previous position
			}
			Thread.sleep(speed);
			position.leavePosition(); // leaves its last position in the grid
			long endTime = System.currentTimeMillis(); // Records the end time
			this.timeTaken = endTime - startTime; // gets the total time taken

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


