public class Employee {
	private String name;
	private String position;
	private double salary;

	Employee(String name, String pos, double salary) {
		this.name = name;
		this.position = pos;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return name + " : " + position + " : " + salary;
	}
}
