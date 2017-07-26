  import java.util.Scanner;

  class OtherDiagonal
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the square: ");
      int n = s.nextInt();
      
      String line;
     
      for (int i = n - 1; i >= 0; i--)
      {
        line = "";
        for (int j = 0; j < n; j++)
          if (i == j)
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