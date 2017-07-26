import java.net.*;
import java.io.*;

public class HollomonClient {
	private static Socket socket;

	public static void main(String args[]) {
		try {
			String serverAddress = "teaching.cs.rhul.ac.uk";
			int port = 1801;
			InetAddress IPAddress = InetAddress.getByName(serverAddress);
			socket = new Socket(IPAddress, port);

			String storeUsernamePass = "zyvb263\nembata\n"; //username and password storage

			OutputStream output = socket.getOutputStream();
			OutputStreamWriter outWrite = new OutputStreamWriter(output);
			BufferedWriter write = new BufferedWriter(outWrite);

			String message = storeUsernamePass;
			write.write(message);
			write.flush();
			System.out
					.println("Enter username and password: " + "\n" + message);

			InputStream input = socket.getInputStream();
			InputStreamReader inRead = new InputStreamReader(input);
			BufferedReader read = new BufferedReader(inRead);
			String serverResponse = read.readLine();

			while ((serverResponse = read.readLine()) != null) {
				System.out.println(serverResponse);
			}
		} catch (Exception exception) {
			System.out.println("WRONG SERVER ADDRESS OR PORT!");
			exception.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
