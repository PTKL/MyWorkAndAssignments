public class Breadth {
	public static void main(String[] args) {
		Tree t = new Tree();
		String s = "qwertyuiop";
		int len = s.length();
		t.bst(s);
		t.infix();
		t.breadth();
		System.out.println("Breadth first search");
		System.out.println();
	}
}
