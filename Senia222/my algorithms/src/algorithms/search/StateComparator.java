package algorithms.search;
import java.util.Comparator;
/**
* Used to compare State for the Priority Queue , does that by the Cost of each state.
* @author  Senia Kalma
* @since   19/4/2015
*/
public class StateComparator implements Comparator<State> {

	@Override
	public int compare(State arg0, State arg1) {
		if(arg0.getCost() < arg1.getCost()){
			return -1;
		}
		if(arg0.getCost() > arg1.getCost()){
			return 1;
		}
		if(arg0.getCost() == arg1.getCost()){
			return 0;
		}
		return -2;
	}
	
}
