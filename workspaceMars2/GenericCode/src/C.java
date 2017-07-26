package another;
import one.A;

public class C {
//	static int w = 1;
//	private static int x = 2;
//	public static int y = 3;
//	protected static int z = 4;
	public static void main (String[] argv)
	{
		System.out.println(" w= " + A.w); //w is default so it's available in the package, C is in a different package.
		System.out.println(" x = " + A.x); //x is private so it's only available in A class.
		System.out.println(" y = " + A.y); //y is public so it's available in the whole program, when importing package.
		System.out.println(" z = " + A.z); //z is protected so it's available only in the package and the subclasses. C isn't a subclass.
	}
}

