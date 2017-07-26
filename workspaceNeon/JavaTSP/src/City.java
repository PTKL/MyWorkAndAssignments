/**
 * This class is how we create a city to be used in the TSP. The city is defined by its latitude and
 * longitude. This is done in order to have a scale in which the application can work in.
 * 
 * @author emil
 *
 */

public class City {

  private static final double EARTH_EQUATORIAL_RADIUS =  6378.1370D; // taken from here at line 46:
  // https://github.com/gengyifeng/NetCDF-Java-Hadoop/blob/master/v4.3/cdm/src/main/java/ucar/unidata/geoloc/Earth.java
  private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI / 180D;
  private static final double CONVERT_KM_TO_MILES = 0.621371;
  private String name;
  private double longitude;
  private double latitude;

  public City(String name, double latitude, double longitude) {

    this.name = name;
    this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS;
    this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
  }

  public String getName() {
    return this.name;
  }

  public double getLatitude() {
    return this.latitude;
  }

  public double getLongitude() {
    return this.longitude;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double measureDistance(City city) {

    double deltaLongitude = (city.getLongitude() - this.getLongitude());
    double deltaLatitude = (city.getLatitude() - this.getLatitude());
    double total = Math.pow(Math.sin(deltaLatitude / 2D), 2D) + Math.cos(this.getLatitude())
        * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
    return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(total), Math.sqrt(1D - total));
  }

  public String toString() {
    return getName();
  }
}
