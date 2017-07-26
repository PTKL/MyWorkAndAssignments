
public class Student {
	static String name;
	static int id;
	int totalNumber;
	public Student (String n, int idN){
		name = n;
		id = idN;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public static void setName(String n){
		name = n;
	}
	
	public static void setId(int idN){
		id = idN;
	}
	
	public void getTotalNumber(){
		totalNumber++;
	}
}
