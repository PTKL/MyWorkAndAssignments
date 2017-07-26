
public class StringBuilding {
	public static void main (String[] args){
		StringBuilder sb = new StringBuilder ( "abc" ) ;
		sb.append ( "a" ).append ( 3 ).append("c"); 
		sb.insert( 4 , "12" ); 
		sb.replace ( 3 , 4 , "0" ). delete ( 7 , 8 ) ; 
		sb.append ( sb.length ( ) ) ;
		sb.reverse ( ) ;
		String str = sb . toString ( ) ;
		System.out.println(str);
	}
}
