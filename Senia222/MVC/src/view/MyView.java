package view;
import java.io.BufferedReader;
import java.io.File;
//import java.io.IOException; Never Used
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;

/**
* MyView Class that implements View, having their functions and a variable that saves his Controller for sending
* commands to him.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class MyView implements View{
	Controller c;
	
	public void setController(Controller c){
		this.c=c;
	}
	
	@Override
	public void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		UserCommands UsCom = new UserCommands();
		c.setConUserCommands(UsCom);	//Con for controller
		CLI cli = new CLI(reader, writer,UsCom);
		try {
			cli.start();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display(String s) {
		System.out.println(s);
	}

	@Override
	public void display(File file) {
		System.out.println(file);	
	}
}
