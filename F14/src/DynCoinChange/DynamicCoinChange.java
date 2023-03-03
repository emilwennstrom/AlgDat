package DynCoinChange;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.min;

public class DynamicCoinChange {

	static int[] bills;

	static int change(int value, HashMap<Integer, Integer> dynValues) {
		for (int v : bills) {
			if (v == value) return 1;
		}
		int v = value;
		int low, high;
		for (int i = 1; i <= value/2; i++) {
			if (dynValues.containsKey(i)) {
				low = dynValues.get(i);
			} else {
				low = change(i, dynValues);
				dynValues.put(i, low);
			}
			if (dynValues.containsKey(value - i)){
				high = dynValues.get(value - i);
			} else {
				high = change(value - i, dynValues);
				dynValues.put(value - i, high);
			}
			v = min(v, low + high);
		}
		return v;
	}

	static int change (int value, int[] tab) {
		if (tab[value] != 0) {
			return tab[value];
		}
		int v = value;
		for (int i = 1; i < value / 2; i++) {
			v = min(v, change(i, tab) + change(value - i, tab));
		}
		tab[value] = v;
		return v;
	}


	public static void main(String[] args) {
		int value = 60;
		bills = new int[] {18, 10, 5, 1};
		HashMap<Integer, Integer> dynValues = new HashMap<>();
		System.out.println(change(value, dynValues));
		int[] tab = new int[value + 1];
		for (int bill : bills) {
			tab[bill] = 1;
		}
		System.out.println(change(value, tab));







	}





}
