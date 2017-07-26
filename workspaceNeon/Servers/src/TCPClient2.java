import java.io.*;
import java.net.*;

class TCPClient2 {
	public static void main(String args[]) throws Exception {
		String userName;
		String passWord;
		String loginInfo;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		System.out.println("Username: ");
		userName = inFromUser.readLine();
		outToServer.writeBytes(userName + '\n');

		System.out.println("Password: ");
		passWord = inFromUser.readLine();
		outToServer.writeBytes(passWord + '\n');

		loginInfo = inFromServer.readLine();
		System.out.println(loginInfo);

		clientSocket.close();
	}
}