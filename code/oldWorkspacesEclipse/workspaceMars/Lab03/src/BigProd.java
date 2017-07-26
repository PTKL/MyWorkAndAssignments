import java.util.Scanner;

  class BigProd {
  
    public static void main (String [] args) {
    
      long prod = 1, i;
      
      Scanner kbd = new Scanner (System.in);
      
      do {
      
	System.out.println("Input an integer (enter 1 to exit): ");
	
	i = kbd.nextLong();
	
	System.out.println("i is " + i);
	
	prod *= i;
	
	System.out.println("The total product is " + prod);
	
      }
      
     while(i != 1); 
      
  }
  
}