package NB10;

public class Dequeue<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;


        private Node(E item, Node<E> next, Node<E> previous) {
            data = item;
            this.next = next;
            this.previous = previous;
        }
        private Node(E item){
            this(item, null, null);
        }

    }


    private Node<E> front, rear;
    private int size;

    public Dequeue(){
        size = 0;
        front = null;
        rear = null;
    }

    public E pollFirst() {
        if (front == null) {
            return null;
        }
        E data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public E pollLast() {
        if (rear == null) {
            return null;
        }
        E data = rear.data;
        rear = rear.previous;
        size--;
        return data;
    }

    public boolean offerFirst(E item) {
        if (front == null) {
            front = new Node<>(item);
        }
        if (rear == null) {
            rear = front;
        }
        else {
            front = new Node<>(item, front, null);
            front.next.previous = front;
        }
        size++;
        return true;
    }

    public boolean offerLast(E item) {
        if (rear == null) {
            rear = new Node<>(item);
        }
        if (front == null) {
            front = rear;
        } else {
            rear = new Node<>(item, null, rear);
            rear.previous.next = rear;
        }
        size++;
        return true;
    }

    public boolean empty() {
        return size == 0;
    }


}
