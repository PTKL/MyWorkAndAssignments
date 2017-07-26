import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;

public class Chuck {

	private static Scanner scan = new Scanner(System.in);
	private static Calendar cal = Calendar.getInstance();

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Internet Chuck Norris database!");
		System.out.println("Joke of the day:");
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(extractJoke(requestURL("http://api.icndb.com/jokes/"
				+ dayOfYear)));
		state();
	}

	public static String requestURL(String u) throws IOException {
		URL url = new URL(u);
		URLConnection connection = url.openConnection();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String temp;
		StringBuilder response = new StringBuilder();
		while ((temp = buffer.readLine()) != null) {
			response.append(temp);
		}
		buffer.close();
		String s = response.toString();
		return s;
	}

	public static String extractJoke(String json) {
		String s = "";
		if (json.contains("success")) {
			s = json.substring(json.indexOf("\"joke\": ") + 8,
					json.lastIndexOf(", \"c"));
			s = s.replaceAll("&quot;", "\"");
		} else
			System.out.println("Joke not found");
		return s;
	}

	public static void state() throws IOException {
		System.out.println("\n (-1) Quit (0) Random (n) Joke number n");
		System.out.println(" What do you want to do?");
		int i = scan.nextInt();
		if (i == -1) {
			System.out
					.println("Thanks for using the Internet Chuck Norris database!");
			return;
		} else if (i == 0)
			System.out
					.println(extractJoke(requestURL("http://api.icndb.com/jokes/random")));
		else if (i < -1) {
			System.out.println("Please enter one of the suggested values");
		} else
			System.out
					.println(extractJoke(requestURL("http://api.icndb.com/jokes/"
							+ i)));
		state();
	}
}
