package NB29d;


public class HeapSort {

    public static void sort(int[] array) {
        double before = System.currentTimeMillis();
        int lastElement = array.length - 1;
        int heapSize = 1;
        while (heapSize < array.length) {
            offer(array, array[heapSize++], heapSize);
        }
        while (heapSize > 0) {
            array[--heapSize] = poll(array, lastElement--);
        }
        double after = System.currentTimeMillis();
        System.out.println("Time in ms: " + (after - before));
    }


    private static void offer(int[] array, int offer, int heapSize) {
        int child = heapSize - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && array[parent] < offer) {
            int tmp = array[parent];
            array[parent] = offer;
            array[child] = tmp;
            child = parent;
            parent = (child - 1) / 2;
        }

    }

    private static int poll(int[] array, int lastElement){
        int parent = 0;
        int leftChild = 1;
        int rightChild = 2;
        int returnValue = array[parent];
        array[parent] = array[lastElement];
        while (leftChild <= lastElement - 1) {
            if (array[leftChild] > array[rightChild]) {
                if (array[leftChild] > array[parent])
                    pollSwap(array, parent, leftChild);
                parent = leftChild;
            } else {
                if (array[rightChild] > array[parent])
                    pollSwap(array, parent, rightChild);
                parent = rightChild;
            }
            leftChild = 2 * parent + 1;
            rightChild = leftChild + 1;
        }
        return returnValue;
    }



    private static void pollSwap(int[] array, int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

}
