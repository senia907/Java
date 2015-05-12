package algorithms.demo;

import java.util.Iterator;

import algorithms.mazeGenerator.DFSMazeGenerator;
import algorithms.mazeGenerator.Maze;
import algorithms.mazeGenerator.MazeGenerator;
import algorithms.search.AirDis;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.ManDis;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
/**
* The run is the test method runing the code.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class Demo {

	public void run() {
		MazeGenerator mg=new DFSMazeGenerator();
		Maze m = mg.generateMaze(15,15);
		m.print();
		int n=0;
		Searcher C = new BFS();
		Searchable sa = new MazeAdapter(false,m);
		Solution k = C.search(sa);
		
		System.out.println("BFS-No diagonal: ");
		System.out.println("Number of Nodes Evaluated is: "+C.getNumberOfNodesEvaluated());
		System.out.println("Routh is: (i,j) VVV");
		Iterator<State> ite = k.getRoad().iterator();
		State s;
		while(ite.hasNext()){
			n=n+1;
			s=ite.next();
			System.out.print("("+s.getStateString()+")>>>");
			if(n==10){
				System.out.print("/n");
				n=0;
			}
		}
		sa = new MazeAdapter(true,m);
		k = C.search(sa);
		
		System.out.println("\n\nBFS-With diagonal: ");
		System.out.println("Number of Nodes Evaluated is: "+C.getNumberOfNodesEvaluated());
		System.out.println("Routh is: (i,j) VVV");
		ite = k.getRoad().iterator();
		while(ite.hasNext()){
			n=n+1;
			s=ite.next();
			System.out.print("("+s.getStateString()+")>>>");
			if(n==10){
				System.out.print("/n");
				n=0;
			}
		}
		
		C = new Astar(new ManDis());
		sa = new MazeAdapter(false,m);
		k = C.search(sa);
		
		System.out.println("\n\nAstar-Manhaten Distance-No diagonal: ");
		System.out.println("Number of Nodes Evaluated is: "+C.getNumberOfNodesEvaluated());
		System.out.println("Routh is: (i,j) VVV");
		ite = k.getRoad().iterator();
		while(ite.hasNext()){
			n=n+1;
			s=ite.next();
			System.out.print("("+s.getStateString()+")>>>");
			if(n==10){
				System.out.print("/n");
				n=0;
			}
		}
		
		
		C = new Astar(new AirDis());
		sa = new MazeAdapter(true,m);
		k = C.search(sa);
		
		System.out.println("\n\nAstar-Air Distace-With diagonal: ");
		System.out.println("Number of Nodes Evaluated is: "+C.getNumberOfNodesEvaluated());
		System.out.println("Routh is: (i,j) VVV");
		ite = k.getRoad().iterator();
		while(ite.hasNext()){
			n=n+1;
			s=ite.next();
			System.out.print("("+s.getStateString()+")>>>");
			if(n==10){
				System.out.print("/n");
				n=0;
			}
		}
		
		return;
	}
	

}
