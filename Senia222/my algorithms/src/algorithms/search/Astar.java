package algorithms.search;
import java.util.ArrayList;
import java.util.HashSet;
/**
* General algorithm to find a solution for "Searchable" by the A* algorithm, another class is the same
* but works with the diagonal option.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class Astar extends CommonSearcher {
	private Heuristic Hue;
    public Astar(Heuristic Heuristic){    // CTOR
    	super();
        this.Hue = Heuristic;
    }
    
    
    public Solution search(Searchable s) {
    	/**
    	 * Searching for a solution by the Astar Algorithm
    	 */
		  HashSet<State> closedSet=new HashSet<State>();
		  State n;
		  openList.add(s.getStartState());
		  n=null;
		  
		  while(openList.size()>0){
			  	this.setEvaluatedNodes((this.getNumberOfNodesEvaluated()+1));	//adds 1 to the counter
			    n=popOpenList();// dequeue
			    closedSet.add(n);//mark as "was here"
			    double g=0,h=0,distcost=0;
			    
			    if(n.equals(s.getGoalState()))
			    	return this.backTrace(n, s.getStartState());	//Finishes and sets the solution
			    ArrayList<State> successors=s.getAllPossibleStates(n); //Creates n's successors
			    for(State state : successors){
			    	distcost=Math.abs(state.getCost()-n.getCost());	//n is the parent of state
			    	g=n.getCost()+distcost-Hue.calcH(n,s.getGoalState());	//Cost containing cost to it and cost to goal, we aren't interested in the cost to goal of n(we are focusing on state),so we remove it
			    	h=Hue.calcH(state,s.getGoalState());
			    	state.setCost((g+h));
			      if(!closedSet.contains(state) && !openList.contains(state)){	//if state not in Open not in Closed
			        //state.setCameFrom(n);	//set states "father" as n
			        this.addToOpenList(state);	//adds to Open list state
			      } else{
			        //if(n.getCost()+(state.getCost()-n.getCost())<state.getCost()){	//If new move cost better then was move
			        if(state.getCost()<getMinCost()){
			    	  	if(!openList.contains(state)){		//if state is not in open
			        		state.setCameFrom(state);
			    	  		openList.add(state);	//add it to open
			        	}
			    	  	else{
			    	  	//ADJUST IT IN THE PRIORITY Q
			    	  		edj(state);
			    	  	}
			        }
			      }
			    }//For
		
		  }//While
		  return this.backTrace(n, s.getStartState()); //to prevent error.
	}	//Solution
    
}
