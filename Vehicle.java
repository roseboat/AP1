import java.util.Random;

public abstract class Vehicle extends Thread {

	protected int size;
	protected int speed;
	protected int direction;
	protected String symbol;
	protected int startSquare;
	protected int endSquare;
	protected int currentSquare;
	
	
	
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
	
	public abstract void defineDirection();
	public abstract void run();
	
}
