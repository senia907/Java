package algorithms.search;
import java.util.*;
/**
* CommonSearcher implements Searcher and used as a class containing variables used for a searcher, like the BFS search algorithm for example.
* @author  Senia Kalma
* @since   19/4/2015
*/
public abstract class CommonSearcher implements Searcher {
	
	 protected Comparator<State> comparator;
	 protected PriorityQueue<State> openList;
	 private int evaluatedNodes=0;		//What's that and when ++ ROEI: KSEOSIM PULL
	 
	 @Override
	 public abstract Solution search(Searchable s);

	 @Override
	 public int getNumberOfNodesEvaluated() {
	  return evaluatedNodes;
	 }
	 protected double getMinCost(){
		 /**
		  * Getting the minimum cost in the open list(by states..)
		  */
	  double min = openList.peek().getCost();
	  State s;
	  Iterator<State> iter = openList.iterator();
	  while(iter.hasNext()){
		  s = iter.next();
		  if(s.getCost() < min){
			  min = s.getCost();
		  }
	  }
	  return min;
	 }
	 
	 protected void edj(State state){
		 /**
		  * Adjusting the cost of the received state.
		  */
	  	Iterator<State> iter = openList.iterator();
	  	State temp;
	  	while(iter.hasNext()){
	  		temp = iter.next();
	  		if(temp==state){
	  			temp.setCost(state.getCost());
	  		}
	 }
	}
	 
	public Solution backTrace(State End,State Start){
		/**
		 * Finds our routh that we did.
		 */
		 Solution sol= new Solution();
		 sol.push(End);
		while(!End.equals(Start)){
			sol.push(End.getCameFrom());
			End=(End.getCameFrom());
		}
		 return sol;
	 }
	public CommonSearcher() {
		 super();
		 this.comparator = new StateComparator();
		  this.openList=new PriorityQueue<State>(comparator);
		  evaluatedNodes=0;
	}
	protected State popOpenList() {

	  return openList.poll();
	 }
	public PriorityQueue<State> getOpenList() {
		return openList;
	}
	public void setOpenList(PriorityQueue<State> openList) {
		this.openList = openList;
	}
	public void addToOpenList(State state) {
		this.openList.add(state);
	}
	public boolean openListContains(State state){
		return this.openList.contains(state);
	}
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
}
