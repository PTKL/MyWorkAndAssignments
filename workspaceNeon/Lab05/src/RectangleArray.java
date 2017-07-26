  import java.util.Scanner;

  class RectangleArray
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Enter height: ");
      int height = s.nextInt();
      System.out.print("Enter width: ");
      int width = s.nextInt();
            
      char [][] sq = new char [height][width];
      
      String line;

      // fill the array
      for (int i = 0; i < height; i++)
      {
        for (int j = 0; j < width; j++)
        {
          sq[i][j] = 'o';
        }
      }
      
      // print the array
      for (int i = 0; i < height; i++)
      {
        line = "";
        for (int j = 0; j < width; j++)
        {
          line += sq[i][j];
        }
        System.out.println( line );
      }
    }
  }