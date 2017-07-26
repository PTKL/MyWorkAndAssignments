import java.io.*;

public class CarList{
	String filepath;
	
	public CarList(String filename){
		filepath = filename;
	}
	
	public int countNewCars() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		int onLine = 0; 
		int newCars = 0;
		String line;
		while ((line = br.readLine()) != null) {
			if ((onLine + 3) % 6 == 0){
				try {
					if (Integer.parseInt(line) == 0)
						newCars++;
				} catch (Exception e) {}
			}
			onLine++;
		}
		return newCars;
	}
	
	public Car mostExpensiveCar() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		Car mostExpensive = new Car("", "", 0, 0, 0);
		Car currentCar;
		String make = "", model = "", line;
		int year = 0, kilos = 0, price = 0;
		int onLine = 0;
		
		while ((line = br.readLine()) != null){
			if ((onLine+1) % 7 == 0)
				onLine = 0;
			
			switch (onLine){
				case 0:
					make = line;
					break;
				case 1:
					model = line;
					break;
				case 2:
					try {
						year = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 3:
					try {
						kilos = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 4:
					try {
						price = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 5:
					currentCar = new Car(make, model, year, kilos, price);
					if (currentCar.getPrice() > mostExpensive.getPrice())
						mostExpensive = currentCar;
					break;
			}
				
			onLine++;
		}
		
		return mostExpensive;
	}
	
	public void addCar(Car c) throws IOException{
		FileWriter fw = new FileWriter(filepath, true);
		fw.write(	c.getMake() + "\n" +
					c.getModel() + "\n" +
					c.getYear() + "\n" +
					c.getKilos() + "\n" +
					c.getPrice() + "\n\n");
		fw.flush();
		fw.close();
	}
	
	public void removeCar(Car c) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		FileWriter fw = new FileWriter("temp.txt");
		Car currentCar;
		String make = "", model = "", line;
		int year = 0, kilos = 0, price = 0;
		int onLine = 0;
		
		while ((line = br.readLine()) != null){
			if ((onLine+1) % 7 == 0)
				onLine = 0;
			
			switch (onLine){
				case 0:
					make = line.trim();
					break;
				case 1:
					model = line.trim();
					break;
				case 2:
					try {
						year = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 3:
					try {
						kilos = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 4:
					try {
						price = Integer.parseInt(line);
					} catch (Exception e) {}
					break;
				case 5:
					currentCar = new Car(make, model, year, kilos, price);
					if (!currentCar.equalTo(c)){
						fw.write(	currentCar.getMake() + "\n" +
									currentCar.getModel() + "\n" +
									currentCar.getYear() + "\n" +
									currentCar.getKilos() + "\n" +
									currentCar.getPrice() + "\n\n");
					}
					break;
			}
				
			onLine++;
		}
		fw.flush();
		fw.close();
		
		File oldFile = new File(filepath);
		File temp = new File("temp.txt");
		
		temp.renameTo(oldFile);
	}
}










