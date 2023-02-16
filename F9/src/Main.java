import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[8];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int add = Math.abs(rand.nextInt() % 300);
            array[i] = add;
        }


        System.out.println(Arrays.toString(array));

        int[] tests = Arrays.copyOf(array, array.length);

    }

    public static int exp(int a, int b) {
        if (b == 1)
            return a;
        int p = exp(a, b / 2);
        if (b % 2 == 0) return p * p;
        return (a * p * p);
    }

    public static int divideAndConqMax(int[] array) {
        return divideAndConqMax(array, 0, array.length - 1);
    }

    private static int divideAndConqMax(int[] array, int low, int high) {
        if (low == high) {
            return array[low];
        }
        int middle = (low + high) / 2;
        int left = divideAndConqMax(array, low,  middle);
        int right = divideAndConqMax(array, middle + 1, high);
        return Math.max(left, right);
    }












}

