
public class Grid extends Thread {

	private Intersection grid;
	private StringBuilder gridBuilder;

	public Grid(Intersection grid) {
		this.grid = grid;
	}

	public void run() {

		gridBuilder = new StringBuilder();

		for (int i = 0; i <= grid.getGridColumns() * 2; i++) {
			gridBuilder.append("-");
		}
		gridBuilder.append("\r\n");
		for (int i = 0; i <= grid.getGridRows(); i++) {
			for (int j = 0; j <= grid.getGridColumns(); j++) {
				gridBuilder.append("| ");
			}
			gridBuilder.append("\r\n");
		}
		for (int i = 0; i <= grid.getGridColumns() * 2; i++) {
			gridBuilder.append("-");
		}
		gridBuilder.append("\r\n");
		System.out.print(gridBuilder.toString());

	}

}
