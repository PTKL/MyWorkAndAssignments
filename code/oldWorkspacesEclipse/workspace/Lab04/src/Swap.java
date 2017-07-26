import java.util.Scanner;

class Swap {

	public static void main(String[] args){

		String s;

		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Enter string: ");

		s = kbd.nextLine();

		int length = s.length();

			if (length <= 1) {
				System.out.println(s);
			} else {
				System.out.println(s.charAt(length - 1) + s.substring(1, length - 1) + s.charAt(0));
				}
    }	
	
}
