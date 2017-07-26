
public class TestList {
	public static void main(String[] args) throws Underflow {
		
		StringStackList myList = new StringStackList();
		
		myList.push("!");
		myList.push("world");
		myList.push("Hello");
		
		System.out.println(myList.size());
		
		for (int i = 0; i <= myList.size() + 1; i++) {
			
			System.out.println(myList.pop());
		}

	}
}
