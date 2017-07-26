import java.io.*;
import javax.net.ssl.*;

public class LoginClient {
	public LoginClient() {
	    try {
	      SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
	      SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost", 7070);
	      PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	      String userName = "name";
	      output.println(userName);
	      String password = "pass";
	      output.println(password);
	      output.flush();
	      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      String response = input.readLine();
	      System.out.println(response);

	      output.close();
	      input.close();
	      socket.close();
	    } catch (IOException ioException) {
	      ioException.printStackTrace();
	    } finally {
	      System.exit(0);
	    }
	  }

	  public static void main(String args[]) {
	    new LoginClient();
	  }
}
