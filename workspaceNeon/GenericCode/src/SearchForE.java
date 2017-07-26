import java.util.Scanner;


public class SearchForE {


	public String countE(String input){
		int count = 0;
		if (input.equals("")){
			return 0;
		}else if (input.charAt(0)=='e'){
		    count ++;
		    return count + countE(input.substring(1, input.length()));
		}else
		    return countE(input.substring(1,input.length()));
	}
    


	public static void main(String[] args) {

		System.out.println("Enter a sentence: ");
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();

		System.out.println(countE(sentence));
	}

}
