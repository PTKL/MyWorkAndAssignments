  import java.util.Scanner;
  
  class TwoDimArrayLines
    {
      public static void main(String[] args)
      {
      
	// making a Scanner
	Scanner kbd = new Scanner (System.in);
  
        // the dimensions of the array
        int m = 3, n = 4;
        
        // number for user input
        int lineNumb;
        
        System.out.println("Enter line number: ");
        
        // asking the user for input
        lineNumb = kbd.nextInt();

        // the array
        String [][] a = new String [m][n];
        
        // an auxiliary variable to print the array
        String line = "";
        
        // fill the 2-dim array
        for (int i = 0; i < m; i++)
        {
          for (int j = 0; j < n; j++)
          {
            a[i][j] = " "+ i + j;
          }
        }
        
        // print the 2-dim array
       
                  
          for (int j = 0; j < n; j++)
          {
         
            line += a[lineNumb][j];          
          }
          System.out.println(line);
          
        
        System.out.println("Number of lines: " + a.length);
      }
    }