  import java.util.Scanner;

  class SquareArray
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the square: ");
      int n = s.nextInt();
            
      char [][] sq = new char [n][n];
      
      String line;

      // fill the array
      for (int i = 0; i < n; i++)
      {
        for (int j = 0; j < n; j++)
        {
          sq[i][j] = 'o';
        }
      }
      
      // print the array
      for (int i = 0; i < n; i++)
      {
        line = "";
        for (int j = 0; j < n; j++)
        {
          line += sq[i][j];
        }
        System.out.println( line );
      }
    }
  }