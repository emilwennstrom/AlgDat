package SkyLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class dcSkyLine {


	public static LinkedList<int[]> createSkyline(House[] houses) {
		if (houses.length == 0) new LinkedList<int[]>();
		return createSkyline(houses, 0, houses.length - 1);
	}

	static LinkedList<int[]> createSkyline(House[] houses, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			return merge(createSkyline(houses, low, mid), createSkyline(houses, mid + 1, high));
		}
		LinkedList<int[]> result = new LinkedList<>();
		result.add(new int[] {houses[low].getX1(), houses[low].getY()});
		result.add(new int[] {houses[low].getX2(), 0});
		return result;
	}

	private static LinkedList<int[]> merge(LinkedList<int[]> left, LinkedList<int[]> right) {
		LinkedList<int[]> result = new LinkedList<>();
		int h1 = 0, h2 = 0;
		while(!left.isEmpty() && !right.isEmpty()) {
			int x, h;
			if (left.peek()[0] < right.peek()[0]) {
				x = left.peek()[0];
				h1 = left.poll()[1];
			} else if (right.peek()[0] < left.peek()[0]) {
				x = right.peek()[0];
				h2 = right.poll()[1];
			} else {
				x = left.peek()[0];
				h1 = left.poll()[1];
				h2 = right.poll()[1];
			}
			h = Math.max(h1, h2);
			if (result.isEmpty() || h != result.getLast()[1]) result.add(new int[] {x, h});
		}
		result.addAll(left);
		result.addAll(right);
		return result;
	}

	public static void main(String[] args) {
		House[] houses = new House[10];
		createHouses(houses);
		LinkedList<int[]> result = createSkyline(houses);
		printResult(result);
	}

	static void printResult(LinkedList<int[]> result) {
		System.out.println("Skyline coordinates: ");
		int m = 0;
		int x = 1;
		int y = 1;

		for (int[] r : result) {
			for (int i : r){
				if (m > 0 && m % 5 == 0) System.out.println();
				if (m % 2 == 0) {
					System.out.print("x"+ x++ +": ");
				} else {
					System.out.print("y"+ y++ +": ");
				}
				System.out.print(i + "   ");
				m++;
			}
		}
	}



	private static void createHouses(House[] houses) {
		Random random = new Random();
		for (int i = 0; i < houses.length; i++) {
			int x1 = random.nextInt(0, 30);
			int x2 = random.nextInt(x1 + 2, x1 + 7);
			int y = random.nextInt(2, 10);
			houses[i] = new House(x1, y, x2);
		}
		Arrays.sort(houses);
	}
}
