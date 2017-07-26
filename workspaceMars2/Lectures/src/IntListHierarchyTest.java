public class IntListHierarchyTest {

	public static void main(String[] args) {
		IntList l1 = new IntLinkedList();
		l1.add(5);
		l1.add(10);
		l1.add(15);
		l1.add(20);

		IntList l2 = new IntArrayList();
		l2.addAll(l1);

		System.out.println(l1);
		System.out.println(l2);
	}

}

abstract class IntList {

	public IntList() {
	}

	public void addAll(IntList other) {
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < size(); i++) {
			sb.append(get(i));
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

	public abstract void add(int value);

	public abstract int get(int index);

	public abstract int size();

}

class IntLinkedList extends IntList {

	private static class ListNode {
		// ...
		int value;
		ListNode next;

		ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}

		ListNode(int value) {
			this(value, null);
		}

		public int get(int i) {
			if (i == 0) {
				return value;
			} else {
				if (next == null) {
					throw new IndexOutOfBoundsException();
				} else {
					return next.get(i - 1);
				}
			}
		}

		public int size() {
			if (next == null) {
				return 1;
			} else {
				return 1 + next.size();
			}
		}

		public String toString() {
			String result = Integer.toString(value);
			if (next == null) {
				return result;
			} else {
				return result + ", " + next.toString();
			}
		}

	}

	private ListNode head;
	private ListNode last;

	public IntLinkedList() {
		head = null;
		last = null;
	}

	@Override
	public void add(int value) {
		if (head == null) {
			head = new ListNode(value);
			last = head;
		} else {
			last.next = new ListNode(value);
			last = last.next;
		}
	}

	@Override
	public int get(int index) {
		return head.get(index);
	}

	@Override
	public int size() {
		return head.size();
	}
}

class IntArrayList extends IntList {

	private int[] array;
	int size;

	public IntArrayList() {
		array = new int[10];
		size = 0;
	}

	@Override
	public void add(int value) {
		if (size >= array.length) {
			int[] newArray = new int[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size] = value;
		size++;
	}

	@Override
	public int get(int index) {
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}
}