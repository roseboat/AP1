import java.util.ArrayList;

/**
 * Generator class that creates and executes Car threads, gets the times of each
 * vehicle and sends all time figures to a Statistics object.
 * 
 * @author RosaDowning
 */
public class Generator extends Thread {

	private String name;
	private Grid grid;
	private Vehicle vehicle;
	private Intersection[][] city;
	private int direction, speed, sleepTime;
	private ArrayList<Long> generatorTimes = new ArrayList<>();
	private ArrayList<Vehicle> vehicleArray = new ArrayList<>();

	/**
	 * Constructor which takes 
	 * @param name - the name given to the Generator
	 * @param cityArray - the Grid object made up of a 2D array of Intersection objects
	 * @param direction - the chosen direction, represented as a number
	 * @param speed - the chosen speed in milliseconds
	 * @param sleepTime - the chosen lag time between producing each vehicle
	 */
	public Generator(String name, Grid grid, int direction, int speed, int sleepTime) {
		this.grid = grid;
		this.city = grid.getCityArray();
		this.name = name;
		this.direction = direction;
		this.speed = speed;
		this.sleepTime = sleepTime;
	}

	/**
	 * Run method for a Generator object
	 */
	public void run() {

		// Loops while the grid is active
		while (grid.getStatus() == true) {

			vehicle = new Car(direction, city); // Creates a new car object
			vehicle.setSpeed(speed); // Sets its speed
			vehicle.start(); // Starts the car's thread

			try {
				Thread.sleep(sleepTime); // Sleeps for the specified lag time
			} catch (InterruptedException e) {
			} finally {
				vehicleArray.add(vehicle); // adds the vehicle to the vehicleArray
			}
		}

		// Method called to store all of the generator's vehicle times
		getTimes();

		// If a valid time has been stored, a new Statistics object is created to process
		// all times for printing.
		if (!generatorTimes.isEmpty()) {
			new Statistics(name, generatorTimes);
		}
	}

	/**
	 * Method loops through the vehicleArray and gets all the times taken by each
	 * vehicle, adding it to another ArrayList, generatorTimes.
	 */
	public void getTimes() {
		for (int i = 0; i < vehicleArray.size(); i++) {
			long time = vehicleArray.get(i).getTimeTaken();
			if (time != 0) { // we don't want any cars that didn't make it through the grid
			generatorTimes.add(time);
			}
		}
	}
	
}
