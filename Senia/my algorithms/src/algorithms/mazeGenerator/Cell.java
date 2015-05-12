package algorithms.mazeGenerator;
/**
* The Cell class used to build a maze in my program, yet it can be used for any other thing you like.
* it has 4 Walls(double walls happen-->Right wall for left cell || Left wall for right cell),
* a position(row,col) and a "visited" boolean variable.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class Cell {
	private boolean rightWall = true;
	private boolean leftWall = true;
	private boolean topWall = true;
	private boolean bottomWall = true;
	private boolean visited = false;
	private int row;
	private int col;
	
	public boolean getrightWall() {
		return rightWall;
	}
	public void setrightWall(boolean rightWall) {
		this.rightWall = rightWall;
	}
	public boolean getleftWall() {
		return leftWall;
	}
	public void setleftWall(boolean leftWall) {
		this.leftWall = leftWall;
	}
	public boolean gettopWall() {
		return topWall;
	}
	public void settopWall(boolean topWall) {
		this.topWall = topWall;
	}
	public boolean getbottomWall() {
		return bottomWall;
	}
	public void setbottomWall(boolean bottomWall) {
		this.bottomWall = bottomWall;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public Cell(int row, int col){
		setRow(row);
		setCol(col);
	}
}
