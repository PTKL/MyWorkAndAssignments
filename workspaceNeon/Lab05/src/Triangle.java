import java.util.Scanner;

class Triangle
{
  public static void main(String args[])
  {
  
    int limit;
    
    Scanner kbd = new Scanner(System.in);
    
    System.out.println("Enter a size of the triangle: ");
    
    limit = kbd.nextInt();
    
    for (int i=0; i<limit; i++)
  {
     for (int k=1; k<limit-i; k++)
     {
        System.out.print(" ");
     }
     for (int j=0; j<i*2+1; j++)
     {
        System.out.print("o");
     }
     System.out.println("");
  }
  }

} 
