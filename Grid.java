
public class Grid extends Thread {

	private StringBuilder gridBuilder;

	private int gridRows;
	private int gridColumns;
	private Grid [][] cityArray;
	
	public Grid(int gridColumns, int gridRows) {
		
		this.gridColumns = gridColumns;
		this.gridRows = gridRows;
		this.cityArray = new Grid[gridColumns][gridRows];
	}

	public int getGridRows() {
		return gridRows;
	}

	public void setGridRows(int gridRows) {
		this.gridRows = gridRows;
	}

	public int getGridColumns() {
		return gridColumns;
	}

	public void setGridColumns(int gridColumns) {
		this.gridColumns = gridColumns;
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(gridBuilder.toString());

	}

}
