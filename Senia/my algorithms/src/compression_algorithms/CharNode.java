package compression_algorithms;
import java.io.Serializable;
import java.util.BitSet;

/**
* Used for easy storing the char and its BitSet representation.
* @author  Senia Kalma
* @since   3/5/2015
*/
public class CharNode implements Serializable {
	char ch;
	BitSet bitRep = new BitSet();
	int appr;

	public String toString(){
		String data="";
    	data+="Char: ";
		data+=ch;
    	data+=" is ";
		for(int j=0;j<(bitRep.length()-2);j++){	//the last bit=true as a placeholder, so we won't print it
			if((bitRep.get(j))==true)
	    		data+="1";
	    	else
	    		data+="0";
	    }
	    data+=(" in binary.\n");
	    
	    return data;
	}
}
