import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents a single Intersection. Only one vehicle can be present
 * in an intersection at one time.
 * 
 * @author RosaDowning
 *
 */

public class Intersection extends Thread {

	private String square;
	private boolean hasVehicle;
	private final String defaultSquare = "| ";
	private ReentrantLock squareLock;
	private Condition squareCondition;

	/**
	 * The default constructor of an Intersection object. Sets the intersection to
	 * "| ".
	 */
	public Intersection() {
		squareLock = new ReentrantLock();
		squareCondition = squareLock.newCondition();
		square = defaultSquare;
		hasVehicle = false;
	}

	/**
	 * Getter for an Intersection object
	 * 
	 * @return the square and its contents, either with the defaultSquare "| " or a
	 *         square with a vehicle inside it
	 */
	public String getSquare() {
		return square;
	}

	/**
	 * A method to GIVE the intersection a vehicle. Only one vehicle can fill an
	 * intersection at one time and so locks and conditions are used to ensure this.
	 * 
	 * @param vehicle
	 */

	public void fillPosition(Vehicle vehicle) {

		try {
			squareLock.lock(); // a thread acquires the lock

			while (hasVehicle == true) { // if the lock already has a vehicle inside, it waits until it is signaled or
											// interrupted.
				squareCondition.await();
			}
			this.hasVehicle = true; // if it does not have a vehicle, it enters and sets hasVehicle to true
			square = "|" + vehicle.getSymbol(); // sets the square to "|" plus the car's symbol, showing that a car is
												// present inside the square
		} catch (InterruptedException f) {
			f.printStackTrace();
		} finally {
			squareLock.unlock(); // unlocks the lock
		}
	}

	/**
	 * Method to REMOVE a vehicle from the intersection. Sets the square back to the
	 * default square, hasVehicle to false and signals all waiting threads that they
	 * can now try to enter the intersection.
	 */
	public void leavePosition() {

		squareLock.lock();
		square = defaultSquare;
		hasVehicle = false;
		squareCondition.signalAll();
		squareLock.unlock();
	}
}
