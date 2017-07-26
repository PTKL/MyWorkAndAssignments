public class DistanceMain {

	public static void main(String[] args) {
		if (args.length < 2)
			return;
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		Point pointA = new Point(10, 20);
		Point pointB = new Point(x, y);
		System.out.printf("%.1f\n", computeDistance(pointA, pointB));
	}

	public static double computeDistance(Point p, Point q) {
		double deltaX = p.getX() - q.getX();
		double deltaY = p.getY() - q.getY();
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

	class Point {
		private double x, y;

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}