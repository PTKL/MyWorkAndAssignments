import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadJokes {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("I have 2 bad programmer jokes.");
		System.out.print("Which do you want to read? (1 or 2)? ");

		try {
			int choice = keyboard.nextInt(); 
	
			if(choice < 1 || choice > 2) {
				throw new Exception("Please enter either 1 or 2.");
			}
			
			File jokeFile; 
			if(choice == 1) {
				jokeFile = new File("Files/ifjoke.txt"); 
			} else {
				jokeFile = new File("Files/whilejoke.txt");
			}

			Scanner fileReader = new Scanner(jokeFile);
			
			while(fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
			}
			
			fileReader.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error: Unable to read file. Contact the programmer.");
		} catch(InputMismatchException e) {
			System.out.println("Error: Please enter an integer.");
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}

		keyboard.close();
	}
}