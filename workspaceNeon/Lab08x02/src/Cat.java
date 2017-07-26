class Cat extends Feline {
//	public Cat() {
//		this.weight = 3.5;
//		this.addFood("Mice");
//		this.addFood("Birds");
//	}

	public Cat(int lives) {
		super(lives);
	}

	public Cat(int lives, String food) {
		super(lives);
		addFood(food);

	}

	@Override
	public void makeSound() {
		System.out.println("mew");
	}
}