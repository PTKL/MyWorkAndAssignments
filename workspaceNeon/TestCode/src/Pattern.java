import java.util.*;

public class Pattern {
	public String pattern;

	public Pattern(int n) {
		n = pattern.length(); // n is the length of the string

		Random randomGenerator = new Random(); // This creates a random element
		int ZeroOrOne = randomGenerator.nextInt(2);

		for (int i = 0; i <= n; i++) {
			String letter = pattern.substring(i, i);

			letter = "";

			if (ZeroOrOne == 0) {
				letter = letter + "0";
			} else {
				letter = letter + "1";
			}
		}
	}

	// private static boolean duplicates(Pattern p) {
	//
	// }

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
		pattern = "";
	}

}
