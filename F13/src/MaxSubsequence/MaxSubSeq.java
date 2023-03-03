package MaxSubsequence;

import java.util.Arrays;
import java.util.Random;

public class MaxSubSeq {

    private static int maxSum(int[] array, int left, int right) {
        if (left > right) return 0;
        if (left == right) return Math.max(0, array[left]);
        int mid = (left + right) / 2;
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = mid; i >= 0; i--){
            sum += array[i];
            maxLeft = Math.max(maxLeft, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            maxRight = Math.max(maxRight, sum);
        }
        int maxOverMid = maxLeft + maxRight;
        return Math.max(Math.max(maxOverMid, maxSum(array, left, mid)), maxSum(array, mid + 1, right));
    }

    private static int maxSum(int[] array) {
        return maxSum(array, 0, array.length - 1);
    }


    public static void main(String[] args) {
        int[] numArr = new int[10];
        randArr(numArr);
        //int[] numArr = {-79, -78, 95, -26, 49, -26, -22, 80, -11, 5};
        System.out.println("Maximum sum of a subsequence in:\n" + Arrays.toString(numArr) + "\nis: " + maxSum(numArr));
    }

    public static void randArr(int[] numArr) {
        Random rand = new Random();
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = rand.nextInt(-100, 100);
        }
    }





}
