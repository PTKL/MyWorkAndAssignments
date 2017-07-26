public class StringStack {
	String[] arr;
	int top;

	// index of topmost element + 1
	public StringStack() {
		arr = new String[10];
		top = 0;
	}

	public boolean isEmpty() {
		return (top == 0);
	}

	public void push(String s) {
		arr[top] = s;
	}

	public String pop() {
		top = top - 1;
		return arr[top];
	}
}
