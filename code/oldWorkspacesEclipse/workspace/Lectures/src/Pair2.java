public class Pair2 <T, U> 
{
	T left;
	U right;
	
	public Pair(T left, U right)
	{
		this.left = left;
		this.right = right;
	}
	
	public T getLeft()
	{
		return left;
	}
	
	public U getRight()
	{
		return right;
	}
	
	public String toString()
	{
		return "(" + left.toString() + ", " + right.toString() + ")";
	}
	
	public static void main(String[] args)
	{
		Pair<String, Integer> p = new Pair<String, Integer>("Hello", 5);
		System.out.println("The pair is: " + p.toString());
		System.out.println("The second Pair is: ");
	}
}
