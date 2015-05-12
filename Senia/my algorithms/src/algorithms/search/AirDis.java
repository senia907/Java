package algorithms.search;
/**
* The class of Heuristic that calculates the H by air distance
* @author  Senia Kalma
* @since   19/4/2015
*/
public class AirDis implements Heuristic {
	public AirDis(){
		super();
	}
	
	@Override
	public double calcH(State Cur, State End) {
		/**
		 * Calculates the Heuristic by Air distance method.
		 */
		double cost;
		String[] str = new String[2];
		str=Cur.getState().split(",");
		int si = Integer.parseInt(str[0]);
		int sj = Integer.parseInt(str[1]);
		str=End.getState().split(",");
		int ei = Integer.parseInt(str[0]);
		int ej = Integer.parseInt(str[1]);
		cost = ( Math.sqrt( (Math.pow((double)ei-(double)si,2))+Math.pow((double)ej-(double)sj,2) ) ) *10;
		return cost;
	}

}
