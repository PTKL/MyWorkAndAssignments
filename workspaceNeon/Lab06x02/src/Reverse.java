import java.util.Scanner;

class Reverse {
	public static void main(String[] args) {
		StackGen<String> stack = new StackGen<String>();

		Scanner keys = new Scanner(System.in);
		String temp = "";
		do {
			stack.push(temp);
			temp = keys.next();

		} while (!temp.equals("q") && !temp.equals("Q"));

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
}