package algorithms.search;
import java.util.ArrayList;
/**
* Interface for a searchable(maze,...), continng all the function we used in BFS searcher for example.
* @author  Senia Kalma
* @since   19/4/2015
*/
public interface Searchable {
	   algorithms.search.State getStartState();
	   algorithms.search.State getGoalState();
	   ArrayList<State> getAllPossibleStates(State n);

}
