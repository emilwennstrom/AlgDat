package uppgift3;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree(){
        root=null;
    }

    private String toString(Node<E> node){
        if(node!=null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    @Override
    public String toString(){
        return toString(root);
    }

    public boolean add(E data){
        if (root == null) {
            root = new Node<>(data);
            return true;
        }
        return add(data, root);
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            }
            return add(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
                return true;
            }
            return add(data, node.right);
        }
        return false;
    }

    public int size(){
        return size(root);
    }

    private int size(Node<E> node) {
        if (node.left == null && node.right == null)
            return 1;
        int size = 0;
        if (node.left != null)
            size += size(node.left);
        if (node.right != null)
            size += size(node.right);
        return size + 1;
    }

}

