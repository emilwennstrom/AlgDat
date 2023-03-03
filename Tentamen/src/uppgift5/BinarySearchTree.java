package uppgift5;

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

    @Override
    public String toString(){
        if (root == null) return "";
        String s = "";
        return toString(s, root);
    }

    private String toString(String s, Node<E> node){
        if (node.left != null) {
           s = toString(s, node.left);
        }
        s += node.data.toString() + " ";
        if (node.right != null) {
            s = toString(s, node.right);
        }
        return s;
    }

    public boolean isBalanced() {
        if (root == null) return true;
        int leftH = isBalanced(root.left, 0);
        int rightH = isBalanced(root.right, 0);
        if (leftH == -1 || rightH == -1) return false;
        return Math.abs(leftH - rightH) <= 1;
    }
    private int isBalanced(Node<E> node, int height) {
        if (node.left == null && node.right == null) return height;
        int left = 0, right = 0;
        if (node.left != null) {
            left =  isBalanced(node.left, height + 1);
        }
        if (node.right != null) {
            right = isBalanced(node.right, height + 1);
        }
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right);
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }
    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }else{
            return add(data,root);
        }
    }

}
