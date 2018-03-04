import java.util.ArrayList;

/**
 * The Statistics Class is called by a Generator object once it has finished
 * running all of its threads. It calculates the minimum, maximum, mean and
 * variance times taken for the cars produced by a Generator to pass through the
 * grid. It prints these stats to the console once the grid thread has finished.
 * 
 * @author RosaDowning
 */

public class Statistics {

	private long min, max, sum, mean, size, variance, square, squareSum;
	private ArrayList<Long> genTimes;
	private String genName;

	/**
	 * Constructor for a Statistics object.
	 *
	 * @param name of the Generator
	 * @param an ArrayList of all times recorded by a Generator ie. the times taken
	 *        for all the cars produced by a Generator to pass through the grid.
	 */
	public Statistics(String name, ArrayList<Long> generatorTimes) {
		this.genTimes = generatorTimes;
		this.size = genTimes.size(); // Gets the number of times recorded
		this.genName = name;

		// Calls methods to calculate the required values and finally a method to print
		// them to the console
		getMinMaxMean();
		getVariance();
		printStats();
	}

	/**
	 * Method to calculate the minimum, maximum and mean time for a car to pass
	 * through the grid
	 */
	public void getMinMaxMean() {

		// Sets max and min to the first element in the ArrayList
		this.max = genTimes.get(0);
		this.min = genTimes.get(0);

		// Loops through all the values in the ArrayList and compares them with min and
		// max. If the value is greater than max, it sets max to that value. Likewise,
		// if the value is smaller than min it sets min to that value.
		for (int i = 0; i < genTimes.size(); i++) {
			if (max < genTimes.get(i)) {
				max = genTimes.get(i);
			} else if (min > genTimes.get(i)) {
				min = genTimes.get(i);
			}
			this.sum += genTimes.get(i); // Adds all of the values together
		}
		this.mean = sum / size; // Divides the sum of all the values by the size of the array (the number of
								// cars) in order to get the mean.
	}

	/**
	 * Method to get the variance value
	 */
	public void getVariance() {

		// Subtracts the mean from each time and squares the result, adding each result
		// to a variable squareSum
		for (int i = 0; i < genTimes.size(); i++) {
			this.square = genTimes.get(i) - mean;
			square = (long) Math.pow(square, 2);
			squareSum += square;
		}
		
		// Calculates the variance by dividing the sum of all squared values by the size
		// of the data set and finding the square root of that value
		this.variance = (long) Math.sqrt(squareSum / size);
	}

	/**
	 * Method prints the stats to the console
	 */
	public void printStats() {

		StringBuilder stats = new StringBuilder("Generator \"" + genName + "\" Statistics:\r\n");
		stats.append("-------------------------------\r\n");
		stats.append(String.format("Minimum time: %d ms\r\nMaximum time: %d ms\r\nMean time: %d ms\r\nVariance: %d ms\r\n", min,
				max, mean, variance));
		stats.append("The number of cars recorded: "+ size + "\r\n");
		System.out.println(stats.toString());
	}
}
