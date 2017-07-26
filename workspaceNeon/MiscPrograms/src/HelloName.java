import java.util.Scanner;

public class HelloName {

	public static void main(String[] args) {
		
		System.out.println("What is your name?");
		
		Scanner input = new Scanner(System.in);
		
		String name = input.next();
		
		input.close();
		
		System.out.println("Hello, " + name + "!");
		
	}

}
