import java.util.Scanner;
class Exercise2 {
  private static int length;
  private static int Counter = 0;
  public static void main(String[] args) {
    String text;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a string");
    text = input.nextLine();
    length = text.length();
    e(text, 0);
    System.out.println(Counter);
  }
  
  public static void e(String input, int position) {
    int x = position;
    if (input.charAt(x) == 'e') {
      x++;
      Counter ++;
      if (x < length) {
	e(input, x);
      }
    }
    else {
      x++;
      if (x < length) {
	e(input, x);
      }
    }
  }
}