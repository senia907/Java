package compression_algorithms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
* Interface of a Compressor, 2 main functions - compress and deCompress
* @author  Senia Kalma
* @since   4/5/2015
*/
public interface Compressor {
	public OutputStream compress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException;
	public OutputStream deCompress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException;
	

}
