package Uppg8;

public class BMain {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binInts = new BinarySearchTree<>();



        binInts.add(68);
        binInts.add(24);
        binInts.add(105);
        binInts.add(12);
        binInts.add(65);
        binInts.add(100);
        binInts.add(120);
        binInts.add(6);
        binInts.add(18);
        binInts.add(36);
        binInts.add(66);
        binInts.add(69);
        binInts.add(80);
        binInts.add(110);
        binInts.add(130);


        System.out.println(binInts);
        binInts.getNextLarger(18);

        for (int i = 0; i < 131; i++) {
            System.out.println("Next biggest from " + i + " is: " + binInts.getNextLarger(i));
        }



    }
}
