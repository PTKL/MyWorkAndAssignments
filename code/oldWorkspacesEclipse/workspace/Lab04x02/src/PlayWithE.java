import java.util.Scanner;

public class PlayWithE {
	public static int countE(String s) {
		if (s.length() == 0) {
			return 0;
		} else if (s.charAt(0) == 'e') {
			return 1 + countE(s.substring(1, s.length()));
		} else {
			return countE(s.substring(1, s.length()));
		}
	}

	public static String pushE(String s) {
		if (s.length() == 0) {
			return s;
		} else if (s.charAt(0) == 'e') {
			return pushE(s.substring(1)) + "e";
		} else {
			return s.charAt(0) + pushE(s.substring(1));
		}
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		String str;

		System.out.print("Enter a string: ");
		str = kbd.next();

		System.out.println(countE(str));
		System.out.println(pushE(str));

		kbd.close();
	}

}