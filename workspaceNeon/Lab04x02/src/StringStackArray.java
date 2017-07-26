class StringStackArray {
	String[] a;
	int top;

	public StringStackArray() {
		a = new String[10];
		top = -1;
	}

	public void push(String s) throws Overflow {
		try {
			if (top == a.length) {
				throw new Overflow("Stack overflow");
			}
			top = top + 1;
			a[top] = s;

		} catch (Overflow e) {
			// System.out.println("Stack overflow");
			// e.Overflow();
			e.printStackTrace();
		}

	}

	public String pop() throws Underflow {

		
			if (top < 0) {
				throw new Underflow(null);
			}
			String s = a[top];
			top = top - 1;
			return s;
			

	}

	public boolean isEmpty() {

		if (a == null) {

			return true;

		}

		return false;
	}

	public int size() throws Underflow {
		
		if (top < 0) {
			throw new Underflow(null);
		}

		return top + 1;

	}
}

class Overflow extends RuntimeException {
	public Overflow(String message) {
		super("Stack overflow");

	}

	// public void Overflow() {
	// System.out.println("Stack overflow");
	//
	// }
}

class Underflow extends RuntimeException {
	public Underflow(String message) {
		super("Stack underflow");

	}

	// public void Underflow() {
	// System.out.println("Stack underflow");
	//
	// }
}
