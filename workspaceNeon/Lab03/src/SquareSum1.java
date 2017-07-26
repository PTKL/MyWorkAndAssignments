import java.util.Scanner; 

class SquareSum1 {

  public static void main (String [] args) {
  
  	int y = 0, n, x = 0, i = 1;

      Scanner kbd = new Scanner(System.in);
	System.out.println("Enter number");
     
	  n = kbd.nextInt();
	  
	  do {
	
	 x = i*i;
	 
	 i++;
	 
	 y = y+x;
	  
	  System.out.println(y);
	  
	  }
	  
	  while(i<=n);
	  
  }
  
}