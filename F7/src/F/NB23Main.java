package F;

public class NB23Main {

    public static void main(String[] args) {
        BinarySearchTree<Character> binStrings = new BinarySearchTree<>();

        binStrings.add('H');
        binStrings.add('B');
        binStrings.add('N');
        binStrings.add('A');
        binStrings.add('E');
        binStrings.add('C');
        binStrings.add('F');
        binStrings.add('D');

        System.out.println(binStrings.numberOfLeaves());
        System.out.println(binStrings.numberOfNodes());
        System.out.println(binStrings.height());
        System.out.println(binStrings);

        BinarySearchTree<Integer> binInts = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            binInts.add(i);
        }

        System.out.println(binInts.numberOfNodes());
        System.out.println(binInts.numberOfLeaves());
        System.out.println(binInts.height());



    }

}
