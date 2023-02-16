package NB9;

public class LinkedQueue<E> {

    private static class Node<E> {

        private Node(E item){
            data = item;
            this.next = null;
        }
        private E data;
        private Node<E> next;
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean enqueue(E item){
        Node<E> node = new Node<>(item);
        if (size == 0) {
            front = node;
        }
        else {
            rear.next = node;
        }
        rear = node;
        size++;
        return true;
    }

    public E dequeue() {
        E item = peek();
        if (item == null) {
            return null;
        }
        front = front.next;
        size--;
        return item;
    }

    public E peek(){
        if (size == 0) {
            return null;
        }
        else return front.data;
    }

    public int size() {
        return size;
    }




}
