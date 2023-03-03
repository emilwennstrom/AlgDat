package uppgift3;

public class Main {

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,35,45,37});
        System.out.println("Tree:" + bst + " Size: " + bst.size());

    }
}
