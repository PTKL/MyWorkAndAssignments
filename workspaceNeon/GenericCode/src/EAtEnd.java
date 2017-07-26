import java.util.*;
public class EAtEnd {
    private static Scanner scanner;
    public static String End(String s)
    {
	if(s.equals("")) {
		return "";
	    }
	    if(s.toLowerCase().charAt(0) == 'e') {
		return End(s.substring(1)) + s.charAt(0); }
	    return s.charAt(0)+ End(s.substring(1));
	   

}

	public static void main(String[] args){
	    scanner= new Scanner(System.in);
	    String s = scanner.nextLine();
	    System.out.println(End(s));
	}
    }
