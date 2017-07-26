
public class Tester {
	public static void main(String[] args){
		DataSet data = new DataSet();
		data.add(1);
		data.add(4);
		data.add(9);
		data.add(16);
		data.add(9);
		data.add(7);
		data.add(4);
		data.add(9);
		data.add(11);
		
		double sum = data.alternatingSum();
		System.out.println("Alternating Sum = "+sum);
		System.out.println("Expected: -2");
		

		data.add(10);
		data.add(11);
		
		sum = data.alternatingSum();
		System.out.println("Alternating Sum = "+sum);
		System.out.println("Expected: -1");
		
		System.out.println("The data size is "+data.getDataSize());
		System.out.println("Expected: 11");
	}
}
