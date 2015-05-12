package view;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
	void doCommand(String arg) throws FileNotFoundException, ClassNotFoundException, IOException;
}
