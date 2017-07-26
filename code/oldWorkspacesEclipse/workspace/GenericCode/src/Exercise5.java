import java.util.Scanner;
class Exercise5 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x, y;
    System.out.println("Please enter an integer");
    x = input.nextInt();
    System.out.println("Please enter another integer");
    y = input.nextInt();
    System.out.println("Output" + ohoh(x, y));
  }
  
  public static int ohoh(int x, int y) {
    if (y == 0) {
      return 0;
    }
    else if (y % 2 == 0) {
      return ohoh(x * x, y / 2);
    }
    else {
      return (x * ohoh(x * x, y / 2));
    }
  }
}