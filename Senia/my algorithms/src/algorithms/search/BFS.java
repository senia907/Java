package algorithms.search;
import java.util.HashSet;
import java.util.ArrayList;
/**
* BFS algorithm for searching a Solution for Searchable.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class BFS extends CommonSearcher {

	@Override
	public Solution search(Searchable s) {
    	/**
    	 * Searchin for a solution by the BFS Algorithm
    	 */
		  HashSet<State> closedSet=new HashSet<State>();
		  State n;
		  openList.add(s.getStartState());
		  n=null;
		  
		  while(openList.size()>0){
			  	this.setEvaluatedNodes((getNumberOfNodesEvaluated()+1));	//adds 1 to the counter
			    n=popOpenList();// dequeue
			    closedSet.add(n);//mark as "was here"
			    
			    if(n.equals(s.getGoalState()))
			    	return this.backTrace(n, s.getStartState());	//Finishes and sets the solution
			    ArrayList<State> successors=s.getAllPossibleStates(n); //Creates n's successors
			    for(State state : successors){
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


}	//Class
		  
