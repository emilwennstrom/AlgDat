package NB29d;

import NB30.MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) {

       int[] ints = new int[10000];
        Random rand = new Random();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(0, 10000);
        }
        System.out.println(checkSort(ints));
        HeapSort.sort(ints);
        System.out.println(checkSort(ints));



       System.out.println(Arrays.toString(ints));
    }


    private static boolean checkSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                return false;
            }
        }
        return true;
    }
}