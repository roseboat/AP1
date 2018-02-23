
public class TrafficMain extends Thread {

	public static void main(String[] args) throws InterruptedException {

		int rows = 10;
		int columns = 20;
		int counter = 2000;

		Grid glasgowCity = new Grid(rows, columns, counter);

		glasgowCity.start();

	}

}
