public class LocalVar {
	
	static int i;
	
  public static int sum(int[] arr) {
    int c = 0;
    for(i = 0; i < arr.length; i++) {
      c = c + arr[i];
    }
    System.out.println(i);
    return c;
  }
  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    System.out.println(sum(a));
   // System.out.println(i);
  }  
}
