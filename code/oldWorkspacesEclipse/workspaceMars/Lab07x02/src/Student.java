public class Student {

	private String name;
	private int id;
	private static int numberOfStudents = 0;

	public Student(String stuName, int stuID) {
		name = stuName;
		id = stuID;
		numberOfStudents++;

	}

	public static void setNumberOfStudents(int numberOfStudents) {
		Student.numberOfStudents = numberOfStudents;
	}

	public void setName(String stuName) {
		name = stuName;
	}

	public void setAge(int stuID) {
		id = stuID;

	}

	public String getName() {
		return name;

	}

	public int getID() {
		return id;
	}

	public static int getNumberOfStudents() {
		return numberOfStudents;
	}

}
