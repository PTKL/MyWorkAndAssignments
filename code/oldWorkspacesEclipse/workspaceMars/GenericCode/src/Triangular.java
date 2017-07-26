import java.util.Scanner;


public class Triangular {
	public static void main (String[] args){
		int n, Tn=0, m=0;
		String temp;
		System.out.println("Give me a number.");
		Scanner sc=new Scanner(System.in);
		temp=sc.next();
		n = Integer.parseInt(temp);
		sc.close();	
		while (m<=n){
			Tn = m + Tn;
			m = m+1;
		}
		
		System.out.println("The " +n+" th triangular number is "+Tn);
	}
}
