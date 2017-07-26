import java.util.Scanner;

  class Summing {
  
    public static void main(String [] args) {
  
    Scanner keys = new Scanner(System.in);
    int n, i, sum;
    
    i = 0;
    
    System.out.print("Input n: ");
    n = keys.nextInt();
    
    sum = 0;
    
    while (i <= n) {
    
      sum += i;
      i++;
      
    }
    
  System.out.println("The sum from 0 to " +n+ " is " +sum);
  
  if(n < 0) {
    
    System.out.println("Negative int detected");

    
  }
  
  }
  
 }