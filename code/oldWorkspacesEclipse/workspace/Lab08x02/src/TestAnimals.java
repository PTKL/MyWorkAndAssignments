import animals.Cat;
import animals.Dog;
import animals.Lion;
import animals.Wolf;

class TestAnimals {
	public static void main(String[] args) {
		Cat cat = new Cat(7, "Dove");
		Dog dog = new Dog(2, "Bone");
		Lion lion = new Lion();
		Wolf wolf = new Wolf();
		System.out.println("The cat eats:");
		cat.printFoods();
		cat.makeSound();
		System.out.println("The dog eats:");
		dog.printFoods();
		dog.sit();
		dog.stand();
		dog.makeSound();
		
		lion.makeSound();
		lion.sit();
		lion.stand();
		System.out.println(lion.getLives());
		wolf.makeSound();
		System.out.println(wolf.getPackSize());
	}
}