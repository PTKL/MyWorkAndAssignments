import java.util.*;

public class Currency {
	public static void main (String[] args){
		float rate, pounds, euro;
		String temp, temp2;
		System.out.println("Give me the EUR to GBP exchange rate");
		Scanner sc=new Scanner(System.in);
		temp=sc.next();
		rate=Float.parseFloat(temp);
		
		System.out.println("Exchange rate: "+rate);
		
		do {
			System.out.println("Give me pound values (-1000 to quit)");
			temp2=sc.next();
			if (temp2.equals("q")){
				System.out.println("I am going to quit");
				System.exit(0);
				//System.out.println("it works again");
			}
			
			pounds=Float.parseFloat(temp2);
			euro=pounds*rate;
			System.out.println(pounds+" GBP = "+euro+" EUR");
		}
		while (temp2!="q");
		sc.close();
	}
}
