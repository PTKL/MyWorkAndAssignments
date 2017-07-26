import java.io.*;
import java.net.*;

public class Server {
  private static int port=2236;

  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;
    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;
      while(true){
        Worker connection;
        server = listener.accept();
        connection = new Worker(server);
        Thread t = new Thread(connection);
        t.start();
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen:" + ioe);
      ioe.printStackTrace();
    }
  }
}
