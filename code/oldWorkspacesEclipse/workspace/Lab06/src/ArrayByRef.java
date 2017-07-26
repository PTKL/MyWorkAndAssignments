class ArrayByRef
{
  static void revArr( int[] a) // creating a void method with an algorithm to revers the array using an array of integers with the name "a" (void returns nothing)
  {
    int swap; // storing the values of the array in order to swap them 
    if (a.length > 1) { // cheking if there are values in the array
      for (int i=0; i<a.length/2; i++) // i is a counter and count until the middle of the array and increment i at every step
      {
        swap = a[i];// assigning swap with the current value stored at possition i of array a
        a[i] = a[a.length-i-1]; // swaping the contents of the array
        a[a.length-i-1] = swap; // storeing the new values in swap
      }
    }
  }
  
  static void printArr(int[] a) // method for printing algorithm for the array
  {
    for (int i=0; i<a.length; i++) // i is a counter we count until i is within the limits of the array and increment i at every step 
    {
      System.out.println(a[i]); // printing the current possition of the array currently stored in i
    }
  }
  
  public static void main(String[] args)
  {
    int[] order = {1, 2, 3, 4, 5}; // hardcoding the values of the array of name order
    revArr(order); // calling the method with the parameter of order   
    printArr(order); // calling the method with the parameter of order  
  }
}