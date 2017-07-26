  import java.util.Scanner;

  class TriangleRight
  {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the triangle: ");
      int n = s.nextInt();
      
      String line = " ";
       for (int i = n-1; i>=0  ; i--)
      {
        line = "";
        for (int j = 0; j < n; j++)
          if (j<i)
          {
          line += " ";
          }
          else
          {
            line += "o";
          }
     
	System.out.println(line);
	}
	
    }
  }
  
    
  
