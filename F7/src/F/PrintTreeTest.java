package F;

public class PrintTreeTest {

    public static void main(String[] args) {
        BinarySearchTree<Character> binStrings = new BinarySearchTree<>();
        // Koden för trädet rad 279 i klassen
        binStrings.add('H');
        binStrings.add('B');
        binStrings.add('N');
        binStrings.add('A');
        binStrings.add('E');
        binStrings.add('C');
        binStrings.add('F');
        binStrings.add('D');

        System.out.println(binStrings.printTree());

    }


}
