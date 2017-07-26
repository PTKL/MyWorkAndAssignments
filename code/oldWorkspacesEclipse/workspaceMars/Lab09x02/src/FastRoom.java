import java.util.ArrayList;
import java.util.HashSet;

public class FastRoom {
	public FastRoom(int cardinal) {
		this.cardinal = cardinal;
		this.birday = new HashSet<Integer>();

		for (int i = 0; i < cardinal; ++i) {
			Person person = new Person();
			if (!birday.add(person.getBirday()))
				break;
		}
	}

	public boolean sameBirthday() {
		return !(cardinal == birday.size());
	}

	private int cardinal;
	private ArrayList<Person> people;
	private HashSet<Integer> birday;
}
