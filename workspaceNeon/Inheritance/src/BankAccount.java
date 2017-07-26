//package Inheritance;

/**
 * A Bank account class.
 * 
 * @author Emil Tan
 */
public class BankAccount {
	private int balance; 
	
	public BankAccount(int initialDeposit) {
		balance = initialDeposit; 
	}
	
	public void deposit(int amount) {
		balance += amount; 
	}
	
	public void withdraw(int amount) {
		balance -= amount; 
	}
	
	public int getBalance() {
		return balance; 
	}
}
