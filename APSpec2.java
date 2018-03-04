
/**
 * Main method for Specification 2. Creates a grid object and then starts 4
 * different car generators, all going different directions and with different
 * speeds and lag times.
 * 
 * @author RosaDowning
 */

public class APSpec2 {
	public static void main(String[] args) {

		int rows = 10;
		int columns = 20;
		int counter = 20;

		// Sets up a Grid object and starts its thread
		Grid glasgowCity = new Grid(rows, columns, counter);
		glasgowCity.start();

		// Four generator objects which create different kinds of traffic
		Generator w = new Generator("North to South Cars", glasgowCity, 0, 200, 200);
		w.start();
		Generator x = new Generator("West to East Cars", glasgowCity, 1, 200, 200);
		x.start();
		Generator y = new Generator("South to North Cars", glasgowCity, 2, 200, 200);
		y.start();
		Generator z = new Generator("East to West Cars", glasgowCity, 3, 200, 200);
		z.start();

		try {
			glasgowCity.join(); // Waits for the thread to die which will cause the generator threads to die
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}