public class Calculator {

	public static void main(String[] args) {
		double variable1 = 8, variable2 = 4;
		char symbol = '/';
		switch (symbol) {
		case '+':
			System.out.print(variable1 + variable2);
			break;
		case '-':
			System.out.print(variable1 - variable2);
			break;
		case '*':
			System.out.print(variable1 * variable2);
			break;
		case '/':
			if (variable2 != 0) {
				System.out.print(variable1 / variable2);
			} else {
				System.out.print("You can't partition 0!");
			}
		default:
			System.out.print("Wrong operation!");
		}
	}

}
