import java.util.Scanner;

class TestPalindrome {
	public static void main(String[] args) {
		Scanner keys = new Scanner(System.in);
		/*
		 * System.out.println ("hello world"); Pattern pattern = new Pattern(5);
		 * System.out.println(pattern.getPattern()); Pattern pattern2 = new
		 * Pattern("1010101000101111000101010");
		 * System.out.println(pattern2.getPattern());
		 * System.out.println(pattern2.removeDuplicates());
		 * System.out.println(pattern2.getPattern());
		 */

		while (true) {
			System.out.println("Is it a palindrome?");
			Pattern r = new Pattern(keys.nextLine());
			System.out.println(r.palindrome(r));
		}
	}
}