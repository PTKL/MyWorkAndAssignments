class MyNode<T> {
	public T payload;
	public MyNode<T> next;

	public MyNode(T element) {
		payload = element;
		next = null;
	}

	public String toString() {
		return (payload + (next == null ? "" : "," + next));
	}
}