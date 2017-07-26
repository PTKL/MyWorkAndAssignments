import java.util.Scanner;

class GeneratePalindrome {
	public static void main(String[] args) {
		Scanner keys = new Scanner(System.in);

		Pattern p = new Pattern(5);
		do {
			p = new Pattern(5);
			System.out.println(p.getPattern());
		} while (!p.palindrome(p));
		System.out.println(p.getPattern());
	}
}