import java.util.Scanner;

  class BigSum {
  
    public static void main (String [] args) {
    
      long sum = 0, i;
      
      Scanner kbd = new Scanner (System.in);
      
      do {
      
	System.out.println("Input an integer (enter 0 to exit): ");
	
	i = kbd.nextLong();
	
	sum += i;
	
	System.out.println("The total sum is " + sum);
	
      }
      
      while(i != 0);
      
  }
  
}