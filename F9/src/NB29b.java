import java.util.Arrays;

public class NB29b {

    public static void main(String[] args) {
        int[] a = {3, 7, 2, 8, 6, 9, 10, 1};
        System.out.println("Unsorted:   " + Arrays.toString(a));
        shellSort(a);
        System.out.println("Shell sort: " + Arrays.toString(a));

    }

    /*
        Shell sort går ut på att dela upp arrayen i length / 2 subarrayer
        där dessa i sin tur sorteras med selection sort. När detta är gjort delas
        length på 2 (2.2) igen och algoritmen körs igen.
        När length / 2.2 blir 1 körs selection sort en sista gång
     */

    public static void shellSort(int[] array) {
        int gap = array.length >> 1;
        while (gap > 0) {
            for (int index = gap; index < array.length; index++) {
                int data = array[index];
                int dataIndex = index;
                while (dataIndex > gap - 1 && data < array[dataIndex - gap]) {
                    array[dataIndex] = array[dataIndex - gap];
                    dataIndex -= gap;
                }
                array[dataIndex] = data;
            }
            if (gap == 2) gap = 1;
            else gap = (int) (gap / 2.2);
        }
    }


}
