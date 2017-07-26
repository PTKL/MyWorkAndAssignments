public class OutputRowsandColumns
{
  public static void main(String[] args) {
  int cols = 10;
  int rows = 10;
      int[][] myArray = new int[cols][rows];

// Two nested loops allow us to visit every spot in a 2D array.   
// For every column I, visit every row J.
    for (int i = 0; i < cols; i+=2){
      for (int j = 0; j < rows; j++){
        myArray[i][j] = 1;
        System.out.println(myArray[i][j]);
		}
	}
        
  }
}
