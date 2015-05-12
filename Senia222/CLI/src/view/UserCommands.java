package view;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import compression_algorithms.Compressor;
import compression_algorithms.HuffmanAlg;
import compression_algorithms.WordDictionary;

/**
* The UserCommands class having the UserCommands as a Hashmap of a String and a Command.
* Used by the CLI for setting and calling the possible commands.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class UserCommands {
	
	private HashMap<String, Command> commands = new HashMap<String,Command>();
	
	public UserCommands(HashMap<String, Command> commands) {
		super();
		this.commands = commands;
	}

	 public void put(String string, Command command) {
		  commands.put(string, command);
	}
	public void clear(){
		commands.clear();
	}
	
	public UserCommands(){
		commands.put("dir", new DirCommand());
		commands.put("zip", new ZipCommand());
		commands.put("unzip", new UnZipCommand());
		commands.put("huf", new HuffmanCommpress());
		commands.put("unhuf", new HuffmanDeCommpress());
		commands.put("dic", new DicCommand());
		commands.put("undic", new UnDicCommand());
		commands.put("size", new Size());
		// add the other commands to the hash map...
	}
	
	public Command selectCommand(String commandName){
		return commands.get(commandName);
	}
	
	
	private class DirCommand implements Command{
		@Override
		public void doCommand(String path) {
			File file = new File(path);
			if (file.isFile()){
				System.out.println(file);
			}
			else{
				for (File f : file.listFiles()){
					System.out.println(f);
				}
			}
		}
	}
	
	private class ZipCommand implements Command{
		@Override
		public void doCommand(String filePath) {
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
				System.out.println("Zip Compressing Done");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
			}
		}
	}
	
	private class UnZipCommand implements Command{
			@Override
			public void doCommand(String filePath) {
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
					System.out.println("Zip DeCompressing Done");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
				}
			}		
		}
	
	private class HuffmanCommpress implements Command{
		@Override
		public void doCommand(String filePath) throws FileNotFoundException {
			Compressor huf = new HuffmanAlg();
			InputStream from = new FileInputStream(filePath);
			FileOutputStream file = (new FileOutputStream(filePath+".huf"));
			try {
				huf.compress(from,file);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Huffman Compressing Done");
		}
	}
	
	private class HuffmanDeCommpress implements Command{
		@Override
		public void doCommand(String filePath) throws ClassNotFoundException, IOException {
			Compressor huf = new HuffmanAlg();
			InputStream is = new FileInputStream(filePath);
			OutputStream good = new FileOutputStream(filePath.substring(0, filePath.length()-3));
			huf.deCompress(is, good);
			System.out.println("Huffman DeCompressing Done");
		}
	}
	
	private class DicCommand implements Command{
		@Override
		public void doCommand(String fileName) throws FileNotFoundException, ClassNotFoundException, IOException {
			WordDictionary wD = new WordDictionary();
			InputStream from = new FileInputStream(fileName);
			FileOutputStream file = (new FileOutputStream(fileName+".dic"));
			wD.compress(from,file);
			System.out.println("WordDictionary Compressing Done");
		}		
	}
	
	private class UnDicCommand implements Command{
		@Override
		public void doCommand(String fileName) throws ClassNotFoundException, IOException {			
			WordDictionary wD = new WordDictionary();
			InputStream is = new FileInputStream(fileName);
			OutputStream good = new FileOutputStream(fileName.substring(0, fileName.length()-3));
			wD.deCompress(is, good);
			System.out.println("WordDictionary DeCompressing Done");
		}		
	}
	
	private class Size implements Command{

		@Override
		public void doCommand(String path) {
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
			System.out.println("File size is: "+size);

		}
	}
	// all other commands...
}
