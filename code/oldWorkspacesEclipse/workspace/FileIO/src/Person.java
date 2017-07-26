package Inheritance;

/**
 * A Person class.
 * 
 * @author Emil Tan
 */
public class Person {
	private String name; 
	private int age; 
	private String gender; 
	
	public Person(String personName, int personAge, String personGender) {
		name = personName; 
		age = personAge; 
		gender = personGender;
	}
	
	public void yearOlder() {
		age++; 
	}
	
	public String getName() {
		return name; 
	}
	
	public int getAge() {
		return age; 
	}
	
	public String getGender() {
		return gender; 
	}
}
