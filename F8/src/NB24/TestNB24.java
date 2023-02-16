package NB24;


import javax.sound.midi.Soundbank;

public class TestNB24 {

    public static void main(String[] args) {

        HashTableBucket<Integer, String> hash = new HashTableBucket<>(13);

        hash.put(0, "0");
        hash.put(1, "1");
        hash.put(2, "2");
        hash.put(3, "3");

        System.out.println(hash);

        hash.put(13, "13");
        hash.put(14, "14");
        hash.put(15, "15");
        hash.put(16, "16");

        System.out.println(hash);

        System.out.println("Removing key 2: " + hash.remove(2));
        System.out.println("Removing key that doesnt exist (17): " + hash.remove(17));
        System.out.println("Removing key 0: " + hash.remove(0));
        System.out.println();

        System.out.println(hash);



    }
}
