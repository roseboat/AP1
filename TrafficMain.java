
import java.util.Random;

public class TrafficMain {

	
	
	public static void main (String[] args) throws InterruptedException {
		
		int columns = 20;
		int rows = 10;
		int counter = 1;
		
		
		Intersection glasgowCity = new Intersection(columns, rows);
		
		
		for (int i = 0; i< 1000; i++) {
		int randomNum = (int) Math.round(Math.random());
		new Car(randomNum);
		System.out.println(randomNum);
		}
	}
}
