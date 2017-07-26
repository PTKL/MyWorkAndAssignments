public class Person {
	public Person() {
		this.ID = this.countOfPersons++;
		this.birday = (int) ((Math.random() * 730) % 365);
	}

	public boolean sameBirday(Person other) {
		return ((this.birday == other.birday) && (this.ID != other.ID));
	}

	public int getID() {
		return this.ID;
	}

	public int getBirday() {
		return this.birday;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			return ((Person) obj).getBirday() == this.birday;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ID " + this.ID + " Birday " + birday;
	}

	private static int countOfPersons = 0;
	private int ID;
	private int birday;
}