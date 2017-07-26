
class Athlete{
	private int age;
	private String name;
	private float height, weight;
	
	public Athlete(int age, String name, float height, float weight)
	{
		this.age = age;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public Athlete (String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public float getHeight()
	{
		return height;
	}
	public float getWeight()
	{
		return weight;
	}
	
	public String toString()
	{
		return ("Name: " + name + ". Age: " + age + 
		". Height: " + height + ". Weight: " + weight);
	}
	
	public void print()
	{
		System.out.println(toString());
	}
}