  import java.util.Scanner;

  class DrawSquare
  {
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print("Size of the square: ");
      int n = s.nextInt();
      
      String line = "";
     
      for (int i = 0; i < n; i++)
      {
        line += "o";
      }
      
      for (int i = 0; i < n; i++)
      {
        System.out.println(line);
      }
    }
  }