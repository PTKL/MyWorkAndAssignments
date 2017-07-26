class CompareArrays {

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
  
  public static void main (String [] args) {
  
    int [] x = {1, 2, 3};
    int [] y = {4, 5, 6, 7};
    int [] z = {4, 5, 6, 7};
    
    System.out.println("CompareArrays(x,y)" + equalArrays(x, y));
    System.out.println("CompareArrays(y,z)" + equalArrays(y, z));
    
  }
  
}
    