package NB25;

import NB24.HashTableBucket;

public class TestNB25 {

    public static void main(String[] args) {
        HashTableBucket<Integer, Integer> hash = new HashTableBucket<>(2);
        System.out.println(hash);
        hash.put(1, 1);
        System.out.println(hash);
        hash.put(2, 2);
        System.out.println(hash);
        for (int i = 3; i < 10; i++) {
            hash.put(i, i);
        }
        System.out.println(hash);

        hash.put(14, 14);
        hash.put(15, 15);
        hash.put(16, 16);

        System.out.println(hash);

        hash.put(17,17);

        System.out.println(hash);

    }

}
