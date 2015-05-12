package algorithms.mazeGenerator;
/**
* The Maze Class is the set of functions we can do on a maze.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class Maze {
	/**
	 * Setting the maze cells and their values.
	 */
	private Cell[][] matrix;
	private int rows;
	private int cols;
	
	public Maze(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		this.matrix = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = new Cell(i, j);
			}
		}
	}
	
	public void print() {
		/**
		 * Printing the maze.
		 */
		for (int j = 0; j < cols; j++)
			System.out.print("__");
		System.out.println("_");
		
		for (int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < cols; j++) {				
				Cell cell = matrix[i][j];
				if (cell.getbottomWall())
					System.out.print("_");
				else
					System.out.print(" ");
				
				if (cell.getrightWall())
					System.out.print("|");
				else
					System.out.print(" ");	
								
			}
			System.out.println();
		}
	}

	public Cell getCell(int row, int col) {
		/**
		 * Returning the mazes cell by rows and cols.
		 */
		return matrix[row][col];
	}
	
	public boolean unvisitedCellLeft(){
		/**
		 * Checking if there is unvisited cells left:
		 * ALL CELLS CHECKED - RETURN TRUE
		 * SOME UNVISITED CELLS - RETURN FALSE
		 */
		boolean flag=true;
		for(int i=0;i<this.getRows();i++){
			for(int j=0;j<this.getCols();j++){
				if((this.getCell(i, j)).isVisited()==false){
					flag=false;
				}
			}
		}
		return flag;
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
}
