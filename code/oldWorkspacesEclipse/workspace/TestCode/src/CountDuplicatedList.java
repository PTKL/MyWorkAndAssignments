import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountDuplicatedList {
	public static void main(String[] args) throws FileNotFoundException {
		File myfile = new File("loremIpsum.txt");
		Scanner kbd = new Scanner(myfile);
		
		String tempStoreLine = kbd.nextLine();
		tempStoreLine.split(" ");
		String storeLine = tempStoreLine;

		kbd.close();
		
		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("b");
//		list.add("c");
//		list.add("a");
//		list.add("a");
//		list.add("a");
		list.add(storeLine);

//		System.out.println("\n Count 'a' with frequency");
//		System.out.println("a : " + Collections.frequency(list, "a"));

		System.out.println("\n Count all with frequency");
		Set<String> uniqueSet = new HashSet<String>(list);
		for (String temp : uniqueSet) {
			System.out.println(temp + ": " + Collections.frequency(list, temp));
		}

		System.out.println("\n Count all with Map");
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String temp : list) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		printMap(map);

		System.out.println("\n Sorted Map");
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		printMap(treeMap);

	}

	public static void printMap(Map<String, Integer> map) {

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}

	}
}
