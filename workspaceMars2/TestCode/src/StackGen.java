public class StackGen<T> {
	int count = -1;
	
	public StackGen() {

	}
	
	public void push(T newPayload) {
		MyNode<T> n = new MyNode<T>(newPayload);
		n.next = n;
		newPayload = n;
	}
	
}
