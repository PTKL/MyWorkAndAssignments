import java.util.Scanner;


public class Divisor {
	public static void main (String[] args){
		int p, q, gcd=1;
		String temp;
		System.out.println("Give me a number.");
		Scanner sc=new Scanner(System.in);
		temp=sc.next();
		p = Integer.parseInt(temp);
		System.out.println("Give me another number.");
		temp=sc.next();
		q = Integer.parseInt(temp);
		sc.close();
		if (q<p){
			for (int i=1; i<=q; i++){
				if (q%i==0 && p%i==0){
					gcd = i;
				}
			}
		}
		if (p<q){
			for (int i=1; i<=p; i++){
				if (q%i==0 && p%i==0){
					gcd = i;
				}
			}
		}
		System.out.println(gcd);
	}
}
