package model;

/**
* MyModel that implements Model, having all the functions set there, and a variable of the Controller for sending
* commands to him.
* @author  Senia Kalma
* @since   4/5/2015
*/
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

//import compression_algorithms.WordDictionary;
//import compression_algorithms.ZippedDir;

import compression_algorithms.Compressor;
import compression_algorithms.HuffmanAlg;
import compression_algorithms.WordDictionary;


//import view.Command;	Never Used
import controller.Controller;

public class MyModel implements Model {

	Controller c;
	
	public void setController(Controller c){
		this.c=c;
	}
	
	public void doDirCommand(String path) {
		File file = new File(path);
		if (file.isFile()){
			c.display(file);
		}
		else{
			for (File f : file.listFiles()){
				c.display(f);
			}
		}
	}

	public void doZipCommand(String filePath) {
		BufferedInputStream in;
		GZIPOutputStream out;
		try {
			in=new BufferedInputStream(new FileInputStream(filePath));
			byte[] data=new byte[100];
			out=new GZIPOutputStream(new FileOutputStream(filePath+".zip"));
			while((in.read(data))!=-1){
				out.write(data);
			}
			out.flush();
			out.close();
			in.close();
			c.display("Zip Compressing Done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
	}
	
	public void doUnZipCommand(String filePath) {
		BufferedOutputStream out;
		GZIPInputStream in;
		try {
			out=new BufferedOutputStream(new FileOutputStream(filePath.substring(0, filePath.length()-4)));
			byte[] data=new byte[100];
			in=new GZIPInputStream(new FileInputStream(filePath));
			while((in.read(data))!=-1){
				out.write(data);
			}
			out.flush();
			out.close();
			in.close();
			c.display("Zip DeCompressing Done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
	}		
	
	public void doHuffmanDeCommpressCommand(String filePath) {
		//Call for the HuffmanCommpress we made in "my algorithms" in Part A
		Compressor huf = new HuffmanAlg();
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		OutputStream good = null;
		try {
			good = new FileOutputStream(filePath.substring(0, filePath.length()-3));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			huf.deCompress(is, good);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.display("Huffman DeCompression finished");
	}
	
	public void doHuffmanCommpressCommand(String filePath) {
		//Call for the HuffmanDeCommpress we made in "my algorithms" in Part A
		Compressor huf = new HuffmanAlg();
		InputStream from = null;
		try {
			from = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		FileOutputStream file = null;
		try {
			file = (new FileOutputStream(filePath+".huf"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			huf.compress(from,file);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.display("Huffman Compression finished");
	}
	
	public void doDicCommand(String fileName) {			
		try {
			WordDictionary wD = new WordDictionary();
			InputStream from = new FileInputStream(fileName);
			FileOutputStream file = (new FileOutputStream(fileName+".dic"));
			wD.compress(from,file);
			c.display("WordDictionary Compression finished");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}			
	}
		
	public void doUndicCommand(String fileName) {			
		try {
			WordDictionary wD = new WordDictionary();
			InputStream is = new FileInputStream(fileName);
			OutputStream good = new FileOutputStream(fileName.substring(0, fileName.length()-3));
			try {
				wD.deCompress(is, good);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			c.display("WordDictionary DeCompression finished");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public void doSizeCommand(String path) {
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int size=0;
				try {
					while((in.read())!=-1){
						size++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		c.display("File size is: "+size);

	}

}
