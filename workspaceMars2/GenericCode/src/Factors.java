import java.util.*;

public class Factors {
	public static void main (String[] args){
		int num;
		
		System.out.println("Give me an integer.");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		sc.close();
		for (int i=2; i<num; i++){
			while (num%i==0){
				System.out.println(i);
				num=num/i;
			}
		}
	}
}
