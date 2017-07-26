import java.util.Scanner;
class Exercise3 {
  public static void main(String[] args) {
    String text;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a string");
    text = input.nextLine();
    System.out.println(e(text));
  }
  
  public static String e(String input) {
    String Word;
    if (input.equals(" ")) {
      Word = " ";
    }
    else if (input.charAt(0) == 'e') {
      Word = input.substring(1) + 'e';
    }
    else {
      Word = input.charAt(0) + e(input.substring(1));
    }
    return Word;
  }
}