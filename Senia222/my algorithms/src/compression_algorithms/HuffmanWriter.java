package compression_algorithms;
import java.io.IOException;
import java.io.Writer;

/**
* Not working HuffmanWriter(Mesima b Matala2)-Approved by Eli.
* @author  Senia Kalma
* @since   4/5/2015
*/

public class HuffmanWriter extends Writer {

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(char[] arg0, int arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		
	}
	/*Writer destination;
	HuffmanAlg c;
	public void MyCompressorWriter(Writer destination) {
		this.destination=destination;
		c=new HuffmanAlg();
	}
	@Override
	public void close() throws IOException {
		destination.close();
	}

	@Override
	public void flush() throws IOException {
		destination.flush();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// we should take LEN chars form cbuf, starting from OFF index
		// compress them, and write them to the destination
		
		String inputString=new String(cbuf,off,len);	//string with the input
		ObjectInputStream In = null;
		ObjectOutputStream out = null;
		
		((ObjectOutput) In).writeObject(inputString);
		//out.writeObject(DicArr);
		
		c.compress(In,out);
		
		ArrayList<CharNode> DicArr = new ArrayList<CharNode>();	//ArrayList holding Huffmans dictionary
		ObjectInputStream in1 = new ObjectInputStream(In);
		try {
			DicArr = (ArrayList<CharNode>) in1.readObject();	//Setting DicArr as the sent data from the compress
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BitSet bits = new BitSet();		//BitSet holding the BitSet of the huffman compressed data
		ObjectOutputStream in2 = new ObjectOutputStream(out);
		bits = in2.readObject();	//Setting bits as the sent data from the compress
		destination.write(DicArr.toString());
		destination.write((bits.get(0,bits.length()-1)).toString());	//last bit=true as a placeholder
		
		//destination.write(my.toCharArray());	
		
		/*	ELI =START=
		byte[] uncompressed=new String(cbuf,off,len).getBytes();
		//byte[] compressed=c.compress(uncompressed);
		destination.write(new String(compressed).toCharArray());	=END=	
	}*/

}
