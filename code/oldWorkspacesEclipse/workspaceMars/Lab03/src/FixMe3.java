import java.util.Scanner; 
class FixMe3 {
  public static void main(String[] args) {
   int x, y, quotient;

  Scanner kbd = new Scanner(System.in);

  System.out.print("First integer? ");
  x = kbd.nextInt();

  System.out.print("Second integer? ");
  y = kbd.nextInt();
  
  if (y == 0) {
  
    System.out.println("Can't be zero!");
  
  }
  
  else {

  quotient = x / y;
  System.out.println("The quotient is " + quotient);
  
  }
  }
}
