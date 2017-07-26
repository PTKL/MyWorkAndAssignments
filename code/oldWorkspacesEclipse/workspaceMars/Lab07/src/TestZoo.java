public class TestZoo {

	public static void main (String [] args) {
		Animal snail = new Animal(3.5, 1, "snail");
		Animal elephant = new Animal(5000, 4, "elephant");
		Zoo myZoo = new Zoo();
		myZoo.addAnimal(snail);
		myZoo.addAnimal(elephant);
		
		
		while(myZoo.addAnimal(snail) == true){
		  myZoo.print();
		}
		
		System.out.println("There are " +myZoo.numberOfAnimals() + " in the zoo!");
		//System.out.println("The total mass is " +myZoo.totalMass());
		//System.out.println("The total number of legs is " +myZoo.numberOfLegs());
	}
	
}
