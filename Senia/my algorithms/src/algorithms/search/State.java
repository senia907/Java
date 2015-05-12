package algorithms.search;
/**
* A class used a state, have a String state(the state represented by a string),double cost(to reach here),State cameFrom(State we came from).
* @author  Senia Kalma
* @since   19/4/2015
*/
public class State {
	private String state;    // the state represented by a string
    private double cost;     // cost to reach this state
    private State cameFrom;  // the state we came from to this state

    public State(String state){    // CTOR    
        this.state = state;
    }
    public State(String state,double Cost,State From){    // CTOR2    
        this.setStateString(state);
        this.setCost(Cost);
        this.setCameFrom(From);
    }
    //public boolean equals(object obj){
    //return state.equals(((state)obj.state);
//}

    @Override
    public boolean equals(Object obj){ // we override Object's equals method
        return state.equals(((State)obj).state);
    } 
   // ...

	public String getState() {
		return state;
	}
	public void setStateString(String state) {
		this.state = state;
	}
	public String getStateString() {
		return this.state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public State getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
}
