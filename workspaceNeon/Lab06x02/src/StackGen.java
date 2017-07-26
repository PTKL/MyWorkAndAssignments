class StackGen<T> {
	private MyNode<T> top;

	public StackGen() {
		top = null;
	}

	public T pop() {
		T s = top.payload;
		top = top.next;
		return s;
	}

	public void push(T element) {
		MyNode body = new MyNode(element);
		body.next = top;
		top = body;
	}

	public T peek() {
		return top.payload;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		MyNode runner = top;
		int size = 0;
		while (runner.next != null) {
			size++;
			runner = runner.next;
		}
		return size;
	}
}