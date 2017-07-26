  import java.util.Scanner;

  class Diagonals
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the square: ");
      int n = s.nextInt();
      
      String line;
     
      for (int i = 0; i <n; i++)
      {
        line = "";
        for (int j = 0; j < n; j++)
          if (i == j || i+j==(n-1))
          {
            line += "x";
          }
          else
          {
            line += "o";
          }
        System.out.println(line);
      }
    }
  }