
public class MyScope2 {
	public static void main (String[] args){
		{
			int x = 1;
		}
		int x = 42;
		System.out.println(x);
	}
}

//x is declared inside the brackets and its scope is only in there, 
//which means that when the brackets close x is not available any more  