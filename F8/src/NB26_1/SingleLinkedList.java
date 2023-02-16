package NB26_1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node (E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public SingleLinkedList() {
        this.head = null;
    }

    public boolean add(int index, E item) {
        if (index == 0) addFirst(item);
        else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
        return true;
    }

    public boolean add(E item) {
        if (head == null) addFirst(item);
        else {
            Node<E> node = getLastNode();
            addAfter(node, item);
        }
        return true;
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
    }

    private Node<E> getLastNode() {
        return getLastNode(head);
    }

    private Node<E> getLastNode(Node<E> node) {
        if (node.next == null) {
            return node;
        }
        return getLastNode(node.next);
    }

    public E remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException(index);
        if (index == 0) return removeFirst();
        else {
            Node<E> node = getNode(index - 1);
            return removeAfter(node);
        }
    }

    private E removeAfter(Node<E> node) {
        Node<E> returnValue = node.next;
        node.next = returnValue.next;
        return returnValue.data;
    }

    private Node<E> getNode(int index) {
        return getNode(index, head, 0);
    }

    private Node<E> getNode(int index, Node<E> node, int goal) {
        if (node == null) throw new IndexOutOfBoundsException(index);
        if (index == goal)
            return node;
        return getNode(index, node.next, goal + 1);
    }


    public E get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException(index);
        Node<E> node = getNode(index);
        return node.data;
    }



    private E removeFirst(){
        if (head == null) return null;
        Node<E> returnValue = head;
        head = head.next;
        return returnValue.data;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                if (p.data == null) {
                    sb.append("'null'");
                } else {
                    sb.append(p.data.toString());
                }
                sb.append("==>");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }


    private class Itr implements Iterator<E> {

        Node<E> current, remove, beforeRemove;
        boolean checkNext;

        public Itr(Node<E> start) {
            current = start;
            checkNext = true;
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
            beforeRemove = remove;
            remove = current;
            current = current.next;
            checkNext = true;
            return returnValue;
        }

        @Override
        public void remove() {
            if (remove == null || !checkNext) {
                throw new IllegalStateException();
            }
            if (remove == head) {
                head = current;
            } else {
                remove = beforeRemove;
                remove.next = current;
            }
            checkNext = false;
        }







    }










}
