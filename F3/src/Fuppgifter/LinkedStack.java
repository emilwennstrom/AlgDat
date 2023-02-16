package Fuppgifter;
import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E>{



    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E item, Node<E> nodeRef) {
            data = item;
            next = nodeRef;
        }

    }
    private Node<E> top;

    public LinkedStack(){
        top = null;
    }

    public int size(){
        if (top == null) {
            return 0;
        }
        int count = 1;
        Node<E> tmp = top;
        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public E peek(int n){
       if (empty()){
           throw new EmptyStackException();
       }
       Node<E> tmp = top;
       for (int i = 0; i < n; i++) {
           if (tmp.next == null) {
               throw new IndexOutOfBoundsException(n);
           }
           tmp = tmp.next;
       }
       return tmp.data;
    }

    public E flush(){
        if (empty()) {
            throw new EmptyStackException();
        }
        while (top.next != null) {
            top = top.next;
        }
        Node<E> tmp = top;
        top = null;
        return tmp.data;
    }


    @Override
    public E push(E obj) {
        top = new Node<>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        return top.data;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E temp = top.data;
        top = top.next;
        return temp;
    }

    @Override
    public boolean empty() {
        return top == null;
    }



}
