public class EmployeeDirectory {
	private Employee[] dir;
	private int size;
	private int actualNum;

	EmployeeDirectory(int n) {
		size = n;
		dir = new Employee[size];
	}

	public boolean add(String name, String position, double salary) {
		for (int i = 0; i <= dir.length; i++) {
			if (dir.equals(null)) {
				Employee employee = new Employee(name, position, salary);
				dir[i] = employee;
				actualNum++;
				return true;
			}
		}

		return false;
	}

	public void removeDuplicates() {
		Employee[] dir2 = new Employee[size];
		for (int i = 0; i < dir.length; i++) {
			for (int j = 0; j < dir.length; j++) {
				if (dir[i].equals(dir[j])) {
					if (i != j) {
						dir[i] = new Employee(null, null, 0);
					}
				} else {
					dir2[i] = dir[i];
				}
			}
		}
		for (int i = 0; i <= dir.length; i++) {
			dir[i] = dir2[i];
		}

	}

}