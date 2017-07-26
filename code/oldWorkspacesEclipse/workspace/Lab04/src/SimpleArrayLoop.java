import java.util.Scanner;

class SimpleArrayLoop {
	
		public static void main(String [] args) {
			
			String [] a = new String[3];
			
			String tempStore;
			
			Scanner scan = new Scanner(System.in);			
		
		for (int x = 0; x <= a.length - 1; x++) {
			
			System.out.println("Enter string (Limit is 3): ");
			
			a[x] = scan.nextLine();
			
		}
			
		
		for ( int i = 0; i < a.length - 1; i++) {
		System.out.println(a[i]);
		
		}
		System.out.println("array length is: " + a.length);
		}
}
