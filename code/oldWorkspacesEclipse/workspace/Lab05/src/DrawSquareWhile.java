  import java.util.Scanner;

  class DrawSquareWhile
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the square: ");
      int n = s.nextInt();
      int i = 0;
      int j = 0;
      
      String line = "";
     
	while (i < n) 
	{
	  while (j < n)
	  {
	  
	  line += "o";
	  j++;
	  }

        System.out.println(line);
	i++;
	}
    
    }
  }