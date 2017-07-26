import java.util.*;
import java.io.*;

public class Lorem {

	public static void main(String[] args) throws FileNotFoundException {

		File myfile = new File("loremIpsum.txt");
		Scanner kbd = new Scanner(myfile);

		String text = kbd.nextLine();

		List<String> list = Arrays.asList(text.split(" "));

		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			 if (Collections.frequency(list, word) != 1) {
			 System.out.println(word + ": " + Collections.frequency(list,
			 word));
			 }
			//System.out.println(word + ": " + Collections.frequency(list, word));

		}

		Map<String, Integer> countMap = new HashMap<>();

		for (String word : list) {
			Integer count = countMap.get(word);
			if (count == null) {
				count = 0;
			}
			countMap.put(word, (count.intValue() + 1));
		}

		System.out.println(countMap.toString());

	}
}
