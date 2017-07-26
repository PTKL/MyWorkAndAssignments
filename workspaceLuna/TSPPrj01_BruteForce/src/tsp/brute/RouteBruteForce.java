package tsp.brute;

import java.util.ArrayList;
import java.util.Arrays;

public class RouteBruteForce {

  private ArrayList<City> cities = new ArrayList<City>();

  public RouteBruteForce(ArrayList<City> initialRoute) {
    setCities(initialRoute);

  }

  public RouteBruteForce(RouteBruteForce route) {
    route.cities.stream().forEach(x -> cities.add(x));
  }

  public ArrayList<City> getCities() {
    return cities;
  }

  public void setCities(ArrayList<City> cities) {
    this.cities = cities;
  }

  public String toString() {
    return Arrays.toString(cities.toArray());
  }
}
