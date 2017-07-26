import java.util.Scanner;

class TestEmpty	 {

  public static void main (String [] args) {
    
    Scanner kbd = new Scanner(System.in);
  
    System.out.println("Input a string: ");
  
    String a = kbd.nextLine();
    
    if(a.isEmpty()) {
    
    System.out.println("The string is empty.");
    
    }
    
    else {
    
    System.out.println("The string you entered is: " + a);

    }
    
  }

}