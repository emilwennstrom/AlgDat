package F;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <E extends Comparable<E>> {


    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        public String toString(){
            return data.toString();
        }

    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTree() {
        root = null;
        deletedData = null;
    }

    public boolean add (E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) return false;
        else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
            } else {
                return add(data, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(data);
            } else {
                return add(data, node.right);
            }
        }
        return true;
    }

    public E maxRec() {
        if (root == null) return null;
        return maxRec(root);
    }

    private E maxRec(Node<E> node) {
        if (node.right == null) return node.data;
        return maxRec(node.right);
    }

    public E maxIt() {
        if (root == null) return null;
        Node<E> node = root;
        while(node.right != null) {
            node = node.right;
        }
        return node.data;
    }




    public E findIt(E target) {
        if (root == null) return null;
        State<E> state = new State<>(root);
        Queue<State<E>> queue = new LinkedList<>();
        while (state.node.data != target) {
            if(target.compareTo(state.node.data) < 0 && state.node.left != null) {
                queue.offer(new State<>(state.node.left));
            }
            else if(target.compareTo(state.node.data) > 0 && state.node.right != null) {
                queue.offer(new State<>(state.node.right));
            }
            state = queue.poll();
            if (state == null) return null;
        }
        return state.node.data;
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (target.compareTo(node.data) == 0) {
            return node.data;
        } else if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        } else {
            return find(target, node.right);
        }
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    public int numberOfLeaves() {
        Node<E> node = root;
        return numberOfLeaves(node);
    }

    private int numberOfLeaves(Node<E> node) {
        if (node == null) return 0;
        int noOfLeaves = 0;
        if (node.left == null && node.right == null)
            return 1;
        if (node.left != null)
            noOfLeaves += numberOfLeaves(node.left);
        if (node.right != null)
            noOfLeaves += numberOfLeaves(node.right);
        return noOfLeaves;
    }


    public int numberOfNodes() {
        Node<E> node = root;
        return numberOfNodes(node);
    }

    private int numberOfNodes(Node<E> node) {
        if (node == null)
            return 0;
        int noOfNodes = 0;
        if (node.right == null && node.left == null)
            return 1;
        if (node.left != null)
            noOfNodes += numberOfNodes(node.left);
        if (node.right != null)
            noOfNodes += numberOfNodes(node.right);
        return noOfNodes + 1;
    }

    public int height() {
        Node<E> node = root;
        if (root == null) return -1;
        return height(node, 0);
    }

    private int height(Node<E> node, int height) {
        if (node.right == null && node.left == null) {
            return height;
        }
        int left = 0, right = 0;
        if (node.left != null) {
            left = height(node.left, height + 1);
        }
        if (node.right != null) {
            right = height(node.right, height + 1);
        }

        return Math.max(left,right);


    }


    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        }
        if (target.compareTo(node.data) < 0) {
            node.left = delete(target, node.left);
            return node;
        } else if (target.compareTo(node.data) > 0) {
            node.right = delete(target, node.right);
            return node;
        } else {
            deletedData = node.data;
            if (node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            else {
                Node<E> nodeToMove = node.right;
                Node<E> parentNodeToMove = node;
                if (nodeToMove.left == null) {
                    nodeToMove.left = node.left;
                    return nodeToMove;
                }
                while (nodeToMove.left != null) {
                    parentNodeToMove = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }
                parentNodeToMove.left = nodeToMove.right;
                node.data = nodeToMove.data;
                return node;
            }
        }
    }



    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            if (node != root)
                sb.append(node.toString()).append(":");
            postOrder(node.right, sb);
        }
        if (node == root && node != null) {
            sb.append(node.toString()).append(":");
        }
    }

    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.toString()).append(":");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }

    }



    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.toString()).append(":");
            inOrder(node.right, sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post Order: ");
        postOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        sb.append("In Order: ");
        inOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        sb.append("Pre Order: ");
        preOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static class State<E> {
        int depth;
        Node<E> node;
        private State(int depth, Node<E> node) {
            this.depth = depth;
            this.node = node;
        }

        private State(Node<E> node) {
            this.node = node;
            this.depth = -1;
        }

    }

    public String printTree() {
        if (root == null) return null;
        int newLine = 1;
        StringBuilder sb = new StringBuilder();
        Queue<State<E>> stateQueue = new LinkedList<>();
        State<E> state = new State<>(0, root);
        while (state != null) {
            if (state.node.data != null) {
                if (state.node.left != null) {
                    stateQueue.offer(new State<>(state.depth + 1, state.node.left));
                } else {
                    stateQueue.offer(new State<>(state.depth + 1, new Node<>(null)));
                }
                if (state.node.right != null) {
                    stateQueue.offer(new State<>(state.depth + 1, state.node.right));
                } else {
                    stateQueue.offer(new State<>(state.depth +1, new Node<>(null)));
                }
            }
            if (state.depth == newLine) {
                sb.append("\n");
                newLine++;
            }
            sb.append(state.node.data).append(" ");
            state = stateQueue.poll();
        }
        return sb.toString();
    }




}
