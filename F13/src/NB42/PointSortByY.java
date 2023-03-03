package NB42;

import java.util.Comparator;

public class PointSortByY implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		return Float.compare(o1.y, o2.y);
	}
}
