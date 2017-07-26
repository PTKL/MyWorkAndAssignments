// calculator for add, subtract, multiply divide, modulus

import java.util.Scanner;

public class Calcii {

		public static int add(int a, int b) {
			
			int c = a + b;
		
			return c;
			
		}
	
		public static int sub(int a, int b) {
			
			int c = a - b;
		
			return c;
			
		}
		
		public static int mul(int a, int b) {
			
			int c = a * b;
			
			return c;
			
		}
		
		public static int div(int a, int b) {
			
			int c = a / b;
			
			return c;
			
		}
		
		public static int mod(int a, int b) {
			
			int c = a % b;
			
			return c;
			
		}
		
		public static void printf(String text) {
			
			System.out.println(text);
					
		}
		
		public static void main(String [] args) {
			
			printf("options in my calculator");
			printf("1 --> (+) addition (+)");
			printf("2 --> (-) subtraction (-)");
			printf("3 --> (*) multyplication (*)");
			printf("4 --> (/) division (/)");
			printf("5 --> (%) modulus (%)");
			
			printf("choose the number you want --> ");
			Scanner kbd1 = new Scanner (System.in);
			
			int a = kbd1.nextInt();
			
			printf("choose the number you want --> ");
			Scanner kbd2 = new Scanner (System.in);
			
			int b = kbd2.nextInt();
			
			printf("choose the number you want --> ");
			Scanner kbd3 = new Scanner (System.in);
			
			int c = kbd3.nextInt();
			
			int z = 0;
			
			switch(c) {
				
				case 1: z = add(a, b);
					break;
					
				case 2: z = sub(a, b);
					break;
					
				case 3: z = mul(a, b);
					break;
					
				case 4: z = div (a, b);
					break;
					
				case 5: z = mod (a, b);
					break;
					
				default: printf("Wrong choice");
					break;
					
			}
			
			printf("The result is: " + z);
			
			printf("Press 6 to continue");
			
			Scanner kbd = new Scanner (System.in);
			
			int r = kbd.nextInt();
			
			if (r == 6) {
			
					String [] s = null;
					
					main(s);
				
			}
				
		}
			
}
