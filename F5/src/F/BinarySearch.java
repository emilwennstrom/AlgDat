package F;

import java.awt.desktop.ScreenSleepEvent;

public class BinarySearch {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < 50; i++) {
            arr[i] = (i + 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int result;

        for (int i = 0; i < 50; i++) {
            result = binSearchIterative(arr, i+2);
            System.out.print(result+ " ");
        }

        for (int i = 0; i < 50; i++) {
            result = binSearchRecursive(arr, i+2);
            System.out.print(result + " ");
        }




    }


    public static int binSearchIterative(int[] array, int target) throws InterruptedException {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (target < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }


    public static int binSearchRecursive(int[] array, int target) throws InterruptedException {
        return binSearchRecursive(array, target, 0, array.length -1);
    }

    public static int binSearchRecursive(int[] array, int target, int beginning, int end) throws InterruptedException {
        if (beginning > end) {
            return -1;
        } else {
            int middle = (beginning + end) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                return binSearchRecursive(array, target, beginning, middle - 1);
            } else {
                return binSearchRecursive(array, target, middle + 1, end);
            }

        }
    }

}
