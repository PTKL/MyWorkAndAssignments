package School;

public class Student {

	private String name;
	private int age;
	private String gender;
	private String department;
	private int year;
	private BankAccount bankAccount;

	// Constructor //

	public Student() {
		bankAccount = new BankAccount();

	}

	public Student(String stuName, int stuAge, String stuGender,
			String stuDepartment) {
		name = stuName;
		age = stuAge;
		gender = stuGender;
		department = stuDepartment;
		bankAccount = new BankAccount();
	}
	
	public int getBalance(){
		return bankAccount.getBalance();
	}
	
	public  void deposit(int addAmnt) {
		bankAccount.deposit(addAmnt);
	}

	public void yearOlder() {
		age++;
	}

	public void setName(String stuName) {
		name = stuName;
	}

	public void setAge(int stuAge) {
		age = stuAge;

	}

	public void setGender(String stuGender) {
		gender = stuGender;

	}

	public void setDepartment(String stuDepartment) {
		gender = stuDepartment;

	}

	public String getName() {
		return name;

	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;

	}

	public String getDepartment() {
		return department;

	}

	public static void printNameXTimes(String aName, int freq) {
		for (int i = 0; i < freq; i++) {
			System.out.print(aName + " ");
		}
	}

	public static void main(String[] args) {

		Student studentA = new Student("Emil", 19, "M", "CS");

		Student studentB = new Student();
		studentB.setName("Filippo");
		studentB.setAge(20);

		System.out.println("Name " + studentA.getName() + " Age "
				+ studentA.getAge() + " Gender " + studentA.getGender()
				+ " Department " + studentA.getDepartment());

		System.out.println(studentB.getName() + " was " + studentB.getAge());

		studentB.yearOlder();
		System.out.println(studentB.getName() + " is now " + studentB.getAge());
		printNameXTimes(studentA.getName(), 4);
		printNameXTimes(studentB.getName(), 6);
	}

}
