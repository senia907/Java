package controller;

import java.io.File;
import model.Model;
import view.Command;
import view.UserCommands;
import view.View;
/**
* Class of Controller, controlling a Model and a View, setting the commands in "UserCommands" and have the functions
* used in "UserCommands".
* @author  Senia Kalma
* @since   4/5/2015
*/

public class Controller {

	Model m;
	View v;
	
	public Controller(Model m, View v) {
		this.m=m;
		this.v=v;
	}
	
	/*public void zipFile(String fileName){	//ELIS
		m.zipfile(fileName);
	}*/
	
	
	public void display(String s){
		v.display(s);
	}
	
	public void display(File file) {	//New display
		v.display(file);
	}
	
	public void setConUserCommands(UserCommands commands){
		commands.clear();
		commands.put("dir", new ConDirCommand());
		commands.put("zip", new ConZipCommand());
		commands.put("unzip", new ConUnZipCommand());
		commands.put("huf", new ConHuffmanCommpress());
		commands.put("unhuf",(Command) new ConHuffmanDeCommpress());
		commands.put("dic", new ConDicCommand());
		commands.put("undic", new ConUnDicCommand());
		commands.put("size", new ConSize());
	}
	
	//Copy ===START===
	private class ConDirCommand implements Command{
		@Override
		public void doCommand(String path) {
			m.doDirCommand(path);
		}
	}
	
	private class ConZipCommand implements Command{
		@Override
		public void doCommand(String filePath) {
			m.doZipCommand(filePath);
		}
	}
	
	private class ConUnZipCommand implements Command{
			@Override
			public void doCommand(String filePath) {
				m.doUnZipCommand(filePath);
			}		
		}
	
	private class ConHuffmanCommpress implements Command{
		@Override
		public void doCommand(String filePath) {
			//Call for the HuffmanCommpress we made in "my algorithms" in Part A
			m.doHuffmanCommpressCommand(filePath);
		}
	}
	
	private class ConHuffmanDeCommpress implements Command{
		@Override
		public void doCommand(String filePath) {
			//Call for the HuffmanDeCommpress we made in "my algorithms" in Part A
			m.doHuffmanDeCommpressCommand(filePath);
		}
	}
	
	private class ConDicCommand implements Command{
		@Override
		public void doCommand(String fileName) {
			m.doDicCommand(fileName);
		}		
	}
	
	private class ConUnDicCommand implements Command{
		@Override
		public void doCommand(String fileName) {
			m.doUndicCommand(fileName);
		}		
	}
	
	private class ConSize implements Command{

		@Override
		public void doCommand(String path) {
			m.doSizeCommand(path);
		}
	}
	//Copy ===END===

}
