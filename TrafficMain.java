import java.util.ArrayList;
import java.util.Random;

public class TrafficMain {

	
	
	public static void main (String[] args) throws InterruptedException {
		
		int columns = 20;
		int rows = 10;
		int counter = 1;
		
		
		Intersection glasgowCity = new Intersection(columns, rows);
		
		
		
		
//		Grid [] x = new Grid [counter];
//		for (int i = 0; i < counter; i++) {
//			x[i] = new Grid(glasgowCity);
//			x[i].start();
//			Grid.sleep(2000);
//		}
		
		// generate a car objects randomly
		
		ArrayList <Car> carArray = new ArrayList <Car>();
		
		
		for (int i = 0; i< 10; i++) {
		int randomNum = (int) Math.round(Math.random());
		carArray.add(new Car(randomNum));
		System.out.println(randomNum);
		}
		for (int i = 0; i <carArray.size(); i++) {
			String car = carArray.get(i).getSymbol();
			System.out.println(car);
		}
		for (int i = 0; i <carArray.size(); i++) {
			int speedy = carArray.get(i).getSpeed();
			System.out.println(speedy);
		}
		
		
		
	}
}
