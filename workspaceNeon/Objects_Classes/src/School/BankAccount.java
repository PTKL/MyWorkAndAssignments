package School;

public class BankAccount {
	
	private int balance;
	
	public BankAccount(){
		balance = 0;
	}
	
	public BankAccount(int initAmaount){
		balance = initAmaount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void withdraw(int amnt){
		balance -= amnt;
	}
	
	public void deposit(int amnt){
		balance += amnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
