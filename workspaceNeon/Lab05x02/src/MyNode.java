public class MyNode<T> {

	public T payload;
	public MyNode<T> next;
	public MyNode<T> previous;
	public int size = 0;

	public MyNode(T payload) {
		this.payload = payload;

	}

	public MyNode(T payload, MyNode<T> next, MyNode<T> previous) {
		this.payload = payload;
		this.next = next;
		this.previous = previous;
	}

	public T getPayload() {
		return payload;
	}

	public MyNode<T> getNext() {
		return next;
	}

	public MyNode<T> getPrevious() {
		return previous;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public void setNext(MyNode<T> next) {
		this.next = next;
	}

	public void setPrevious(MyNode<T> previous) {
		this.previous = previous;
	}

}
