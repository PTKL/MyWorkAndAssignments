
public class Car{
	String make, model;
	int year, kilos, price;
	
	public Car(String make, String model, int year, int kilos, int price){
		this.make = make;
		this.model = model;
		this.year = year;
		this.kilos = kilos;
		this.price = price;
	}
	
	public String getMake() { return make; };
	public String getModel() { return model; };
	public int getYear() { return year; };
	public int getKilos() { return kilos; };
	public int getPrice() { return price; };
	
	public String toString(){
		String s = 	make + " " + model +
					"\nManufacturing year: " + year +
					"\nDriven kilometres: " + kilos +
					"\nPrice: £" + price;
		return s;
	}
	
	public boolean equalTo(Car c){
		if (c.getMake().trim().toUpperCase().equals(getMake().trim().toUpperCase()) 
		&& c.getModel().trim().toUpperCase().equals(getModel().trim().toUpperCase()) 
		&& c.getYear() == getYear()	&& c.getKilos() == getKilos() && c.getPrice() == getPrice()) return true;
		return false;
	}
	
	
}







