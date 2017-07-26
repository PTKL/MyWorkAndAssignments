
public class ohoh {
	public static void main (String[] args){
		System.out.println(ohoho(2, 20)); 
	}
	
	public static int ohoho(int x , int y ) {
	if ( y== 0) {
		return 0;
	} 
	else if ( y % 2== 0){
		return ohoho( x+x , y/2 );
		} 
	else {
		return ( x + ohoho( x+x , y/2 ) ) ;
		}
	}
}
