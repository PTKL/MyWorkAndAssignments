import java.util.ArrayList;
import java.util.Scanner;


public class List1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Enter a string please, enter q to quit.");
		while (read.hasNext("q") != true){
			System.out.println("Enter a string please, enter q to quit.");
			list.add(read.next());
		}
		for (int x = list.size() - 1; x >= 0; x--){
			System.out.println(list.get(x));
		}
		
		
	}

}
