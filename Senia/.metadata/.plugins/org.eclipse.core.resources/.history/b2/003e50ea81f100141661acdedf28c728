package algorithms.mazeGenerator;
import java.util.Random;
import java.util.Scanner;
/**
* The RandomMazeGenerator Class is a maze generator function using a random algorithm:
* Finding a path from the start to the end.
* "Breaking" random wall at random unvisited cell.
* When building the maze we ask the user for input for maze size and for starting(only right wall) and
* ending(only bottom wall) points.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class RandomMazeGenerator implements MazeGenerator {

	@Override
	public Maze generateMaze(int rows, int cols) {
		/**
		 * Calling for all the functions that are required for building the maze.
		 */
		Maze maze = new Maze(rows,cols);
		clearMid(maze);
		RGenerator(maze,rows,cols);
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
	
	private void RGenerator(Maze maze,int i,int j){
		/**
		 * Building the actual maze.
		 * we find the starting cell(si,sj) and the ending cell(ei,ej)
		 * Then we find the route from the start to the end, then breaking random wall at random cells.
		 */
		int si=0;
		int sj=(maze.getCols()-1);
		int ei=(maze.getRows()-1);
		int ej=0;
		for(int l=0;l<maze.getRows();l++){
			if(maze.getCell(l,maze.getCols()-1).getrightWall()==false){		//start CELL ((maze.getRows()-1),..
				si=l;
			}
		}
		//maze.getCell(si,sj).setrightWall(true);		//STARTING CELL (i,j-1)
		for(int l=0;l<maze.getCols();l++){
			if(maze.getCell(maze.getRows()-1,l).getbottomWall()==false){		//END CELL ((maze.getRows()-1),..
				ej=l;
			}
		}
		System.out.println("start is: i="+si+" j="+sj);
		System.out.println("end is: i="+ei+" j="+ej);
		//COPY ===START===
		boolean opup=true;		//1 for UP
		boolean opright=true;	//2 for RIGHT
		boolean opleft=true;	//3 for LEFT
		boolean opdown=true;	//4 for DOWN
		int[][] archive = new int[(maze.getRows()+1)*(maze.getCols()+1)][2];
		int moves=0;
		int inf=0;
		Random rand = new Random();
		int rn = rand.nextInt(4)+1;
			while(si!=ei || sj!=ej){
				inf=inf+1;
				if(inf>10){
					si=archive[(moves-1)][0];
					sj=archive[(moves-1)][1];
					moves=moves-1;
					inf=0;
				}
				rn = rand.nextInt(4)+1;
				if(si==0){opup=false;}
				if(si==(maze.getRows()-1)){opdown=false;}
				if(sj==0){opleft=false;}
				if(sj==(maze.getCols()-1)){opright=false;}
				while(rn==1 && opup==false || rn==2 && opright==false || rn==3 && opleft==false || rn==4 && opdown==false){
					rn = rand.nextInt(4)+1;
				}
				if(rn==1 && !(maze.getCell((si-1), sj).isVisited())){		//for UP && for !(Visited in upper cell)
					this.GoUp(maze, si, sj);
					si=si-1;
					archive[moves][0]=si;
					archive[moves][1]=sj;
					moves=moves+1;
					inf=0;
					
				}
				if(rn==2 && !(maze.getCell(si, (sj+1)).isVisited())){		//for RIGHT && for !(Visited in right cell)
					this.GoRight(maze, si, sj);
					sj=sj+1;
					archive[moves][0]=si;
					archive[moves][1]=sj;
					moves=moves+1;
					inf=0;
				}
				if(rn==3 && !(maze.getCell(si, (sj-1)).isVisited())){		//for LEFT && for !(Visited in left cell)
					this.GoLeft(maze, si, sj);
					sj=sj-1;
					archive[moves][0]=si;
					archive[moves][1]=sj;
					moves=moves+1;
					inf=0;
				}
				if(rn==4 && !(maze.getCell((si+1), sj).isVisited())){		//for DOWN && for !(Visited in down cell)
					this.GoDown(maze, si, sj);
					si=si+1;
					archive[moves][0]=si;
					archive[moves][1]=sj;
					moves=moves+1;
					inf=0;
				}
				opup=true;
				opright=true;
				opleft=true;
				opdown=true;
			}
		//COPY ===END===
			/*System.out.println("================After our good routh was found====================");
			maze.print();
			System.out.println();
			System.out.println("==================================================================");*/
		int ri;
		int rj;
		while(!maze.unvisitedCellLeft()){
			do{
				ri = rand.nextInt(maze.getRows());
				rj = rand.nextInt(maze.getCols());
			}while(!maze.getCell(ri,rj).isVisited());
			//COPY2 ===START===
			rn = rand.nextInt(4)+1;
			if(ri==0){opup=false;}
			if(ri==(maze.getRows()-1)){opdown=false;}
			if(rj==0){opleft=false;}
			if(rj==(maze.getCols()-1)){opright=false;}
			while(rn==1 && opup==false || rn==2 && opright==false || rn==3 && opleft==false || rn==4 && opdown==false){
				rn = rand.nextInt(4)+1;
			}
			if(rn==1 && !(maze.getCell((ri-1), rj).isVisited())){		//for UP && for !(Visited in upper cell)
				this.GoUp(maze, ri, rj);
				
			}
			if(rn==2 && !(maze.getCell(ri, (rj+1)).isVisited())){		//for RIGHT && for !(Visited in right cell)
				this.GoRight(maze, ri, rj);
			}
			if(rn==3 && !(maze.getCell(ri, (rj-1)).isVisited())){		//for LEFT && for !(Visited in left cell)
				this.GoLeft(maze, ri, rj);
			}
			if(rn==4 && !(maze.getCell((ri+1), rj).isVisited())){		//for DOWN && for !(Visited in down cell)
				this.GoDown(maze, ri, rj);
			}
			opup=true;
			opright=true;
			opleft=true;
			opdown=true;
			//COPY2 ===END===*/
		}
		
	}	//function
	private void clearMid(Maze maze){
		/**
		 * Creating the maze using user input.
		 */
		System.out.println("Enter the starting point in the right wall of the maze:");
		int start = new Scanner(System.in).nextInt();
		while(start>maze.getRows()){
			System.out.print("Enter a number smaller then the number of rows (<");
			System.out.println((maze.getRows()+1)+") :");
			start = new Scanner(System.in).nextInt();
		}
		start=start-1;
		System.out.println("Enter the end point in the bottom wall of the maze:");
		int end = new Scanner(System.in).nextInt();
		while(end>maze.getRows()){
			System.out.print("Enter a number smaller then the number of cols (<");
			System.out.println((maze.getCols()+1)+") :");
			end = new Scanner(System.in).nextInt();
		}
		end=end-1;
		for(int i=0;i<maze.getRows();i++){
			for(int j=0;j<maze.getCols();j++){
				if(i==start && j == maze.getCols()-1){
					maze.getCell(i,j).setrightWall(false);
				}
				if(j==end && i == maze.getRows()-1){
						maze.getCell(i,j).setbottomWall(false);
					}

			}
		}
		//return start;
	}
}	//class
