package controller;

/**
* Interface of a Command, that have to have the function of "doCommand"(gets a string with arguments).
* @author  Senia Kalma
* @since   4/5/2015
*/
public interface Command {
	void doCommand(String arg);
}
