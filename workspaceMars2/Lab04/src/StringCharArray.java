class StringCharArray { 
	
	public static void main ( String [] args ) {
		
	String s = "world";
	
	System.out.println(s);

	char[] a = s.toCharArray();

	for(int i = 0; i < a.length ; i++)

		System.out.println(a[i]);

	}
	
}
