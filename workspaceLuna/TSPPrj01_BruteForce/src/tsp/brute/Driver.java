package tsp.brute;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
  final static boolean VERBOSE_FLAG = false; // can be exchanged with just a false wherever it is tpresent
  private static ArrayList<City> initialRoute = new ArrayList<City>(Arrays.asList(new City(
      "Boston", 42.3601, -71.0589), new City("San Francisco", 37.7749, -122.4194), new City(
      "New York", 40.7128, -74.0059), new City("Houston", 29.7604, -95.3698), new City("Denver",
      39.7392, -104.9903), new City("Los Angeles", 34.0522, -118.2437), new City("Chicago",
      41.8781, -87.6298), new City("Austin", 30.2672, -97.7431), new City("Washington DC", 38.9072, 77.0369)
      ));


  public static void main(String[] args) {
    Driver driver = new Driver();
    Instant startInstant = Instant.now();
    BruteForce bruteForce = new BruteForce();
    RouteBruteForce currentRoute = new RouteBruteForce(initialRoute);
    if (VERBOSE_FLAG) {
      driver.printHeading("RouteBruteForce", " Distance   |   Shortest Distance  |  Permutation #");
    }
    else {
      System.out.println("permutations in progress ...");
    }
    driver.printResult(bruteForce,
        bruteForce.permuteCities(0, currentRoute, new RouteBruteForce(currentRoute)));
    driver.printDuration(startInstant);
  }

  public void printDuration(Instant startInstant) {
    Duration permutationDuration = Duration.between(startInstant, Instant.now());
    long minutes = permutationDuration.toMinutes();
    long seconds = permutationDuration.getSeconds();
    if (seconds > 59) {
      long tempSeconds = seconds - 60 * minutes;
      long tempMilliseconds = permutationDuration.toMillis() - seconds * 1000;
      System.out.println("Duration: " + minutes + " minutes " + tempSeconds + " seconds "
          + +tempMilliseconds + " milliseconds " + "(" + permutationDuration + ")");
    } else if (seconds > 0) {
      long tempmilliseconds = permutationDuration.toMillis() - seconds * 1000;
      System.out.println("Duration: " + seconds + " seconds " + tempmilliseconds + " milliseconds "
          + "(" + permutationDuration + ")");
    } else
      System.out.println("Duration: " + permutationDuration.toMillis() + " milliseconds ("
          + permutationDuration + ")");
  }

  public void printResult(BruteForce bruteForce, ArrayList<RouteBruteForce> shortestRoutes) {
    if (VERBOSE_FLAG) {
      System.out.println("");
    }
    printHeading("Shortest RouteBruteForce ", "Distance");
    shortestRoutes.stream().forEach(
        x -> System.out.println(x + " | " + bruteForce.getTotalDistance(x)));
  }

  public void printHeading(String headingColumn1, String remainingHeadingColumns) {
    int cityNamesLength = 0;
    for (int x = 0; x < initialRoute.size(); x++)
      cityNamesLength += initialRoute.get(x).getName().length();
    int arrayLength = cityNamesLength + initialRoute.size() * 2;
    int partialLength = (arrayLength - headingColumn1.length()) / 2;
    for (int x = 0; x < partialLength; x++)
      System.out.print(" ");
    System.out.print(headingColumn1);
    for (int x = 0; x < partialLength; x++)
      System.out.print(" ");
    if ((arrayLength % 2) == 0)
      System.out.print(" ");
    System.out.println(" | " + remainingHeadingColumns);
    cityNamesLength += remainingHeadingColumns.length() + 3;
    for (int x = 0; x < cityNamesLength + initialRoute.size() * 2; x++)
      System.out.print("-");
    System.out.println("");
  }
}
