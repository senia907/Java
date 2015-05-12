package algorithms.demo;
import java.util.ArrayList;

import algorithms.mazeGenerator.Cell;
import algorithms.mazeGenerator.Maze;
import algorithms.search.Searchable;
import algorithms.search.State;
/**
* Adapting the Maze Class to be a Searchable class so we can search on it.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class MazeAdapter implements Searchable {
	Maze maze;
	boolean diag;
	
	public MazeAdapter(boolean flag,Maze m){
		super();
		this.diag = flag;
		this.maze = m;
	}
	
	@Override
	public State getStartState() {
		int si=-2;
		int sj=(maze.getCols()-1);
		for(int l=0;l<maze.getRows();l++){	//Could be made with "RandomMazeGenerator" - Whice sets the start in the last col
			if(maze.getCell(l,maze.getCols()-1).getrightWall()==false){		//start CELL ((maze.getRows()-1),..
				si=l;
			}
		}
		//maze.getCell(si,sj).setrightWall(true);		//STARTING CELL (i,j-1)
		//System.out.println("start is: i="+si+" j="+sj);
		if(si==(-2)){
			si=0;
			sj=0;
		}
		//State state = new State(si+","+sj,0,null);
		State state = new State(si+","+sj);
		return state;
	}

	@Override
	public State getGoalState() {
		int ei=(maze.getRows()-1);
		int ej=-2;
		for(int l=0;l<maze.getCols();l++){	//Could be made with "RandomMazeGenerator" - Whice sets the end in the last row
			if(maze.getCell(maze.getRows()-1,l).getbottomWall()==false){		//END CELL ((maze.getRows()-1),..
				ej=l;
			}
		}
		//System.out.println("end is: i="+ei+" j="+ej);
		if(ej==(-2)){
			ei=(maze.getRows()-1);
			ej=(maze.getCols()-1);
		}
		//State state = new State(ei+","+ej,0,null);
		State state = new State(ei+","+ej);
		return state;

	}

	@Override
	
	public ArrayList<State> getAllPossibleStates(State n) {
		/**
		 * Setting new possible states and putting them in the array "array", then returning the array
		 */
		ArrayList<State> array = new ArrayList<State>();
		String[] str = new String[2];
		str=n.getState().split(",");
		int i = Integer.parseInt(str[0]);	//setting i as the Row index of the cell position
		int j = Integer.parseInt(str[1]);	//setting j as the Col index of the cell position
		Cell c = this.maze.getCell(i,j);	//Setting current cell
		String parent;
		if(n.getCameFrom() ==null){
			parent = "0,0";
		}
		else
			parent = n.getCameFrom().getStateString();
		if(i!=0)	//UP
			if(parent.equals((i-1)+","+j)==false && c.gettopWall()==false){	//if its not the first row - We can go up - there is a STATE like this
				array.add(new State((i-1)+","+(j),n.getCost()+10,n));
			}
		if(i!=(this.maze.getRows()-1)) //DOWN
			if((parent.equals((i+1)+","+j)==false) && (c.getbottomWall()==false)){	//if its not the last row - We can go down
				array.add(new State((i+1)+","+(j),n.getCost()+10,n));
			}
		if(j!=0) //LEFT
			if(parent.equals((i)+","+(j-1))==false && c.getleftWall()==false){	//if its not the first col - We can go left
				array.add(new State(i+","+(j-1),n.getCost()+10,n));
			}
		if(j!=(this.maze.getCols()-1)) //RIGHT
			if(parent.equals((i)+","+(j+1))==false && c.getrightWall()==false){	//if its not the last col - We can go right
				array.add(new State(i+","+(j+1),n.getCost()+10,n));
			}
		//Now for Diagonals:
		if(this.diag==true)
		{
			if(i!=0 && j!=0)
				if(!parent.equals((i-1)+","+(j-1)) && c.gettopWall()==false && c.getleftWall()==false){	//if its not the first row and first col - We can go diagonali LEFT UP - <^
					array.add(new State((i-1)+","+(j-1),n.getCost()+10,n));
				}
			if(i!=0 && j!=(this.maze.getCols()-1))
				if(!parent.equals((i-1)+","+(j+1)) && c.gettopWall()==false && c.getrightWall()==false){	//if its not the first row and last col - We can go diagonali RIGHT UP - >^
					array.add(new State((i-1)+","+(j+1),n.getCost()+10,n));
				}
			if(i!=(this.maze.getRows()-1) && j!=(this.maze.getCols()-1))
				if(!parent.equals((i+1)+","+(j+1)) && c.getbottomWall()==false && c.getrightWall()==false){	//if its not the last row and last col - We can go diagonali RIGHT DOWN - >V
					array.add(new State((i+1)+","+(j+1),n.getCost()+10,n));
				}
			if(i!=(this.maze.getRows()-1) && j!=0)
				if(!parent.equals((i+1)+","+(j-1)) && c.getbottomWall()==false && c.getleftWall()==false){	//if its not the last row and first col - We can go diagonali LEFT DOWN - <V
					array.add(new State((i+1)+","+(j-1),n.getCost()+10,n));
				}
		}
		return array;
	}

	public boolean isDiag() {
		return diag;
	}

	public void setDiag(boolean diag) {
		this.diag = diag;
	}

}
