package Uppg5;

import java.util.ArrayList;
import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {
        //testDepth();
        testWidth();
    }

    private static String randString() {
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        chars.add('D');
        chars.add('E');
        Collections.shuffle(chars);
        StringBuilder toCheck = new StringBuilder();
        for (Character ch : chars) {
            toCheck.append(ch);
        }
        return toCheck.toString();
    }

    public static void testWidth() {
       // String randomString = randString();
        System.out.println("String: BAECD");
        System.out.println(SortingRobotWidth.sortBoxes("BAECD"));
        System.out.println("String: EDCBA");
        System.out.println(SortingRobotWidth.sortBoxes("EDCBA"));
    }


    public static void testDepth() {
        //String randomString = randString();
        System.out.println("String: BECAD");
        System.out.println(SortingRobotDepth.sortBoxes("BAECD"));
        System.out.println("String: EDCBA");
        System.out.println(SortingRobotDepth.sortBoxes("EDCBA"));
    }

}


