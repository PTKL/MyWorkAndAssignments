import java.util.*;

public class CardTest {
	public static void main(String[] args) {

		Card c1 = new Card(001, "Emil", CardRank.UNCOMMON, 5);
		Card c2 = new Card(002, "Iva", CardRank.UNIQUE, 10);
		Card c3 = new Card(002, "Yavor", CardRank.RARE, 8);
		Card c4 = new Card(004, "Maya", CardRank.UNCOMMON, 5);
		Card c5 = new Card(005, "Zahari", CardRank.COMMON, 2);

		HashSet hashSet = new HashSet();
		hashSet.add(c1);
		hashSet.add(c2);
		hashSet.add(c3);
		hashSet.add(c4);
		hashSet.add(c5);

		System.out.println(hashSet.size());

		TreeSet treeSet = new TreeSet();
		treeSet.add(c1);
		treeSet.add(c2);
		treeSet.add(c3);
		treeSet.add(c4);
		treeSet.add(c5);

		System.out.println(treeSet.size());
	}
}
