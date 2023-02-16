package Uppg4;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private int front, rear, size, maxSize;
    private E[] data;
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initCapacity) {
        size = 0;
        front = 0;
        maxSize = initCapacity;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer (E element) {
        if (size == maxSize) {
            reallocate(maxSize * 2);
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E poll(){
        if (size == 0) return null;

        size--;
        E element = data[front];
        front = (front + 1) % maxSize;
        if (size <= maxSize / 4 && size >= 5){
            reallocate(maxSize / 2);
        }
        return element;
    }

    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    @SuppressWarnings("unchecked")
    private void reallocate(int newMax) {
        E[] newData = (E[]) new Object[newMax];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMax;
        data = newData;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public String sizes() {
        return "Max size: " + maxSize + "\n" + "Current size: " + size +
                " Front: " + front + " Rear: " + rear;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        private int index;
        private int count = 0;
        public Iter() {
            index = front;
        }
        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }
    }
}
