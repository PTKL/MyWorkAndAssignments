import java.io.*;

public class Dealership{
	public static void main(String[] args) throws IOException{
		CarList cars = new CarList("Cars.txt");
		
		
		/*cars.addCar(new Car("Chevy", "Nova", 1968, 10000, 10000));
		cars.addCar(new Car("MG", "B Roadster", 1964, 0, 9000));
		cars.addCar(new Car("MG", "C", 1966, 1000, 2000));
		cars.addCar(new Car("RandomCar", "Super GT", 2015, 10, 10000));
		cars.addCar(new Car("Pie", "Mega", 1901, 0, 9000));*/
		
		cars.removeCar(new Car("RandomCar", "Super GT", 2015, 10, 10000));
	}
}
