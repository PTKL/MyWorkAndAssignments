
public class TestStack {

	public static void main(String[] args) throws Overflow {
	
		StringStackArray myStack = new StringStackArray();
		
		myStack.push("!");
		myStack.push("world");
		myStack.push("Hello");
		
		System.out.println(myStack.size());
		
		for (int i = 0; i <= myStack.size() + 1; i++) {
			
			System.out.println(myStack.pop());
		}

	}

}
