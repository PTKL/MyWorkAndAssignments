
public class DoubleStack {

	int[] arr;
	int top1, top2;

	public DoubleStack() {
		arr = new int[10];
		top1 = 0;
		top2 = 5;
	}
	
	public void push1(int s) {
		if (top1>arr.length-5){
			throw new Overflow();
		}
		arr[top1] = s;
		top1++;
	}
	
	public void push2(int s) {
		if (arr[top2] != null){
			throw new Overflow();
		}
		arr[top2] = s;
		top2--;
	}
	
	public int pop1(){
		String result = arr[top1].value;
		if (top1<0) {
		throw new Underflow();
		}
		top1--;	
		return result;	
	}
	
	public int pop2(){
		if (top2>9) {
		throw new Overflow();
		}
		top2++;	
		return arr[top2];	
	}
		
}


