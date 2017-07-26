import java.util.Scanner;

  class ReadNumber {
  
    public static void main(String [] args) {
    
      Scanner keys = new Scanner(System.in);
      
      int x;
      
      System.out.print("Enter a number: ");
      
      x = keys.nextInt();
      
      System.out.println("The number is " + x);
  
    }
    
  }