import java.util.Scanner;


public class MoveE {
	String sent;
	public static void main (String[] args){
		String sen;
		
		System.out.println("Give me a sentence.");
		Scanner sc=new Scanner(System.in);
		
		sen=sc.next();
		
		sc.close();
		String n = pushe(sen);
		System.out.println(n);
	}
	public static String pushe(String s){
		if (s.equals("")){
			return "";
		}
		else if (s.charAt(0)=='e'){
			return pushe(s.substring(1)+'e');
		}
		else {
			return s.charAt(0) + pushe(s.substring(1));
		}
	}
}
