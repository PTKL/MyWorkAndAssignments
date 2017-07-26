public class MyNode<T> {
	public T payload;
	public MyNode<T> next;
	

	public MyNode(T payload) {
		this.payload = payload;
		next = null;

	}
}
