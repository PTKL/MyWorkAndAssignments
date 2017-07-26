import java.util.Scanner;

class StringLength {

  public static void main (String [] args) {
    
    Scanner kbd = new Scanner(System.in);
  
    System.out.print("Input a string: ");
  
    String a = kbd.nextLine();
    
    System.out.print("The length of \" "+a+ " \"is "+a.length() + ".");
  
  }

}