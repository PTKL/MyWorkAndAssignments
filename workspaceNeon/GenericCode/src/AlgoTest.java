
public class AlgoTest {

	
	public static void main(String[] args) {
		Algo al = new Algo();
	
		al.randomArray(20, 20);
		System.out.println(Algo.isSorted(al.list));
		System.out.println("Max " + Algo.max(al.list, 0));
		System.out.println(al.list);
		Algo.sort(al.list);
		System.out.println(Algo.isSorted(al.list));
		System.out.println(al.list);
		System.out.println("Contains 14: " + Algo.linearSearch(al.list, 14));
		System.out.println(Algo.binarySearch(al.list, 12, 0, 19));
	}
}

