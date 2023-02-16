import java.util.Arrays;
import java.util.Random;

public class NB29a {
    public static void main(String[] args) {

        int[] randArr = new int[50];
        Random rand = new Random();
        for (int i = 0; i < randArr.length; i++) {
            int add = Math.abs(rand.nextInt() % 300);
            randArr[i] = add;
        }
        System.out.println("Unsorted:   " + Arrays.toString(randArr));

        int[] a = {3, 7, 2, 8, 6, 9, 10, 1};
        mergeSort(a);
        mergeSort(randArr);
        System.out.println("Merge sort: " + Arrays.toString(randArr));
        System.out.println("Merge sort: " + Arrays.toString(a));

    }
    /*
        Merge sort delar upp arrayen i mindre och mindre bitar
        tills den kan slå ihop arrayen i rätt ordning via merge funktionen
     */

    public static void mergeSort(int[] array) {
        if (array.length == 1) return;
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - array.length / 2];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int j = 0, i = left.length; j < right.length; i++, j++) {
            right[j] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }


    public static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
