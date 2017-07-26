package tsp.brute;

import java.util.ArrayList;
import java.util.Collections;

public class BruteForce {
  static int permutationNumb = 1;
  ArrayList<RouteBruteForce> shortestRoutes = new ArrayList<RouteBruteForce>();

  public ArrayList<RouteBruteForce> permuteCities(int x, RouteBruteForce currentRoute, RouteBruteForce shortestRoute) {
    currentRoute.getCities().stream().filter(y -> currentRoute.getCities().indexOf(y) >= x)
        .forEach(y -> {
          int indexOfY = currentRoute.getCities().indexOf(y);
          Collections.swap(currentRoute.getCities(), indexOfY, x);
          permuteCities(x + 1, currentRoute, shortestRoute);
          Collections.swap(currentRoute.getCities(), x, indexOfY);
        });
    if (x == currentRoute.getCities().size() - 1) {
      if (Driver.VERBOSE_FLAG) {
        System.out.print(currentRoute + " |         " + getTotalDistance(currentRoute));
      }
      if ((int) calculateTotalDistance(currentRoute) <= (int) calculateTotalDistance(shortestRoute)) {
        shortestRoute.getCities().clear();
        shortestRoute.getCities().addAll(currentRoute.getCities());
        addToShortestRoutes(new RouteBruteForce(shortestRoute));
      }
      if (Driver.VERBOSE_FLAG) {
        System.out.println("         |      " + getTotalDistance(shortestRoute) + "           | "
            + permutationNumb++);
      }
    }
    return shortestRoutes;
  }

  public int calculateTotalDistance(RouteBruteForce route) {
    int citiesSize = route.getCities().size();
    return (int) (route.getCities().stream().mapToDouble(x -> {
      int cityIndex = route.getCities().indexOf(x);
      double returnValue = 0;
      if (cityIndex < citiesSize - 1)
        returnValue = x.measureDistance(route.getCities().get(cityIndex + 1));
      return returnValue;
    }).sum() + route.getCities().get(0).measureDistance(route.getCities().get(citiesSize - 1)));
  }

  public String getTotalDistance(RouteBruteForce route) {
    String returnValue = Integer.toString(calculateTotalDistance(route));
    if (returnValue.length() == 4)
      returnValue = " " + returnValue;
    else if (returnValue.length() == 3)
      returnValue = "  " + returnValue;
    return returnValue;
  }

  public void addToShortestRoutes(RouteBruteForce route) {
    shortestRoutes
        .removeIf(x -> (int) calculateTotalDistance(x) > (int) calculateTotalDistance(route));
    shortestRoutes.add(route);
  }
}
