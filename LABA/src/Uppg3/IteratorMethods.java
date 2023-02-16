package Uppg3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorMethods<E> implements Iterable<E>{

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

    public IteratorMethods(){
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
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

    private class Itr implements Iterator<E> {
        Node<E> current;
        Node<E> remove;
        Node<E> beforeRemove;

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
            if (remove == null || !checkNext) { // remove är null om next aldrig blivit anropad
                throw new IllegalStateException();
            }
            if (remove == head) { // Om det som ska tas bort ligger först i listan
                head = current;
            } else {
                remove = beforeRemove;  // Platsen innan det som tas bort tar den plats som tas bort
                remove.next = current; // flyttar pekaren till current
            }
            checkNext = false;
            size--;
        }
    }

}
