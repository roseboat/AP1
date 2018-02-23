import java.util.Random;

public class Car extends Vehicle {

	public Car(int direction, Intersection[][] city) {
		super(direction, city);

		Random ran = new Random();
		int min = 1000;
		int max = 4000;
		
		this.speed = ran.nextInt(max) + min;
		this.size = 1;
		int rows = city.length;
		int columns = city[0].length;
		
		// if the car is travelling north to south
		// x == rows
		// y == columns
		//  [row][column]
		if (direction == 0) {
			symbol = "o";
			x = ran.nextInt(rows);
			y = 0;
			finishPosition = this.city[rows-1][y];
			
			
		// if the car is travelling west to east	
		} else if (direction == 1) {
			symbol = "-";
			x = 0;		
			y = ran.nextInt(columns); 
			finishPosition = this.city[x][columns-1];
		}
		this.position = this.city[x][y];
	}
	

	public void run() {
		
	position.intoPosition(this);	
	while (nextSpaceFree()) {
		move();
	}
	
	
	}

	
	
	public void move() {

		if (direction == 0) {
			{
			position = city[x++][y];
			}
		} else if (direction == 1) {
			position = city[x][y++];
		}
	}
	
	
	public boolean nextSpaceFree() {
		if (direction == 0) {
			nextPosition = city[x++][y];}
		else if(direction == 1) {
			nextPosition = city[x][y++];
		}
	if(!nextPosition.getSquare().equals("| ")) {
		return false;
	}
	return true;
	}
	
	public boolean noMoreSpace() {
		
	}
	
	
	
	}



	



