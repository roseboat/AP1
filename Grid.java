
public class Grid extends Thread {
	
	private int counter; 
	private StringBuilder gridDisplay;
	private int gridRows;
	private int gridColumns;
	private Intersection[][] cityArray;

	public Grid(int gridColumns, int gridRows, int counter) {

		this.gridColumns = gridColumns;
		this.gridRows = gridRows;
		this.counter = counter;
		this.cityArray = new Intersection[gridRows][gridColumns];
		this.gridDisplay = new StringBuilder();

		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridColumns; j++) {
				cityArray[i][j] = new Intersection();
			}
		}
	}
	
	public Intersection [][] getCityArray(){
		return cityArray;
	}
	
	
	public void run() {

		for(int i = 0; i < counter; i++) {
			try {
				
//			Car x = new Car((int) Math.round(Math.random()), cityArray);
//			x.start();
//				
			for (int a = 0; a <=gridColumns * 2; a++) {
				gridDisplay.append("- ");
				}
			gridDisplay.append("\r\n");
			for (int j = 0; j < gridColumns; j++) {
				for (int k = 0; k < gridRows; k++) {
					Intersection section = cityArray[k][j];
					gridDisplay.append(section.getSquare());
				}
				gridDisplay.append("|\r\n");
			}
			for (int a = 0; a <=gridColumns * 2; a++) {
				gridDisplay.append("- ");
				}
			gridDisplay.append("\r\n");
			System.out.print(gridDisplay.toString());
	
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
			break;
		}
		}
	}
}
