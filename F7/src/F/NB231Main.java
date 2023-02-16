package F;

public class NB231Main {

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

        System.out.println(binStrings.findIt('A'));

        System.out.println(binStrings.findIt('Q'));
        System.out.println(binStrings.findIt('D'));

        System.out.println(binStrings.maxRec());
        System.out.println(binStrings.maxIt());

        binStrings.delete('N');

        System.out.println(binStrings.maxRec());
        System.out.println(binStrings.maxIt());

        BinarySearchTree<Integer> binInts = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            binInts.add(i);
        }

        System.out.println(binInts.maxIt());
        System.out.println(binInts.maxRec());

        System.out.println(binInts.findIt(5));
        System.out.println(binInts.findIt(-1));
        System.out.println(binInts.findIt(9));






    }


}
