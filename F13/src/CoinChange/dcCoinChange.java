package CoinChange;

public class dcCoinChange {
	static int count = 0;


	static int coinChange(int value, int[] bills) {
		for (int bill : bills) {
			if (bill == value) return 1;
		}
		int v = value;
		for (int i = 1; i <= value / 2; i++) {
			v = Math.min(v, coinChange(i, bills) + coinChange(value - i, bills));
		}
		count++;
		return v;
	}


	public static void main(String[] args) {
		int[] bills = new int[] {10, 5, 2, 1};
		int value = 30;

		int c = coinChange(value, bills);
		System.out.println(c);
		System.out.println(count);
	}
}
