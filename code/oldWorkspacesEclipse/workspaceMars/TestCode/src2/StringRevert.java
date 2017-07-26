
import java.util.Scanner;

public class StringRevert {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		int n;
		String string;

		System.out.print("Enter an integer: ");
		n = kbd.nextInt();

		String[] s = new String[n];

		for (int i = 0; i < s.length; i++) {
			System.out.println("Enter a String: ");
			string = kbd.next();

			if (string.equals("quit"))
				break;

			s[i] = string;
		}
		
		kbd.close();
		System.out.println();

		for (int i = s.length-1; i >= 0; i--) {
			if(s[i] != null)
				System.out.println(s[i]);
				
		}

	}

}
