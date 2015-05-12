package compression_algorithms;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
* Class containing a HashMap of string and an ArrayList of Integers used for storing data by the index of the word showed.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class ZippedDir extends HashMap<String, ArrayList<Integer>>
implements Serializable 
{

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (String word: this.keySet())
		{
			sb.append(word + ": ");
			ArrayList<Integer> indices = this.get(word);
			for (int index : indices){
				sb.append(index + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
