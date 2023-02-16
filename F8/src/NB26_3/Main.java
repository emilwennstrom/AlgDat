package NB26_3;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashTableOpen<Integer, Integer> hashTableOpen = new HashTableOpen<>(10);

        for (int i = 0; i < 20; i++){
            double a = Math.random() * 50;
            hashTableOpen.put((int) a + 300, i + 300);
        }
        System.out.println(hashTableOpen);

        for (int i = 0; i < 200; i++) {
            hashTableOpen.put(i, i);
        }
        System.out.println(hashTableOpen);


        hashTableOpen = new HashTableOpen<>(10);

        hashTableOpen.put(0, 0);
        hashTableOpen.put(11, 0);
        hashTableOpen.put(22, 1);
        hashTableOpen.put(38, 38);

        System.out.println(hashTableOpen);

        System.out.println(hashTableOpen.get(0));
        System.out.println(hashTableOpen.get(11));
        System.out.println(hashTableOpen.get(22));
        System.out.println(hashTableOpen.get(33));

        System.out.println(hashTableOpen.remove(11));
        System.out.println(hashTableOpen.remove(22));

        System.out.println(hashTableOpen.remove(38));
        System.out.println(hashTableOpen.remove(0));
        System.out.println(hashTableOpen);


        for (int i = 0; i < 20; i++) {
            Integer nextInt = (int) (100 * Math.random());
            hashTableOpen.put(nextInt, nextInt);
        }
        System.out.println(hashTableOpen);

        for (int i = 0; i < 100; i++) {
            hashTableOpen.remove(i);
        }
        System.out.println(hashTableOpen);
    }
}