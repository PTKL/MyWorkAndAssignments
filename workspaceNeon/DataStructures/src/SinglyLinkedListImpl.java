public class SinglyLinkedListImpl<T> {

	private Node2<T> head;
	private Node2<T> tail;

	public void add(T element) {

		Node2<T> nd = new Node2<T>();
		nd.setValue(element);
		System.out.println("Adding: " + element);
		/**
		 * check if the list is empty
		 */
		if (head == null) {
			// since there is only one element, both head and
			// tail points to the same object.
			head = nd;
			tail = nd;
		} else {
			// set current tail next link to new Node2
			tail.setNextRef(nd);
			// set tail as newly created Node2
			tail = nd;
		}
	}

	public void addAfter(T element, T after) {

		Node2<T> tmp = head;
		Node2<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (true) {
			if (tmp == null) {
				break;
			}
			if (tmp.compareTo(after) == 0) {
				// found the target Node2, add after this Node2
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if (refNode != null) {
			// add element after the target Node2
			Node2<T> nd = new Node2<T>();
			nd.setValue(element);
			nd.setNextRef(tmp.getNextRef());
			if (tmp == tail) {
				tail = nd;
			}
			tmp.setNextRef(nd);

		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void deleteFront() {

		if (head == null) {
			System.out.println("Underflow...");
		}
		Node2<T> tmp = head;
		head = tmp.getNextRef();
		if (head == null) {
			tail = null;
		}
		System.out.println("Deleted: " + tmp.getValue());
	}

	public void deleteAfter(T after) {

		Node2<T> tmp = head;
		Node2<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (true) {
			if (tmp == null) {
				break;
			}
			if (tmp.compareTo(after) == 0) {
				// found the target Node2, add after this Node2
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if (refNode != null) {
			tmp = refNode.getNextRef();
			refNode.setNextRef(tmp.getNextRef());
			if (refNode.getNextRef() == null) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmp.getValue());
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void traverse() {

		Node2<T> tmp = head;
		while (true) {
			if (tmp == null) {
				break;
			}
			System.out.println(tmp.getValue());
			tmp = tmp.getNextRef();
		}
	}

	public static void main(String a[]) {
		SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		sl.addAfter(76, 54);
		sl.deleteFront();
		sl.deleteAfter(76);
		sl.traverse();

	}
}

class Node2<T> implements Comparable<T> {

	private T value;
	private Node2<T> nextRef;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node2<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node2<T> ref) {
		this.nextRef = ref;
	}

	@Override
	public int compareTo(T arg) {
		if (arg == this.value) {
			return 0;
		} else {
			return 1;
		}
	}
}