import java.util.Arrays;
import java.util.LinkedList;

public class IntList {

    private int[] intData;
    private int size; // index på nästa element

    public IntList(int initialCapacity) {
        intData = new int[initialCapacity];
        size = 0;
    }

    public void add(int element) {
        if (size == intData.length) {
            reallocate();
        }
        intData[size++] = element;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size == intData.length) {
           reallocate();
        }
        for (int i = size; i > index; i--) {
            intData[i] = intData[i - 1];
        }
        intData[index] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return intData[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (element == intData[i])
                return i;
        }
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int removedValue = intData[index];
        for (int i = index + 1; i < size; i++) {
            intData[i - 1] = intData[i];
        }
        size--;
        return removedValue;
    }

    public int set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int oldValue = intData[index];
        intData[index] = element;
        return oldValue;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for(int i = 0; i < size; i++) {
            s.append(intData[i]).append(":").
                    append("[").append(i).append("] ");
            if ((i + 1) % 20 == 0) {
                s.append(" ]\n");
                if (i + 1 != intData.length) {
                    s.append("[ ");
                }
            }
        }
        s.append(" ]\n");
        return s.toString();
    }

    private void reallocate() {
        intData = Arrays.copyOf(intData, intData.length * 2);
    }

}
