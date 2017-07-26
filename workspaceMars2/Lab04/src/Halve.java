import java.util.Scanner;

class Halve {

	public static void main (String [] args) {
		
		String a;
		
		int length;
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		
		a = kbd.nextLine();
		
		length = a.length();
		
		char [] halve = a.toCharArray();
		
		for (int count = 0; count < length / 2; count++) {
		  
		  System.out.print(halve[count]);
		
		}
		
			
	}	
	
}
