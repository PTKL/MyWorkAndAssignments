
public class IntStack {
	int[] arr;
	int top, size;
	
	public IntStack(){
		arr = new int[10];
		top = 0;
	}
	
	public boolean isEmpty(){
		return (top == 0);
	}
	
	public int size(){
		return top + 1;
	}
	
	public void push(int s){
		try {
			arr[top] = s;
			top = top + 1;
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("stack is full");
		}
	}
	
	public int pop(){
		try {
			top = top -1;
			
		}
		catch (java.lang.ArrayIndexOutOfBoundsException b){
			System.out.println("top got less than 0");
		}
		return arr[top];
	}
}
