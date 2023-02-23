package NB34;

import java.util.Arrays;
import java.util.Random;

public class GreedyCoinChange {


    public static int[] coinChange(int value, int[] bills) {
        int[] change = new int[bills.length];
        for (int i = 0; i < bills.length; i++) {
            int n = 0;
            while (bills[i] <= value) {
                value -= bills[i];
                n++;
            }
            change[i] = n;
        }
        return change;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int value = rand.nextInt(600, 10000);
        int[] change = GreedyCoinChange.coinChange(value,
                new int[] {1000, 500, 100, 50, 20, 10, 5, 1});

        System.out.println("Value = " + value);
        System.out.println(Arrays.toString(change));

    }

}
