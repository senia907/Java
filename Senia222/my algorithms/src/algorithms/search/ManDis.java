package algorithms.search;
/**
* The class of Heuristic that calculates the H by Manhatan distance
* @author  Senia Kalma
* @since   19/4/2015
*/
public class ManDis implements Heuristic {
	public ManDis(){
		super();
	}
	
	@Override
	public double calcH(State Cur, State End) {
		/**
		 * Calculatig the Manhaten distance between the Current position and the Goal(End) positen by finding
		 * the coordinates(i,j) of each state, Subtracting each i ad j, then multiplying by a step cost(10).
		 */
		double cost;
		String[] str = new String[6];
		str=Cur.getState().split(",");
		int si = Integer.parseInt(str[0]);
		int sj = Integer.parseInt(str[1]);
		str=End.getState().split(",");
		int ei = Integer.parseInt(str[0]);
		int ej = Integer.parseInt(str[1]);
		cost = ((ei-si)+(ej-sj)) *10;
		return cost;
	}

}
