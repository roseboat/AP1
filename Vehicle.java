import java.util.Random;

public abstract class Vehicle extends Thread {

	protected int size;
	protected int speed;
	protected int direction;
	protected String symbol;
	protected int x;
	protected int y;
	protected boolean finished = false;
	protected Intersection position;
	protected Intersection nextPosition;
	protected Intersection finishPosition;
	protected Intersection[][] city;

	public Vehicle(int direction, Intersection[][] city) {

		this.direction = direction;
		this.city = city;

	}

	public abstract void move();
	public abstract void run();

	// Getters and Setters for the abstract vehicle class

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
}
