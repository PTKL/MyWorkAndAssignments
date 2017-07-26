import java.io.*;
import java.net.*;

public class TCPClient {
	
	public static void main(String argv[]) throws Exception {
		String userInput;
		String serverResponse;
		Socket clientSocket = new Socket("teaching.cs.rhul.ac.uk", 1801);

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter outToServer = new BufferedWriter( new OutputStreamWriter(
				clientSocket.getOutputStream()));
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		userInput = inFromUser.readLine();
		outToServer.write(userInput + '\n');
		serverResponse = inFromServer.readLine();
		System.out.println("FROM SERVER: " + serverResponse);
	}

}
