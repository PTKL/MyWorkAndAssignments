package felines;
import java.util.ArrayList;

public abstract class Animal {
	protected double weight;
	private ArrayList<String> foods;

	public Animal() {
		this.weight = 0;
		this.foods = new ArrayList<String>();
	}
	
	public abstract void makeSound();

	public Animal(double weight) {
		this.weight = weight;
		this.foods = new ArrayList<String>();
	}

	public void addFood(String food) {
		this.foods.add(food);
	}

	public void removeFood(String food) {
		this.foods.remove(food);
	}

	public void printFoods() {
		for (String food : foods) {
			System.out.println(food);
		}
		
	
	}
}