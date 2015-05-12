package algorithms.search;
import java.util.Collections;
import java.util.LinkedList;
/**
* Class Solution used for our searching algorithm for saving the solution(in general way).
* @author  Senia Kalma
* @since   19/4/2015
*/
public class Solution {

	//private ArrayList<State> road;
	LinkedList<State> road = new LinkedList<State>();
	
	public Solution(){
		super();
		road = new LinkedList<State>();
	}
	
	public void addToList(State s){
		this.road.add(s);
	}
	public void push(State s){
		this.road.push(s);
	}
	public State pop(State s){
		return this.road.pop();
	}
	public LinkedList<State> getRoad() {
		return road;
	}
	public void setRoad(LinkedList<State> road) {
		this.road = road;
	}
	
	public void Reversed()
	{
		Collections.reverse(road);
		return;
	}
	
	//ARRAY/LIST private mistane
	//OVERRIDE
	//public String toString(){
//}
}
