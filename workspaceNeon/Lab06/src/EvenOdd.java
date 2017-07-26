import java.util.Scanner;

class EvenOdd
{
  public static boolean even(int n)
  {
    return (n%2 == 0);
  }
  
  public static String parity(int n)
  {
    if ( even(n) ) {
      return "even";
    }   
    return "odd";
  }
  
  public static void printParity(int n) {
  
    System.out.println(n + " is " + parity(n));
  
  }
  
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = s.nextInt();

    //System.out.println(n + " is ");
    printParity(n);    
  }
}