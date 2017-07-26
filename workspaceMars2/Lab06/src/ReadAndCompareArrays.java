import java.util.Scanner;

class ReadAndCompareArrays {

  public static boolean equalArrays(int[] a, int[] b) {
  
    if (a.length == b.length) {
    
      for (int i = 0; i < a.length; i++) {
      
	if(a[i] == b [i]) {
	
	  return true;
	  
	}else {
	
	  return false;
	
	}
      
      }
  
    }
    
    return false;
  
  }
  static Scanner kbd = new Scanner(System.in);
  
  public static int[] readArray(int n) {
  
    int array = 0;
    
    int [] a = new int [n];
       
      System.out.println("Enter values: "); 
       
       for (int i = 0; i < n; i++) {
       
	  a[i] = kbd.nextInt();
       
       }
       
       return a;
  } 
  
  public static void main (String [] args) {
  
    System.out.println("Enter length of array x: ");
    int k = kbd.nextInt(); 
    int [] x = readArray(k);
    System.out.println("Enter length of array y: ");
    int t = kbd.nextInt();
    int [] y = readArray(t);
    System.out.println("Enter length of array z: ");
    int v = kbd.nextInt();
    int [] z = readArray(v);
    System.out.println("CompareArrays(x,y)" + equalArrays(x, y));
    System.out.println("CompareArrays(y,z)" + equalArrays(y, z));
    
  }
  
}
    