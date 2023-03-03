package uppgift5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v = new int[]{7,3,4,6,1,9,3,8};
        sort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void sort(int[] v){
        sort(v, v.length);
    }

    private static void sort(int[] v, int high) {
        if (v.length == 1) return;
        int[] left = Arrays.copyOfRange(v, 0, high / 2);
        int[] right = Arrays.copyOfRange(v, high / 2, high);
        sort(left);
        sort(right);
        merge(v, left, right);
    }

    private static void merge(int[] v, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                v[k++] = left[i++];
            } else if (right[j] < left[i]) {
                v[k++] = right[j++];
            } else {
                v[k++] = left[i++];
                v[k++] = right[j]++;
            }
        }
        while(left.length < i) {
            v[k++] = left[i++];
        }
        while (right.length < j) {
            v[k++] = right[j++];
        }

    }
}
