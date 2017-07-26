import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DuplicateWordSearcher {

	public static void main(String[] args) throws FileNotFoundException {
		
		File myfile = new File("loremIpsum.txt");
		Scanner kbd = new Scanner(myfile);

		String text = kbd.nextLine();

		List<String> list = Arrays.asList(text.split(" "));

		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			System.out.println(word + ": " + Collections.frequency(list, word));
		}
	}

}
