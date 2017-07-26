import java.util.Scanner;

  class foreverConcat {
  
    public static void main (String [] args) {
    
      String bigString = "", a;
      
      Scanner kbd = new Scanner (System.in);
      
      do {
      
	System.out.println("Input a string (enter nothing to exit): ");
	
	a = kbd.nextLine();
	
	bigString += a;
	
	System.out.println("The string is " + bigString);
	
      }
      
      while(a.length() != 0);
      
  }
  
}