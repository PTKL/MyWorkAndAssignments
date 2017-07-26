public class TestQueue {

	public static void main(String[] args) {
		MyQueue<String> qStr = new MyQueue<String>();
		MyQueue<Integer> qInt = new MyQueue<Integer>();

		qStr.enqueue("hello");
		qStr.enqueue("world");
		System.out.println("Size of queue: " + qStr.size());
		System.out.println(qStr);
		
//		qStr.remove("hello");
//		System.out.println(qStr);

		qStr.insertAt(0, "!");
		System.out.println(qStr);
		
		qInt.enqueue(42);
		qInt.enqueue(3);
		System.out.println("Size of queue: " + qInt.size());
		System.out.println(qInt);

//		qInt.remove(42);
//		System.out.println(qInt);

		qInt.insertAt(1, 20);
		System.out.println(qInt);
		
		//System.out.println("After dequeue");

		//qStr.dequeue();
		//System.out.println("Size of queue: " + qStr.size());
		//System.out.println(qStr);
		
		//qInt.dequeue();
		//System.out.println("Size of queue: " + qInt.size());
		//System.out.println(qInt);

	}

}
