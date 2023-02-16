package NB26;

public class TestNB26 {
    public static void main(String[] args) {
        HashTableBucket<Integer, Integer> hash = new HashTableBucket<>(11);
        for (int i = 0; i < 20; i++) {
            Integer nextInt = (int) (32000 * Math.random());
            hash.put(nextInt, nextInt);
        }
        System.out.println(hash);


        for (int i = 0; i < 20; i++){
            hash.put(i, i);
        }

        System.out.println(hash);

        // ArrayIndex 20 = null

        hash.put(20, 20);

        System.out.println(hash);

        System.out.println(hash.get(20));



    }


}
