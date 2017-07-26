import java.util.Scanner;


public class Sentence {
	
	String sent;
	public static void main (String[] args){
		String sen;
		int n;
		System.out.println("Give me a sentence.");
		Scanner sc=new Scanner(System.in);
		
		sen=sc.next();
		n = search(sen);
		
		sc.close();
		System.out.println("The sentence \""+sen+"\" has "+n+" times the character 'e'.");
	}
	public static int search(String sent){
		if (sent.equals("")){
			return 0;
		}
		else if (sent.charAt(0)=='e'){
			return 1 + search(sent.substring(1));
		}
		else {
			return search(sent.substring(1));
		}
	}
}
 