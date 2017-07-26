
public class AutoChar {

	public static void main(String[] args) {
		Character xObject = 'a';
		Character yObject = 'a';
//		Character xObject = new Character('b');
//		Character yObject = new Character('b');
		
		//System.out.println(xObject.equals(yObject));
		//System.out.println(xObject.charValue() + "  " + yObject.charValue());
		
		if (xObject == yObject) {
			System.out.println("EAQUAL");
		} else {
			System.out.println("NOT EAQUAL");
		}
	}

}
