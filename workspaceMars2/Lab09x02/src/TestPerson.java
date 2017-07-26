import java.util.ArrayList;

public class TestPerson {
	public static void main(String[] args) {
		ArrayList<Person> target = new ArrayList<Person>();
		boolean found = false;

		Person person = new Person();
		System.out.println(person);
		while (!found) {
			person = new Person();

			for (Person other : target) {
				if (other.sameBirday(person)) {
					found = true;
					break;
				}
			}

			target.add(person);
		}

		System.out.println("Before two with same birday " + target.size());
		person = new Person();
		System.out.println(person);
	}
}
