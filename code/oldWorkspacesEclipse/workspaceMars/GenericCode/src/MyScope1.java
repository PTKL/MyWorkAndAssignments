
public class MyScope1 {
	public static void main (String[] args){
		int x = 42;
		{
			int x = 1;
		}
		System.out.println(x);
	}
}

//x is already declared before the brackets