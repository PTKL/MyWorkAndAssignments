import java.io.*;
import java.util.*;

public class DrakeEquation {
	static File file = new File("drakeEquation.txt");
	static Scanner kbd = new Scanner(System.in);
	 
	public static void printContents(Scanner fileRead){
		while (fileRead.hasNextLine()) {
			System.out.println(fileRead.nextLine());
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner fileRead = new Scanner(file);
			printContents(fileRead);
		} catch (FileNotFoundException e) {
			System.out.println("File Missing or not found");
			e.printStackTrace();
		}
	}

}
