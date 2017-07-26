import java.net.*;

public class Server {

	private static int port;

	// Listen for incoming connections and handle them
	public static void main(String[] args) {
		int i = 0;
		try {
			ServerSocket listener = new ServerSocket(port);
			Socket server;
			
//			 Worker job is to read the data coming from the socket and
//			to print it in the terminal. Worker should implement the runnable interface and have
//			a constructor that takes a Socket server as argument. Reminder: you can use the
//			method getInputStream from a Socket to read the data that is received.
			
//			while (true) {
//				Worker connection;
//				server = listener.accept();
//				Worker connection = new Worker(server);
//				Thread t = new Thread(conn_c);
//				t.start();
//			}

		} catch (Exception e) {
			System.out.println(" IOException on socket listen :" + e);
			e.printStackTrace();
		}
	}
}
