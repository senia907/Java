package compression_algorithms;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
* Simple Run(main) for testing Huffman Algorithm and WordDictionary Algorithm.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class Run {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Compressor huf = new HuffmanAlg();
		//String str = "mississippi river";
		String str = "Senia is kalma is a great man is working on man fucking is great stupid hours for the jave project hes doing with the great Bar Magnezi and senia is fellling that he actully learnt a shit or two";
		//String str="senia want to senia finish this shit and senia want to start pisika and senia dont want to eat";
		ByteArrayInputStream from = new ByteArrayInputStream(str.getBytes());
		//InputStream from = new FileInputStream("C:\\greg.txt");
		InputStream is = new FileInputStream("resources/file2.txt");
		//InputStream is = new FileInputStream("c:\\td.txt");
		FileOutputStream file = (new FileOutputStream("resources/java.txt"));
		huf.compress(is,file);
		
		System.out.println("\n===\nFinished compressing to: "+file.toString()+"\n===");
		is = new FileInputStream("resources/java.txt");
		OutputStream good = new FileOutputStream("resources/chars.txt");	//remove //
		//OutputStream good = new FileOutputStream("C:\\internetfinalqQQQQQQr.txt");
		huf.deCompress(is, good);
		/*System.out.println("Last Compress SHIT ==========");
		Compressor dic = new WordDictionary();
		dic.compress(from, file);
		System.out.println("finished WORDDIC compression");
		InputStream is = new FileInputStream("resources/java.txt");
		OutputStream good = new FileOutputStream("resources/chars.txt");
		dic.deCompress(is, good);
		System.out.println("FINALE");*/
	}

}
