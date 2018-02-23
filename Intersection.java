import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Ensure that only one vehicle can sit in any intersection at one time

public class Intersection extends Thread {

	private Vehicle x;
	private boolean freeSquare = false;
	private ReentrantLock freeLock = new ReentrantLock();
	private Condition freeSpace = freeLock.newCondition();
	private String square;
	
	public Intersection() {
		square = "| ";
	}
	
	public void intoPosition(Vehicle x) {
		this.x = x;
		square = "|"+x.getSymbol();
	}
	
	public void spaceFree() {
		freeLock.lock();

		try {
			while (freeSquare == true) {
				freeSpace.await();
				x.move();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		freeSpace.signalAll();
		freeLock.unlock();
	}
		
	
//	
//	public void exitGrid() {
//		if (x.finishPosition)
//	}
	
	public String getSquare() {
		return square;
	}
	
	
}
