import java.util.ArrayList;

public class Room {
	public Room(int cardinal) {
		this.cardinal = cardinal;
		people = new ArrayList<Person>();
		for (int i = 0; i < cardinal; ++i) {
			people.add(new Person());
		}
	}

	public boolean sameBirthday() {
		for (Person person : this.people) {
			for (Person other : this.people) {
				if (person.sameBirday(other))
					return true;
			}
		}
		return false;
	}

	private int cardinal;
	private ArrayList<Person> people;
}
