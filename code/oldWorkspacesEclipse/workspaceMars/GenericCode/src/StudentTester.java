 

public class StudentTester {
	public static void main (String[] args){
		Student s1 = new Student("Peter");
		s1.addQuiz(60);
		s1.addQuiz(78);
		s1.addQuiz(54);
		s1.addQuiz(32);
		System.out.println(s1.getName()+" total score is "+s1.getTotalScore()+" and his average is "+s1.getAverageScore());
	}
}
