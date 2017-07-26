import java.util.Scanner; 

class SquareSum {

  public static void main (String [] args) {
  
  	int y = 0, n, x = 0, i = 1;

      Scanner kbd = new Scanner(System.in);
	System.out.println("Enter number");
     
	  n = kbd.nextInt();
    
	

	
	while(i<=n) {
	
	 x = i*i;
	 
	 i++;
	 
	 y = y+x;
	  

	  
	  }
	  
	  	  System.out.println(y);
	  
  }
  
 }
	  
	  
  
    