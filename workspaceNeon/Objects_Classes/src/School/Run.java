package School;

public class Run {
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
		
		BankAccount acctA = new BankAccount();
		BankAccount acctB = new BankAccount(50);
		
		studentA.deposit(100);
		studentB.deposit(50);
		
		System.out.println("Student A has " + studentA.getBalance());
		System.out.println("Student B has " + studentB.getBalance());
		
		System.out.println("Account A has " + acctA.getBalance());
		System.out.println("Account B has " + acctB.getBalance());


	}

}
