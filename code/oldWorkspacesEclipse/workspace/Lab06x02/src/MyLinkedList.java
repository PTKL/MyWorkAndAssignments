class MyLinkedList<T> {
	private MyNode<T> top;

	public MyLinkedList() {
		top = null;
	}

	public void insertAtStart(T elt) {
		MyNode body = new MyNode(elt);
		body.next = top;
		top = body;
	}

	public void insertAtEnd(T elt) {
		MyNode runner = top;
		if (top == null) {
			top = new MyNode(elt);
		} else {
			MyNode<T> tempNode = top;

			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}

			tempNode.next = new MyNode(elt);
		}

	}

	public int size() {
		MyNode runner = top;
		int size = 0;
		while (runner != null) {
			size++;
			runner = runner.next;
		}
		return size;
	}

	public T read(int n) {
		MyNode<T> runner = top;
		for (int i = 0; i < n; i++) {
			runner = runner.next;
		}
		return runner.payload;
	}

	public static double sumList(MyLinkedList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.read(i);
		}
		return sum;
	}

	public static boolean sorted(MyLinkedList<Double> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.read(i) > list.read(i + 1))
				return false;
		}
		return true;
	}

	public String toString() {
		return "[" + top.toString() + "]";
	}

}