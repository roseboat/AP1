import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Ensure that only one vehicle can sit in any intersection at one time

public class Intersection extends Thread {

	private Vehicle vehicle;
	private boolean squareIsFree = true;
	private ReentrantLock squareLock = new ReentrantLock();
	private Condition squareCondition = squareLock.newCondition();
	private String square;
	private final String defaultSquare = "| ";
	
	public Intersection() {
		squareLock.lock();
		square = defaultSquare;
		squareLock.unlock();
	}
	
	public String getSquare() {
		return square;
	}
	
	// a method to GIVE the intersection a vehicle
	public void fillPosition(Vehicle vehicle) {
		
		squareLock.lock();

			try {
				while (squareIsFree == false) {
					squareCondition.await();
				}
				squareIsFree = false;
				this.vehicle = vehicle;
				square = "|" + vehicle.getSymbol();

			} catch (InterruptedException f) {
				f.printStackTrace();
			} finally {
				
				squareLock.unlock();
			}
		}
	
	

	// method to REMOVE a car from the intersection
	public void leavePosition() {
		
		try {
			Thread.sleep(vehicle.getSpeed());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		squareLock.lock();
		try {
			while (squareIsFree = false) {
				squareCondition.await();
			}
			square = defaultSquare;
			squareIsFree = true;
			squareCondition.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			squareLock.unlock();
		}
	}
	
	public boolean isSquareFree() {
		return squareIsFree;
	}
}
