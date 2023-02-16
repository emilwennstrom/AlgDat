package NB29d;

import java.util.Arrays;

public class MaxHeap<E extends Comparable<E>> {

    private int size;
    private E[] data;
    private int nextPos;


    @SuppressWarnings("unchecked")
    public MaxHeap(int size) {
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }


    public boolean insert(E data) {
        if (nextPos == size) {
            reAllocate();
        }
        nextPos++;
        return insert(data, nextPos - 1);
    }

    private boolean insert(E data, int nextPos) {
        this.data[nextPos] = data;
        int parent = (nextPos - 1) / 2;
        if (nextPos != 0 && this.data[nextPos].compareTo(this.data[parent]) > 0) {
            swap(nextPos, parent);
            return insert(data, parent);
        }
        return true;
    }

    private void swap(int nextPos, int parent) {
        E tmp = this.data[nextPos];
        this.data[nextPos] = this.data[parent];
        this.data[parent] = tmp;
    }

   public E extract() {
        if (data[0] == null) return null;
        E returnValue = data[0];
        data[0] = data[nextPos - 1];
        data[nextPos - 1] = null;
        extract(0);
        nextPos--;
        return returnValue;
    }

    private void extract(int p) {
        int leftChild = (2 * p) + 1;
        int rightChild = (2 * p) + 2;
        if (rightChild >= data.length) return;
        if (data[leftChild] != null || data[rightChild] != null) {
            if (data[rightChild] == null) {
                if (data[leftChild].compareTo(data[p]) > 0)
                    swap(leftChild, p);
            } else if (data[leftChild].compareTo(data[rightChild]) > 0) {
                if (data[leftChild].compareTo(data[p]) > 0) {
                    swap(leftChild, p);
                    extract(leftChild);
                }
            } else {
                if (data[rightChild].compareTo(data[p]) > 0) {
                    swap(rightChild, p);
                    extract(rightChild);
                }
            }
        }
    }

    private void reAllocate() {
        size *= 2;
        data = Arrays.copyOf(data, size);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ");
        for (E element : data) {
            if (element != null) {
                sb.append(element).append(" ");
            }
        }
        sb.append("\n");
        sb.append("Nextpos: ").append(nextPos);
        return sb.toString();
    }
}
