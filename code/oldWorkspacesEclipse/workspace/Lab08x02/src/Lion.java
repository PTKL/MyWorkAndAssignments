
public class Lion extends Feline implements Trained {
	
	

	public Lion() {
		super(5);
	}
	
	@Override
	public void sit() {
		System.out.println("Lion is sitting")
		;
	}

	@Override
	public void stand() {
		System.out.println("Lion is standing.");
		
	}

	@Override
	public void makeSound() {
		System.out.println("ROOOOAAARRR");
		
	}

}
