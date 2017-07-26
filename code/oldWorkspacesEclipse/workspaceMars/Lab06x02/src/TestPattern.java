import java.util.Scanner;

class TestPattern {
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
			System.out.println("Please input a positive integer:");
			int i = keys.nextInt();
			if (i < 0)
				break;
			Pattern p = new Pattern(i);
			System.out.println("A random series of 0's and 1's: \n"
					+ p.getPattern());

			Pattern q = new Pattern(p.removeDuplicates());
			System.out.println("With all the duplicates removed: \n"
					+ q.getPattern());
			System.out.println("Is it a palindrome?");
			Pattern r = new Pattern(keys.nextLine());
			System.out.println(r.palindrome(r));
		}
	}
}