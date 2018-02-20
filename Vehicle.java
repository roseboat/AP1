import java.util.Random;

public abstract class Vehicle {

	protected int size;
	protected int speed;
	protected int direction; // 0 = North to South, 1 = East to West
	protected String symbol;
	
	
	public Vehicle(int direction) {
		this.direction = direction;
		
		Random ran = new Random();
		int min = 1000;
		int max = 4000;
		
		this.speed = ran.nextInt(max) + min;
	}

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
	
	public String toString() {
		return symbol;
	}
}
