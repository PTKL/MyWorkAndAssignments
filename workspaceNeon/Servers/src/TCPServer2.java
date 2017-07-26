import java.io.*;
import java.net.*;

class TCPServer2 {
	public static void main(String args[]) throws Exception {

		ServerSocket welcomeSocket = new ServerSocket(6789);
		String login = "emil";
		String username;
		String username1;
		String password = "emil";
		String password1;
		boolean status = true;
		
		while (status) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			username = inFromClient.readLine();
			System.out.println("Username received: " + username);
			password = inFromClient.readLine();
			System.out.println("Password received: " + password);
			username1 = username.toUpperCase() + '\n';
			password1 = password.toUpperCase() + '\n';

			if (login.equals("emil") && password.equals("emil")) {
				outToClient.writeBytes("Hello " + username1);
			}

			else {
				outToClient.writeBytes("Invalid Username and/or password.");
				
			}

		}
	}
}