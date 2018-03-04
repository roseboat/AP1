import java.util.Random;

/**
 * Main method for Specification 1. Sets up a grid object and while it is
 * active, creates car objects.
 * 
 * @author RosaDowning
 *
 */
public class APSpec1 extends Thread {

	public static void main(String[] args) {

		int rows = 10;
		int columns = 20;
		int counter = 2000;
		int maxDirection = 4;
		Random ran = new Random();

		// Sets up a Grid object and starts its thread
		Grid glasgowCity = new Grid(rows, columns, counter);
		glasgowCity.start();

		// While the grid object is active, produce new car objects
		while (glasgowCity.getStatus() == true) {
			
			// Creates new car objects, giving them a random integer (0, 1, 2 or 3)
			// corresponding to their direction & the array of Intersection objects

			Car cityCar = new Car(ran.nextInt(maxDirection), glasgowCity.getCityArray());
			cityCar.start(); // starts the car thread
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// For testing, remove the car generator above and uncomment the below.
		// Illustrates a car moving towards a stationary car and waiting in place.

//		 Car a = new Car(1, glasgowCity.getCityArray());
//		 a.setPosition(5, 5);
//		 a.position.fillPosition(a);
//		
//		 Car b = new Car(0, glasgowCity.getCityArray());
//		 b.setPosition(5, 0);
//		 b.start();

	}
}
