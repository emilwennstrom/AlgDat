package Uppg9;

import java.util.Random;

public class RadixSort {

    public static void main(String[] args) {


        int[] integers = new int[1000000];
        Random random = new Random();

        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(0, Integer.MAX_VALUE);
        }
        integers = radixSort(integers);

        //System.out.println(Arrays.toString(integers));
    }


    public static int[] radixSort(int[] array) {
        final int mod = 10;
        int divisor = 1;
        int laps = numberOfLaps(array);
        double time1 = System.currentTimeMillis();
        while(laps > 0) {
            int[] newArr = new int[array.length];
            int[] sortArr = new int[mod];
            for (int num : array) {
                int sortIndex = (num / divisor) % mod;
                sortArr[sortIndex]++;
            }
            for (int i = 0; i < sortArr.length - 1; i++) {
                sortArr[i + 1] += sortArr[i];
            }
            for (int pos = array.length - 1; pos >= 0; pos--) {
                int sortIndex = (array[pos] / divisor) % mod;
                sortArr[sortIndex]--;
                newArr[sortArr[sortIndex]] = array[pos];
            }
            array = newArr;
            divisor = divisor * mod;
            laps--;
        }
        double time2 = System.currentTimeMillis();
        time2 = time2 - time1;
        if(checkIfSorted(array)) {
            System.out.println("Array is sorted, time: " + time2 + "ms");
        }
        return array;
    }

    public static int numberOfLaps(int[] array) {
        int max = 0;
        for (int i : array) {
            if (i > max) max = i;
        }
        int laps = 0;
        while (max > 0) {
            max = max / 10;
            laps++;
        }
        return laps;
    }

    public static boolean checkIfSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]){
                return false;
            }
        }
        return true;
    }

}
