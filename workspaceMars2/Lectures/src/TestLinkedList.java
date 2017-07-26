import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		// Creation of an LinkedList
		LinkedList<String> list = new LinkedList<String>();
		// Adding a value at the end
		list.add("Hello");
		list.add("World");
		// stack operations
		list.push("!");
		String s = list.pop();
		// Get methods
		String t = list.getFirst();
		String y = list.getLast();
	}

}



	/*//Finds the minimum element in list beginning from start
	private static int findMin(ArrayList<Integer> list, int start) {
		int min = start;
		for (int i = start; i < list.size(); i++) {
			if(list.get(i) < list.get(min)){
			min = i;
			}
		}
return min;
	}
// Selection sort
	public static void sort(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			int minIndex = findMin(list,i);
			// swap the minimum with i-th element
			Integer temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex,temp);
		}
	} 
	
	ArrayList<BankAccount> accounts = ...;
 double sum = 0;
 for (BankAccount a : accounts) {
 sum = sum + a.getBalance();
 } is equal to
 
 for (int i = 0; i < accounts.size(); i++) {
 BankAccount a = accounts.get(i);
 sum = sum + a.getBalance();
 } 
 
 */

