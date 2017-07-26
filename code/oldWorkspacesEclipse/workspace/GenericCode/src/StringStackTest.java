
public class StringStackTest {

	public static void main(String[] args) {
		StringStack linked = new StringStack("Hello");
		linked.push("there");
		linked.push("Ali");
		linked.print();
		//System.out.println(linked.pop());
		System.out.println(linked.peek());
		//System.out.println(linked.size());	
	}
}
