public class PersonalBankAccount extends Person {
	private BankAccount bankAccount;

	public PersonalBankAccount(String personName, int personAge,
			String personGender, int initialDeposit) {
		super(personName, personAge, personGender);
		bankAccount = new BankAccount(initialDeposit);
	}

	public BankAccount getBankAcct() {
		return bankAccount;
	}
	
	

}
