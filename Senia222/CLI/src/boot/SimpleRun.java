package boot;

import java.io.BufferedReader;
//import java.io.FileReader; Never Used
//import java.io.FileWriter;	Never Used
import java.io.InputStreamReader;
import java.io.PrintWriter;

import view.CLI;

public class SimpleRun {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		CLI test = new CLI(reader, writer);
		try {
			test.start();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
