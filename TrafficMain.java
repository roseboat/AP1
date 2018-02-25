
public class TrafficMain extends Thread {

	public static void main(String[] args) throws InterruptedException {

		int rows = 10;
		int columns = 20;
		int counter = 2000;

		Grid glasgowCity = new Grid(rows, columns, counter);
		glasgowCity.start();

		Car x = new Car(1, glasgowCity.getCityArray());
		x.setPosition(5, 5);
		x.position.fillPosition(x);

		Car y = new Car(0, glasgowCity.getCityArray());
		y.setPosition(5, 0);
		y.start();

	}
}
