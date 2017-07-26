public class NewTestZoo {

	public static void main (String [] args) {
		Animal snail = new Animal(3.5, 1, "snail");
		Animal elephant = new Animal(5000, 4, "elephant");
		Animal spider = new Animal(5, 8, "spider");
		Animal snake = new Animal(20, 1, "snake");
		Zoo myZoo = new Zoo();
		myZoo.addAnimal(snail);
		myZoo.addAnimal(elephant);
		myZoo.addAnimal(spider);
		myZoo.addAnimal(snake);
		
		myZoo.print();
	
		
		System.out.println("There are " +myZoo.numberOfAnimals() + " in the zoo!");
		System.out.println("The total mass is " +myZoo.totalMass());
		System.out.println("The total number of legs is " +myZoo.numberOfLegs());
		System.out.println("The average number of mass is " +myZoo.totalMass()/myZoo.numberOfAnimals());
		System.out.println("The average number of legs is " +myZoo.numberOfLegs()/myZoo.numberOfAnimals());
	}
	
}
