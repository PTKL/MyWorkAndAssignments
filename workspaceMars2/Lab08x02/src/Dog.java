
public class Dog extends Canine implements Trained {
	public Dog(int packSize) {
		super(packSize);
	}

	public Dog(int packSize, String food) {
		super(packSize);
		addFood(food);

	}
	
	@Override
	public void sit() {
		System.out.println("Dog is sitting");
		
	}


	@Override
	public void stand() {
		System.out.println("Dog is standing");
		
	}

	@Override
	public void makeSound() {
		System.out.println("woof");

	}

}
