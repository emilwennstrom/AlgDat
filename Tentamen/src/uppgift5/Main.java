package uppgift5;

public class Main {

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println("Tree:" + bst +" balanced: " + bst.isBalanced());
        buildTree(bst,new int[] {30,20,40,15,21,35,45,34,37});
        System.out.println(bst);
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced());
    }

}
