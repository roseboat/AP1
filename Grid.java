
/**
 * Grid class represents the entire city grid which is made up of a 2D array of
 * Intersection objects. This class executes a thread which paints each
 * Intersection and its contents (whether or not it has a car inside) every 200
 * milliseconds, 2000 times.
 * 
 * @author RosaDowning
 */

public class Grid extends Thread {

	private int counter, gridRows, gridColumns;
	private Intersection[][] cityArray;
	private StringBuilder gridDisplay;

	/**
	 * Default constructor which creates a grid object made up of Intersection
	 * objects
	 * 
	 * @param gridColumns - the number of columns in the grid
	 * @param gridRows - the number of rows in the grid
	 * @param counter - the number of times the grid will be refreshed
	 */
	public Grid(int gridColumns, int gridRows, int counter) {

		this.gridColumns = gridColumns;
		this.gridRows = gridRows;
		this.counter = counter;

		// Constructs a double array of Intersection objects
		this.cityArray = new Intersection[gridRows][gridColumns];
		this.gridDisplay = new StringBuilder();

		// Loops through every element in the 2D array and gives it an Intersection
		// object.
		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridColumns; j++) {
				cityArray[i][j] = new Intersection();
			}
		}
	}

	/**
	 * A method to @return a double array of Intersection objects representing the
	 * entire grid object.
	 */
	public Intersection[][] getCityArray() {
		return cityArray;
	}
	
	/**
	 * Method to get the status of the grid thread
	 * 
	 * @return a boolean representing whether the grid thread is active (true) or
	 *         not active (false)
	 */
	public boolean getStatus() {

		if (this.isAlive()) {
			return true;
		} else
			return false;
	}

	/**
	 * Run method for the Grid thread. Takes the counter parameter given to the Grid
	 * constructor and refreshes a display of the grid this many times.
	 */
	public void run() {

		for (int i = 0; i < counter; i++) {
			try {

				// Creates a '-' border at the top of the display
				for (int a = 0; a <= gridColumns * 2; a++) {
					gridDisplay.append("- ");
				}

				gridDisplay.append("\r\n");

				// Loops through the entire Intersection double array and gets what is inside
				// each square, appending it to the gridDisplay StringBuilder
				for (int b = 0; b < gridColumns; b++) {
					for (int c = 0; c < gridRows; c++) {
						Intersection section = cityArray[c][b];
						gridDisplay.append(section.getSquare());
					}
					gridDisplay.append("|\r\n"); // Completes the final column in the grid
				}
				// Creates a '-' border at the bottom of the display
				for (int a = 0; a <= gridColumns * 2; a++) {
					gridDisplay.append("- ");
				}

				gridDisplay.append("\r\n");
				// Prints the entire grid display
				System.out.print(gridDisplay.toString());

				// Sleeps for 200 milliseconds and then loops again
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
