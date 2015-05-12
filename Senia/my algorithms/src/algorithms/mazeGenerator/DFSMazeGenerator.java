package algorithms.mazeGenerator;
import java.util.Random;
/**
* The DFSMazeGenerator Class is a maze generator function using the DFS algorithm and with the cell class it builds-
* MAZES- How cool is that? Very.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class DFSMazeGenerator implements MazeGenerator {

	@Override
	public Maze generateMaze(int rows, int cols) {
		/**
		 * Generates a maze using rows and cols variables, and sets the starting point as (0,0)
		 */
		Maze maze = new Maze(rows,cols);
		Generaotr(maze,0,0);
		return maze;
	}
	private void GoUp(Maze maze,int i,int j){
		/**
		 * Going UP in the maze, updating all needed variables(sets Cell and upper Cell visited values as TRUE)
		 */
		maze.getCell(i, j).settopWall(false);
		maze.getCell((i-1), j).setbottomWall(false);
		maze.getCell(i, j).setVisited(true);
		maze.getCell((i-1), j).setVisited(true);
	}
	private void GoLeft(Maze maze,int i,int j){
		/**
		 * Going LEFT in the maze, updating all needed variables(sets Cell and left Cell visited values as TRUE)
		 */
		maze.getCell(i, j).setleftWall(false);
		maze.getCell(i, (j-1)).setrightWall(false);
		maze.getCell(i, j).setVisited(true);
		maze.getCell(i, (j-1)).setVisited(true);
	}
	private void GoRight(Maze maze,int i,int j){
		/**
		 * Going RIGHT in the maze, updating all needed variables(sets Cell and right Cell visited values as TRUE)
		 */
		maze.getCell(i, j).setrightWall(false);
		maze.getCell(i, (j+1)).setleftWall(false);
		maze.getCell(i, j).setVisited(true);
		maze.getCell(i, (j+1)).setVisited(true);
	}
	private void GoDown(Maze maze,int i,int j){
		/**
		 * Going DOWN in the maze, updating all needed variables(sets Cell and bottom Cell visited values as TRUE)
		 */
		maze.getCell(i, j).setbottomWall(false);
		maze.getCell((i+1), j).settopWall(false);
		maze.getCell(i, j).setVisited(true);
		maze.getCell((i+1), j).setVisited(true);
	}
	

	private void Generaotr(Maze maze,int i,int j){
		/**
		 * Generates the actual maze.
		 * The inner while is for choosing a random option(1-UP,2-RIGHT,3-LEFT,4-DOWN) - that we can go - 
		 * Checking by boundaries.
		 * After that and by the bigger while(!maze.unvisitedCellLeft()-Till we finish going throw all the cells
		 * We check the Visited variable(for not stepping on already stepped Cell.
		 */
	boolean opup=true;		//1 for UP
	boolean opright=true;	//2 for RIGHT
	boolean opleft=true;	//3 for LEFT
	boolean opdown=true;	//4 for DOWN
	int[][] archive = new int[(maze.getRows()+1)*(maze.getCols()+1)][2];
	int moves=0;
	int inf=0;
	Random rand = new Random();
	int rn = rand.nextInt(4)+1;
		while(!maze.unvisitedCellLeft()){
			inf=inf+1;
			if(inf>10){
				i=archive[(moves-1)][0];
				j=archive[(moves-1)][1];
				moves=moves-1;
				inf=0;
			}
			rn = rand.nextInt(4)+1;
			if(i==0){opup=false;}
			if(i==(maze.getRows()-1)){opdown=false;}
			if(j==0){opleft=false;}
			if(j==(maze.getCols()-1)){opright=false;}
			while(rn==1 && opup==false || rn==2 && opright==false || rn==3 && opleft==false || rn==4 && opdown==false){
				rn = rand.nextInt(4)+1;
			}
			if(rn==1 && !(maze.getCell((i-1), j).isVisited())){		//for UP && for !(Visited in upper cell)
				this.GoUp(maze, i, j);
				i=i-1;
				archive[moves][0]=i;
				archive[moves][1]=j;
				moves=moves+1;
				inf=0;
				
			}
			if(rn==2 && !(maze.getCell(i, (j+1)).isVisited())){		//for RIGHT && for !(Visited in right cell)
				this.GoRight(maze, i, j);
				j=j+1;
				archive[moves][0]=i;
				archive[moves][1]=j;
				moves=moves+1;
				inf=0;
			}
			if(rn==3 && !(maze.getCell(i, (j-1)).isVisited())){		//for LEFT && for !(Visited in left cell)
				this.GoLeft(maze, i, j);
				j=j-1;
				archive[moves][0]=i;
				archive[moves][1]=j;
				moves=moves+1;
				inf=0;
			}
			if(rn==4 && !(maze.getCell((i+1), j).isVisited())){		//for DOWN && for !(Visited in down cell)
				this.GoDown(maze, i, j);
				i=i+1;
				archive[moves][0]=i;
				archive[moves][1]=j;
				moves=moves+1;
				inf=0;
			}
			opup=true;
			opright=true;
			opleft=true;
			opdown=true;
		}	//while
	}		//func
	
}
