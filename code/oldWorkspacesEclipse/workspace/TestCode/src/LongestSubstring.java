//В стринг да намерим дължината на най-дългата поредица от еднакви символи. // deivid dimitrov 

public class LongestSubstring { 
	public static void main(String[] args) {
		String string = "aavvvhfxghgdvvvvvvv";
		int maxLen = 0;
		int current = 0;
		int next = 0;
		for (int i = 0; i < string.length() - 1; i++) {
			next = i;
			while (string.charAt(i) == string.charAt(next)) {
				current++;
				i++;
				if (i == string.length())
					break;
			}
			i--;
			if (current > maxLen) {
				maxLen = current;
			}
			next = 0;
			current = 0;
		}
		System.out.println(maxLen);
	}
}