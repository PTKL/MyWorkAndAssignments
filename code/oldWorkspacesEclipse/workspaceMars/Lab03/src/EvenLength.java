import java.util.Scanner;

class EvenLength {

  public static void main (String [] args) {
    
    Scanner kbd = new Scanner(System.in);
  
    System.out.println("Input a string: ");
  
    String a = kbd.nextLine();
    
    if(a.length() % 2 == 0) {
    
    System.out.println("The string is: " + a);
    
    }
    
  }
  
}