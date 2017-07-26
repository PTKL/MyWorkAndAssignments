import java.util.Scanner;

//Test Class to Test if the Dictionary class is working.
public class DictionatyTest {

	public static void main(String[] args) {
		Dictionary nary = new Dictionary("words.txt");

		Scanner kbd = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.print("Enter a word: ");
			String s = kbd.nextLine();
			if (!s.isEmpty()) {
				long startTime, elapsedTime;
				startTime = System.nanoTime();
				// call the method you want to measure
				System.out.println(nary.linearSearch(s));
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Command took " + elapsedTime / 1000
						+ " microseconds");
			}
			if (s.isEmpty()) {
				x = false;
			}
		}

	}

}
