package tsp.rec.hill.climbing;
import java.util.ArrayList;
public class RRHillClimbing {
	public static final int ITERATIONS_BEFORE_MAXIMA = 100;
	public static final int NUMB_OF_RANDOM_RESTARTS = 10;
	public ArrayList<Route> findShortestRoutes(Route route) {
		ArrayList<Route> routes = new ArrayList<Route>();
		for (int i=0; i < NUMB_OF_RANDOM_RESTARTS; i++) routes.add(findShortestRoute(route));
		sortRoutesByDistance(routes);
		return routes;
	}
	public Route findShortestRoute(Route currentRoute) {
		Route adjacentRoute; 
		int iterToMaximaCounter = 0;
		while (iterToMaximaCounter < ITERATIONS_BEFORE_MAXIMA) {
			adjacentRoute = obtainAdjacentRoute(new Route(currentRoute));
			if (adjacentRoute.getTotalDistance() <= currentRoute.getTotalDistance()) {
	        	iterToMaximaCounter = 0;
	            currentRoute = new Route(adjacentRoute);
	        }  else iterToMaximaCounter++;
		}
		return currentRoute;
	 }
	public void sortRoutesByDistance(ArrayList<Route> routes) {
		routes.sort((route1, route2) -> {
			int flag = 0;
			if (route1.getTotalDistance() < route2.getTotalDistance()) flag = -1;
			else if (route1.getTotalDistance() > route2.getTotalDistance()) flag = 1;
			return flag;
		});
	}
	 private Route obtainAdjacentRoute(Route route) {
		int x1 = 0, x2 = 0;
	    while (x1 == x2) {
		    x1 = (int) (route.getCities().size() * Math.random());
		    x2 = (int) (route.getCities().size() * Math.random());
	    }
	    City city1 = route.getCities().get(x1);
        City city2 = route.getCities().get(x2);
        route.getCities().set(x2, city1);
        route.getCities().set(x1, city2);
        return route;
	 }
}
