
public class Thread {

	public static void main(String[] args) {
		while(true) {
		System.out.println("Hello");
        Thread.sleep(1000);
        System.out.println("World");
        Thread.sleep(1700);
        System.out.println("!");
        Thread.sleep(700);
		}
	}

}
