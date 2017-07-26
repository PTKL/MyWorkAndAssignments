import java.util.Scanner;

  class Conversion {
  
    public static void main(String [] args) {
    
    Scanner keys = new Scanner(System.in);
    
    int c;
    
    System.out.print("Enter a temp in Celsius: ");
    
    c = keys.nextInt();
    
    System.out.println("The temp in Fahrenheit is: " +((9*c/5)+32));
    
   }
   
 }