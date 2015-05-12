package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
* Class of CLI, having his Reader,Writer and the UserCommands Class he can make.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class CLI {
	private BufferedReader in;
	private PrintWriter out;
	private UserCommands userCommands;
	
	public CLI(BufferedReader in, PrintWriter out){
		this.in = in;
		this.out = out;
		this.userCommands = new UserCommands();
	}
	
	public CLI(BufferedReader in, PrintWriter out, UserCommands usCom){
		this.in = in;
		this.out = out;
		this.userCommands = usCom;
	}
	
	public void start() throws ClassNotFoundException{
		/**
		 * Starting the CLI, all user Interface is here.
		 */
		System.out.print("Enter command: ");
		try {
			String line = in.readLine();
			
			while (!line.equals("exit"))
			{
				String[] sp = line.split(" ");
								
				String commandName = sp[0];
				String arg = null;
				if (sp.length > 1)
					arg = sp[1];
				
				// Invoke the command
				Command command = userCommands.selectCommand(commandName);
				if(command==null)
					System.out.println("Command not found");
				else
					command.doCommand(arg);
				System.out.print("Enter command: ");
				line = in.readLine();
			}
			out.write("Goodbye");
						
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}	
	}
}
