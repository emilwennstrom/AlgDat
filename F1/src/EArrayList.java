import java.util.Arrays;

public class EArrayList <E>{

    private E[] myEArray;
    private int noOfElements;
    private int maxSize;

    public EArrayList() {
        maxSize = 10;
        noOfElements = 0;
        myEArray = (E[]) new Object[maxSize];
    }

    public int length() {
        return myEArray.length;
    }

    public int size() {
        return noOfElements;
    }

    public boolean add(E element) {
       if (noOfElements == maxSize) {
           reAllocate();
       }
       myEArray[noOfElements++] = element;
       return true;
    }

    public E get(int index){
        if (index < 0 || index >= noOfElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return myEArray[index];
    }

    public void add(int index, E entry) {
        if (index < 0 || index > noOfElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (noOfElements == maxSize) {
            reAllocate();
        }
        for (int i = noOfElements; i > index; i--) {
            myEArray[i] = myEArray[i-1];
        }
        myEArray[index] = entry;
        noOfElements++;
    }


    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < noOfElements; i++) {
            temp.append("[");
            temp.append(myEArray[i].toString());
            temp.append("] ");
        }
        return temp.toString();
    }

    public E remove (int index) {
        if (index < 0 || index >= noOfElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnVal = myEArray[index];

        for (int i = index + 1; i < noOfElements; i++){
            myEArray[i-1] = myEArray[i];
        }
        noOfElements--;
        return returnVal;
    }

    public int indexOf(E element) {
        for (int i = 0; i < noOfElements; i++) {
            if (element.equals(myEArray[i]))
                return i;
        }
        return -1;
    }

    public E set(int index, E element) {
        if (index < 0 || index > maxSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E old = myEArray[index];
        myEArray[index] = element;
        return old;
    }


    private void reAllocate() {
        E[] temp = myEArray;
        maxSize = maxSize * 2;
        myEArray = (E[]) new Object[maxSize];
        for (int i = 0; i < temp.length; i++) {
            myEArray[i] = temp[i];
        }

        //myEArray = Arrays.copyOf(myEArray, maxSize);

    }


}
