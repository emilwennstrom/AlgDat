package NB42;

import java.util.Comparator;

public class Point implements Comparable<Point> {

	float x, y;


	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}




	public float distanceTo(Point p) {
		float dX = this.x - p.x;
		float dY = this.y - p.y;
		return (float) Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));

	}


	@Override
	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	@Override
	public int compareTo(Point o) {
		return Float.compare(this.x, o.x);
	}
}
