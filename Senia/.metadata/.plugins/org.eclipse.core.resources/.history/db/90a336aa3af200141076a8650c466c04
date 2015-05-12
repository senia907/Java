package compression_algorithms;
import java.util.BitSet;

/**
* Hchar class used for easy storing while working on the Huffman Algorithem.
* Stores the count of appearances, the character(as a string), its BitSet representation and a string representation.
* @author  Senia Kalma
* @since   4/5/2015
*/
class Hchar{
	int count;
	String character;
	Hchar left=null,right=null;
	// an inefficient representation, change it to real bits!VV
	String binRep="";
    BitSet bits = new BitSet();
    
	@Override
	public int hashCode(){return character.hashCode(); }
}
