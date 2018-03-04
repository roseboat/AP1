import java.util.Random;

/**
 * Abstract class representing a Vehicle object. This class allows for different
 * kinds of vehicles to extend from it.
 * 
 * @author RosaDowning
 */

public abstract class Vehicle extends Thread {

	protected long timeTaken;
	protected int size, speed, direction, x, y;
	protected Random random = new Random();
	protected String symbol;
	protected Intersection position, prePosition, lastPosition;
	protected Intersection[][] city;

	/**
	 * Default constructor for a vehicle object. Gives a vehicle a random speed.
	 * @param direction represented by an integer
	 * @param city - a 2D array of Intersection objects
	 */
	public Vehicle(int direction, Intersection[][] city) {

		this.direction = direction;
		this.city = city;
		
		int min = 100;
		int max = 500;
		this.speed = random.nextInt(max) + min;
		
	}

	/**
	 * Abstract method which will enable a vehicle to move positions. I have made
	 * this method abstract to account for the different ways in which different
	 * kinds of vehicles may move (for example, if the vehicle takes up more that 1
	 * square in the grid it will need to move in a different way).
	 */
	public abstract void move();
	
	/**
	 * Abstract run method for a vehicle thread. Like the method above, I have made
	 * this method abstract to ensure that this class is extendible.
	 */
	public abstract void run();

	// Getters and setters for the abstract vehicle class
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Intersection getPostion() {
		return position;
	}

	public void setPosition(int a, int b) {
		this.x = a;
		this.y = b;
		position = this.city[x][y];
	}
	
	public long getTimeTaken() {
		return timeTaken;
	}
}
