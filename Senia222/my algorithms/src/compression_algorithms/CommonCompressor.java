package compression_algorithms;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
* CommonCompressor implements Compressor
* @author  Senia Kalma
* @since   4/5/2015
*/

public abstract class CommonCompressor implements Compressor {
	@Override
	public abstract OutputStream compress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException;
	@Override
	public abstract OutputStream deCompress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException;

}
