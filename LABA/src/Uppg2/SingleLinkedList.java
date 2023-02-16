package Uppg2;

import java.util.Iterator;
import java.util.NoSuchElementException;
 public class SingleLinkedList<E> implements Iterable<E>{

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        private Node(E data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList(){
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(Integer.toString(index));
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        }
        else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public E getLast() {
        if (tail != null)
            return tail.data;
        return null;
    }

    public E getFirst() {
        if (head != null)
            return head.data;
        return null;
    }

    private void addLast(E item) {
        Node<E> temp = tail;
        tail = new Node<>(item);
        temp.next = tail;
        size++;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> node = getNode(index - 1); // Hämtar noden innan den som tas bort
            E returnValue = removeAfter(node); // tar bort noden efter denna
            if (index == size) {  // om index == nya size uppdateras node till tail
                tail = node;
            }
            return returnValue;
        }
    }

    private E removeAfter(Node<E> node) {
        Node<E> returnValue = node.next;    // Node to remove
        node.next = returnValue.next;
        size--;
        if (size == 0) tail = null;
        return returnValue.data;
    }

    private E removeFirst() {
        Node<E> returnValue = head;
        head = head.next;
        size--;
        if (size == 0) tail = null;
        return returnValue.data;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
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

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    /**
     * Head är null innan första objektet läggs till
     * När en ny nod skapas skickas referensen till head med som nästa (null för första item)
     * Om första noden finns och en annan ska läggas först i listan, sätts gamla head som next
     * i den nya noden som skapas, och head uppdateras till den nya noden.
     */
    private void addFirst(E item) {
        head = new Node<E>(item, head);
        if (size == 0)
            tail = head;
        size++;
    }

    /**
     * Noden som skickas med är noden på platsen innan.
     * node.next inom parenteserna är null om noden ska läggas sist i listan
     * annars är node.next inom parentesera noden efter den som ska läggas till
     * node.next som sätts är nästa för noden innan och pekar på noden som skapas
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }


    //Returnerar null om noden saknas
    private Node<E> getNode(int index) {
        if (index == size - 1) {
            return tail;
        } else {
            Node<E> node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }
            return node;
        }
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
