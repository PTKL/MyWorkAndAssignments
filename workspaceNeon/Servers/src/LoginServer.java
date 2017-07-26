import java.io.*;
import javax.net.ssl.*;


public class LoginServer {
	private static final String CORRECT_USER_NAME = "Java";

	  private static final String CORRECT_PASSWORD = "HowToProgram";

	  private SSLServerSocket serverSocket;

	  public LoginServer() throws Exception {
	    SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
	        .getDefault();
	    serverSocket = (SSLServerSocket) socketFactory.createServerSocket(7070);

	  }

	  private void runServer() {
	    while (true) {
	      try {
	        System.err.println("Waiting for connection...");
	        SSLSocket socket = (SSLSocket) serverSocket.accept();
	        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	        String userName = input.readLine();
	        String password = input.readLine();

	        if (userName.equals(CORRECT_USER_NAME) && password.equals(CORRECT_PASSWORD)) {
	          output.println("Welcome, " + userName);
	        } else {
	          output.println("Login Failed.");
	        }
	        output.close();
	        input.close();
	        socket.close();

	      } catch (IOException ioException) {
	        ioException.printStackTrace();
	      }
	    }
	  }

	  public static void main(String args[]) throws Exception {
	    LoginServer server = new LoginServer();
	    server.runServer();
	  }
}
