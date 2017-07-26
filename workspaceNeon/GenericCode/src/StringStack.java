import org.w3c.dom.Node;

public class StringStack {
	Node next;
	Node head;
	int size;
	String val;
	
	
	public StringStack(String s){
		val = s;
		next = null;
	}
}
