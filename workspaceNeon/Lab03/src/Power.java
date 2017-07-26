import java.util.Scanner; 


class Power { 

  public static void main (String [] args) {
  
    int n;
    
    double a = 0,temp = 0;
    
     Scanner kbd = new Scanner(System.in);
	
      System.out.println("Enter number for n");
                
	n = kbd.nextInt();
	
	System.out.println("Enter number for a");	
	
	a = kbd.nextDouble();	
	temp = a;
	
	while(n <= 0) {
	System.out.print(n + " ");
	temp = temp / a;		
	n++;
	
	System.out.println(temp);
	}
	
	System.out.println(temp);
	
	 
  }
	
}
