import java.util.Scanner;

class Avarage {

  public static void main (String [] args) {
  
    int n; 
    double sum = 0.0;
    
    Scanner kbd = new Scanner (System.in);
  
    System.out.print("Input an integer: ");
    
    n = kbd.nextInt();
    
    if (n > 0)
    {
      for (int count = 1; count <= n; count++)
      {
      	sum += count;
		  
      }
      
      System.out.println("The avarage is: "+sum/(n+1));
    
    } 
    if(n == 0) 
    {
    
      System.out.println("The avarage is 0");
    }
  
  }

}