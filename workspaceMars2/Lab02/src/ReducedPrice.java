import java.util.Scanner;

  class ReducedPrice {
  
    public static void main(String [] args) {
  
    Scanner keys = new Scanner(System.in);
    
    int age;
    
    System.out.println("Enter age: ");
      
      age = keys.nextInt();
      
      if(age < 26 | age > 60) {
      
	System.out.println("Reduced!");
	
      }
      
      else {
      
	System.out.println("Full Price!");
	
      }
      
  }
  
}