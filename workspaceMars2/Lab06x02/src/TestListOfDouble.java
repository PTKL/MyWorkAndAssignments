import java.util.Collection;
import java.util.Collections;

class TestListOfDouble {
	public static MyLinkedList<Double> list = new MyLinkedList<Double>();
	public static MyLinkedList<Double> list2 = new MyLinkedList<Double>();

	public static void main(String[] args) {
		// MyLinkedList<String> test = new MyLinkedList<String>();
		// test.insertAtStart("!");
		// test.insertAtStart("Hello");
		// test.insertAtStart("World");
		// test.insertAtStart("Yavorov");
		// test.insertAtEnd("Emil");
		// for (int i = 0; i < test.size(); i++) {
		// System.out.println(test.read(i));
		// }
		// System.out.println(test.size());

		list.insertAtEnd(3.0);
		list.insertAtEnd(5.0);
		list.insertAtEnd(6.0);
		list.insertAtEnd(9.0);

		list2.insertAtEnd(1.0);
		list2.insertAtEnd(4.0);
		list2.insertAtEnd(5.0);
		list2.insertAtEnd(8.0);
		
		System.out.println("list 1");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.read(i));
		}
		
		System.out.println("list 2");

		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.read(i));
		}

		System.out.println("size list1: " + list.size());
		System.out.println("size list2: " + list2.size());
		System.out.println("sum list1: " + MyLinkedList.sumList(list));
		System.out.println("sum list2: " + MyLinkedList.sumList(list2));
		System.out.println("sorted list1: " + MyLinkedList.sorted(list));
		System.out.println("sorted list2: " + MyLinkedList.sorted(list2));
		System.out.println("merged list1 and list2: " + merge(list, list2));

	}

	public static MyLinkedList<Double> merge(MyLinkedList<Double> list,
			MyLinkedList<Double> list_two) {
		MyLinkedList<Double> newList = new MyLinkedList<Double>();
		int list_one_pos = 0;
		int list_two_pos = 0;
		while (newList.size() < (list.size() + list_two.size())) {
			if ((!(list_two_pos < list_two.size()))
					|| (list_one_pos < list.size())
					&& list.read(list_one_pos) <= list_two.read(list_two_pos)) {
				newList.insertAtEnd(list.read(list_one_pos++));
			} else if ((!(list_one_pos < list.size()))
					|| (list_two_pos < list_two.size())
					&& list.read(list_one_pos) > list_two.read(list_two_pos)) {
				newList.insertAtEnd(list_two.read(list_two_pos++));
			}
		}
		return newList;
	}

}