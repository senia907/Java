package compression_algorithms;
import java.io.IOException;
import java.io.Reader;

/**
* Not working HuffmanReader(Mesima b Matala2)-Approved by Eli.
* @author  Senia Kalma
* @since   4/5/2015
*/

public class HuffmanReader extends Reader{

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	/*Reader source;
	byte bufferSize=100;
	char[] charsReadFromSource;
	LinkedList<Byte> queue;
	HuffmanAlg c;
	
	public void MyCompressorReader(Reader myReader) {// decorator pattern!
		this.source=myReader;
		charsReadFromSource=new char[bufferSize];
		queue=new LinkedList<Byte>();
		c=new HuffmanAlg();
	}
	@Override
	public void close() throws IOException {	// we use source to do everything
		source.close();
		
	}
	
	// except the things we want to manipulate, e.g., the read method
	

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return len;
		// we assume the source is compressed
		// we want to read X bytes from the source, and feed our reader (cbuf) with
		// LEN uncompressed bytes starting from OFF (the offset index)
		
		// we should note that every read from the source shifts the read-cursor ahead
		// thus, we use two buffers, one for the source bytes read, the other for the decomprssed data
		// the source is an array of chars (we handle a Reader after all...)
		// the decompressed buffer should be handled as a queue
		
		int r=0;
		// let's read from the source 100 chars as long it is not the end and the queue has less than LEN chars inside
		while((r=source.read(charsReadFromSource))!=-1 && queue.size()<len){			
			byte[] compressed=new String(charsReadFromSource).getBytes();	// chars -> bytes
			byte[] decompressed=c.decompress(compressed);	// decompress bytes
			
			// put the decompressed data in the queue
			for(int i=0;i<decompressed.length;i++)
				queue.add(decompressed[i]);
		}
		if(queue.size()==0)
			return -1;
		// pull out LEN items from the queue and put the in cbuf
		int count=Math.min(len, queue.size());
		for(int i=0;i<count;i++)
			cbuf[i+off]=(char)queue.remove().byteValue();
		return count;
	}*/
}
