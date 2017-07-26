  import java.util.Scanner;

  class TriangleLeft
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the triangle: ");
      int n = s.nextInt();
      int i = 0;
      
      
      String line = "";
     
     while (i < n)
      {
      
	i++;
        line += "o";
        System.out.println(line);
        
      }

      
    }
  }
    
  