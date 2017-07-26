import java.io.IOException;


public class CarTest {

	public static void main(String[] args) throws IOException {
		CarList carlist = new CarList("NewCarList.txt");
		Car ford = new Car("Ford", 1994, 10000f, 7994.0f);
		Car toyota = new Car("Toyota", 2001, 42224.4f, 2883.0f);
		Car ford2 = new Car("Ford", 2014, 0f, 17200.0f);
		carlist.addCar(ford);
		carlist.addCar(toyota);
		carlist.addCar(ford2);
		carlist.addCar(ford2);
		carlist.end();
		
	}

}
