public class Stack {
    int[] stackArray;

    public static void main(String[] args) {
	try {
	    if (size() < 0)
		throw new RuntimeException("Underflow.");
	} catch(RuntimeException e) {
	    System.out.println(e.getMessage());
	}
    }

    public boolean isEmpty() {
	if (stackArray.length == 0)
	    return true;
	else
	    return false;
    }

    public int size() {
	return stackArray.length;
    }
}
