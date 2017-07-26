
public class SelectionException extends Exception {
	
	public SelectionException (String message){
		super(message);
	}
	
	public SelectionException() {
		super("Error: Enter 1 or 2");
	}

}
