  import java.util.Scanner;
  
  class FillArrayD
  {
    public static void main(String[] args)
    {   
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the length of the array: ");
      int n = s.nextInt();
      
      int [] a = new int[n];
      
      for (int i=0; i<n; i++)
      {
        a[i] = (int)Math.sqrt(i);
      }
  
      for (int i=a.length - 1; i >= 0; i--)
      {
		  if (a[i] % 2 == 0) {
			  
			  System.out.print(" 0 ");
		  }
		  
		  else {
			  
			  System.out.print(" 1 ");
		  }
        System.out.println("a[" + i + "] = " + (double)a[i]);			
      }
    }
  }
