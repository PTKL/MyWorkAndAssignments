import java.util.Scanner;

class AtheleteTest
{
	public static void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name...? Age...? Weight...? Height...?");
		String name = scanner.nextLine();
		int age = scanner.nextInt();
		float weight = (float)scanner.nextDouble();
		float height = (float)scanner.nextDouble();
		
		Athlete me = new Athlete(age, name, height, weight);
		me.print();
		
	}
}