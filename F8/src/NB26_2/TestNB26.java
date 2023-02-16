package NB26_2;

import java.util.Arrays;
import java.util.HashSet;

public class TestNB26 {

    public static void main(String[] args) {
        String[] arr = {"test1", "test2", "test3", "test4", "test5", "test2", "test1", "test3", "test2", "test6", "test7", "test8"};
        System.out.println(getNumberOfIndividualStrings(arr));
    }


    public static int getNumberOfIndividualStrings(String[] stringArr) {
        HashSet<String> stringHashSet = new HashSet<>(Arrays.asList(stringArr));
        return stringHashSet.size();
    }

}


