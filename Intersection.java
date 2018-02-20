
public class Intersection {

	private int gridRows;
	private int gridColumns;
	private String [][] intersectionArray;
	
	public Intersection(int gridColumns, int gridRows) {
		
		this.gridColumns = gridColumns;
		this.gridRows = gridRows;
		this.intersectionArray = new String [gridColumns][gridRows];
		
		
		for (int j=0; j < gridRows; j++) {
			for (int i = 0; i < gridColumns; i++) {
			
				intersectionArray[i][j] = "| ";
				System.out.print(intersectionArray[i][j]);
			}
			System.out.print("|\r\n");
		}
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

	public String[][] getIntersectionArray() {
		
		return intersectionArray;
	}
}
