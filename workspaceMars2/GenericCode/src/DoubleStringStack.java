public class DoubleStringStack {
    String[] arr;
    int top1;
    int top2;

    public DoubleStringStack() {
	arr = new String[10];
	top1 = 0;
	top2 = 5;
    }

    public void push1(String s) {
	arr[top1] = s;
	top1++;
    }

    public String pop1() {
	top1--;

	return arr[top1];
    }

    public void push2(String s) {
	arr[top2] = s;
	top2++;
    }

    public String pop2() {
	top2--;

	return arr[top2];
    }
}
