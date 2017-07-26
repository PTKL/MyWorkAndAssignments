
public class Queue {
	String[] arr;
	int top , bot ;
	public Queue() {
		arr = new String [10] ;
		top = 0; bot = 0;
	}
	public void enqueue ( String s ) {
		arr [ bot ] = s ;
		if ( bot == arr.length -1){
			bot = 0;
		} else {
			bot = bot + 1;
		}
	}
	public String dequeue ( ) {
			String s = arr[top];
			if ( top == arr.length -1) {
				top = 0;
			} else {
				top = top + 1;
			}
		
		return s ;
	}
	public boolean isEmpty(){
		return (top == bot);
	}
	public int size(){
		int size = 0;
		for (int x = 0; x < 10; x++){
			if (arr[x] != null){
				size++;
			}
		}
		return size;
	}
}
