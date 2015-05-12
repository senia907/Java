package algorithms.search;
/**
* Interface for a searcher.
* @author  Senia Kalma
* @since   19/4/2015
*/
public interface Searcher {
    // the search method
    public Solution search(Searchable s);
    public int getNumberOfNodesEvaluated();

}
