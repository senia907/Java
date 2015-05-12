package test;

import java.util.Iterator;

import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerator.DFSMazeGenerator;
import algorithms.mazeGenerator.Maze;
import algorithms.mazeGenerator.MazeGenerator;
import algorithms.search.AirDis;
import algorithms.search.Astar;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;

public class Test2 {
	public static void main(String[] args) {
		MazeGenerator mg=new DFSMazeGenerator();
		Maze m = mg.generateMaze(25,25);
		m.print();
		Searcher C = new Astar(new AirDis());
		Searchable sa = new MazeAdapter(false,m);
		Solution k = C.search(sa);
		
		System.out.println("Astar-Air Distance-No diagonal: ");
		System.out.println("Number of Nodes Evaluated is: "+C.getNumberOfNodesEvaluated());
		System.out.println("Routh is: (i,j) VVV");
		Iterator<State> ite = k.getRoad().iterator();
		State s;
		int n=0;
		while(ite.hasNext()){
			n=n+1;
			s=ite.next();
			System.out.print("("+s.getStateString()+")>>>");
			if(n==10){
				System.out.println("");
				n=0;
		}
	}
   }
}
