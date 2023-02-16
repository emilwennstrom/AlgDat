import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IntList intList = new IntList(10);

        for (int i = 0; i < 25; i++){
            intList.add(i+1);
            System.out.print(intList.get(i) + " ");
        }

        intList.add(4);

        printIntList(intList);

        System.out.println(intList.indexOf(15));
        System.out.println(intList.size());
        System.out.println(intList.get(25));
        System.out.println(intList.remove(24));
        printIntList(intList);



    }


    public static void printIntList(IntList intList) {
        for (int i = 0; i < intList.size(); i++){
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
    }

    public static int count (List<String> list, String s) {
        int count = 0;
        for (String string : list) {
            if (string.compareTo(s) == 0) {
                count++;
            }
        }
        return count;
    }

    public static void compareFunctions() {
        int n = 0;

        for (int i = 0; i < 10; i++) {
            int y1 = 100 * n + 10;
            int y2 = 5 * n * n + 2;
            System.out.println("y1 = " + y1 + "   y2 = " + y2);
            n += 10;
        }



    }
}