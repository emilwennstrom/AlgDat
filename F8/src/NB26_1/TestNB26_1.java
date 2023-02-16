package NB26_1;

public class TestNB26_1 {

    public static void main(String[] args) {
        String[] arr = {"test1", "test2", "test3", "test4", "test5", "test2", "test1", "test3", "test2", "test6", "test7", "test8"};
        System.out.println(mostUsualStringCount(arr));
    }

    public static int mostUsualStringCount(String[] stringArr) {
        HashTableBucket<String, Integer> stringHash = new HashTableBucket<>(5);
        Integer value;
        int max = 0;
        for (String s : stringArr) {
            value = stringHash.get(s);
            if (value == null) {
                value = 0;
            }
            stringHash.put(s, value + 1);
            value = stringHash.get(s);
            if (value > max) max = value;
        }

        System.out.println(stringHash);
        return max;
    }


}


