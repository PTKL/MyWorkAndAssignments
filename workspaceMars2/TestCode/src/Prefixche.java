import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prefixche {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String words[] = new String[72235];
		int i = 0;
		Scanner readFromFile = null;

		readFromFile = new Scanner(new File("bg_utf8.txt"));

		while (readFromFile.hasNextLine()) {
			Scanner s2 = new Scanner(readFromFile.nextLine());
			while (s2.hasNext()) {
				String s = s2.next();
				words[i] = s;
				i++;
			}
		}

		Scanner readPrefix = new Scanner(System.in);
		String prefix;

		while (true) {
			System.out.println("Enter prefix:");
			prefix = readPrefix.next();

			for (int j = 0; j < i - 1; j++) {

				if (words[j] == null) {
					break;
				}
				if (words[j].startsWith(prefix)) {

					System.out.println(words[j]);
				}
			}

			System.out.println();
			System.out.println();

		}

	}

}
