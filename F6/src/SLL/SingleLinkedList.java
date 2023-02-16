package SLL;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;


        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private int size;

    public SingleLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(Integer.toString(index)); // varför inte bara index
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E getRec(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNodeRec(index);
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append("==>");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private void toStringRec(StringBuilder sb, Node<E> node) {
        sb.append(node.data.toString());
        if (node.next != null) {
            sb.append("==>");
            toStringRec(sb, node.next);
        }
    }

    public String toStringRec() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recursive call: [");
        if (head != null) {
            toStringRec(sb, head);
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    //Returnerar null om noden saknas
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public int size(){
        Node<E> node = head;
        return sizeRec(node);
    }

    private int sizeRec(Node<E> node){
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.next);
    }

    private Node<E> getNodeRec(int index) {
        Node<E> node = head;
        return getNodeRec(node, index, 0);
    }

    private Node<E> getNodeRec(Node<E> node, int index, int recursions) {
        if (index == recursions) {
            return node;
        }
        return getNodeRec(node.next, index, recursions + 1);
    }

    private class Itr implements Iterator<E> {
        Node<E> current;

        public Itr(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
