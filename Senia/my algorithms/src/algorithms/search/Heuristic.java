package algorithms.search;
/**
*Interface for the Heuristic used for the A* algorithm.
* @author  Senia Kalma
* @since   19/4/2015
*/
public interface Heuristic {
	public double calcH(State Cur,State End);
}
