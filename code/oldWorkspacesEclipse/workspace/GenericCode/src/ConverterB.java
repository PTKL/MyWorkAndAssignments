import java.util.Scanner;


public class ConverterB {
	

	private static Scanner keyboard;

	public static void main(String[] args) {
		
		double convertedValue;
		double poundValue;
		keyboard = new Scanner(System.in);
		System.out.println("How many Euros is in one pound?: ");
		double conversionRate = keyboard.nextDouble();
		do {
			System.out.println("Pound value (-1000 to quit): ");
			poundValue = keyboard.nextDouble();
			convertedValue = poundValue*conversionRate;
			System.out.println(poundValue + "pound" + "= " + convertedValue + " euro.");
		}while (poundValue != -1000);
		
			
		
	}

}
