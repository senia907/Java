package view;

import java.io.File;

/**
* Interface of a View, with 2(3) basic commands, a start of the CLI, and displaying data.
* @author  Senia Kalma
* @since   4/5/2015
*/

public interface View {
	void start();
	void display(String s);
	void display(File file);
}
