//package Inheritance;

/**
 * Use classes to create objects. 
 * 
 * @author Emil Tan
 */
public class Run {
	public static void main(String[] args) {
		Person personA = new Person("Emil", 25, "M");
		System.out.println(personA.getName() + ", " + personA.getAge() + ", " + personA.getGender()); 
		
		System.out.println(); 
		
		Person personB = new Person("Filippo", 20, "M"); 
		System.out.println(personB.getName() + ", " + personB.getAge() + ", " + personB.getGender());
		personB.yearOlder();
		System.out.println(personB.getName() + " is now " + personB.getAge());
		
		System.out.println("--- --- --- --- --- ---");
		
		BankAccount accountA = new BankAccount(50); 
		System.out.println("Account A has " + accountA.getBalance());
		accountA.deposit(150);
		System.out.println("Account A has now " + accountA.getBalance());
		
		System.out.println();
		
		BankAccount accountB = new BankAccount(100);
		System.out.println("Account B has " + accountB.getBalance());
		accountB.withdraw(20);
		System.out.println("Account B has now " + accountB.getBalance());
		
		System.out.println("--- --- --- --- --- ---");
		
		PersonalBankAccount personC = new PersonalBankAccount("Alice", 21, "F", 0);
		System.out.println(personC.getName() + ", " + personC.getAge() + ", " + personC.getGender());
		System.out.println("Balance: " + personC.getBankAcct().getBalance());
		personC.getBankAcct().deposit(100);
		System.out.println("Balance after deposit: " + personC.getBankAcct().getBalance());
		
		System.out.println();
		
		PersonalBankAccount personD = new PersonalBankAccount("Bob", 21, "M", 100); 
		System.out.println(personD.getName() + ", " + personD.getAge() + ", " + personD.getGender());
		System.out.println("Balance " + personD.getBankAcct().getBalance());
		personD.getBankAcct().withdraw(20);
		System.out.println("Balance after withdrawal: " + personD.getBankAcct().getBalance());
	}
}
