package model;

/**
* Interface of a Model, setting all the commands possible in "UserCommands".
* @author  Senia Kalma
* @since   4/5/2015
*/
public interface Model {
	void doDirCommand(String path);
	void doZipCommand(String filePath);
	void doUnZipCommand(String filePath);
	void doHuffmanCommpressCommand(String filePath);
	void doHuffmanDeCommpressCommand(String filePath);
	void doDicCommand(String fileName);
	void doUndicCommand(String fileName);
	void doSizeCommand(String path);
	
}
