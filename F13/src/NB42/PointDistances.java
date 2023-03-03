package NB42;

import javax.sound.midi.Soundbank;
import java.util.*;

public class PointDistances {


	public static float slowGetMinDistance(Point[] points) {
		float distance = Integer.MAX_VALUE;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				float d = points[i].distanceTo(points[j]);
				if (d < distance) {
					distance = d;
				}
			}
		}
		return distance;
	}



	public static float getMinDistance(Point[] points, int low, int high) {
		int noOfPoints = high - low;
		if (noOfPoints == 1) {
			return points[low].distanceTo(points[high]);
		}
		if (noOfPoints == 2) {
			return Math.min(points[low + 1].distanceTo(points[high]),
					Math.min(points[low].distanceTo(points[low + 1]), points[low].distanceTo(points[high])));
		}

		int mid = (high + low) / 2;
		float a = getMinDistance(points, low, mid);
		float b = getMinDistance(points, mid + 1, high);
		float minD = Math.min(a, b);
		float midLine = (points[mid].x + points[mid + 1].x) / 2;
		ArrayList<Point> closestOverMid = new ArrayList<>();
		for (int i = mid; i >= low; i--) {
			if (points[i].x > midLine - minD) {
				closestOverMid.add(points[i]);
			} else break;
		}
		for (int i = mid + 1; i <= high; i++) {
			if (points[i].x < midLine + minD) {
				closestOverMid.add(points[i]);
			} else break;
		}
		closestOverMid.sort(new PointSortByY());
		for (int i = 0; i < closestOverMid.size() - 1; i++) {
			for (int j = i + 1; j < closestOverMid.size(); j++) {
				if (Math.abs(closestOverMid.get(i).y - closestOverMid.get(j).y) < minD) {
					float distance = closestOverMid.get(i).distanceTo(closestOverMid.get(j));
					if (distance < minD) {
						minD = distance;
					}
				}
			}
		}
		return minD;
	}


	public static void main(String[] args) {

		Point[] points = randPoints(100000);
		Arrays.sort(points);
		double s1 = System.currentTimeMillis();
		System.out.println(getMinDistance(points, 0, points.length -1));
		double s2 = System.currentTimeMillis() - s1;
		double s3 = System.currentTimeMillis();
		System.out.println(slowGetMinDistance(points));
		double s4 = System.currentTimeMillis() - s3;

		System.out.println("Time for fast: " + s2);
		System.out.println("Time for slow: " + s4);
	}

	static Point[] randPoints(int n) {
		Point[] p = new Point[n];
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			float x = rand.nextFloat(-1F, 1F);
			float y = rand.nextFloat(-1F, 1F);
			p[i] = new Point(x, y);
		}


		return p;
	}


}
