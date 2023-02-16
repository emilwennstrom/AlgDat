import java.util.Arrays;
import java.util.Random;

public class NB29c {

    public static void main(String[] args) {
        int[] array = new int[20];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int add = Math.abs(rand.nextInt() % 300);
            array[i] = add;
        }

        System.out.println("Unsorted:   " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Quick sort: " + Arrays.toString(array));

    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    private static void quickSort(int[] array, int first, int last) {
        if (first < last) {
            int pivot = partition(array, first, last);
            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
    }
    /*
        Quicksort tar först det första elementet i arrayen som måttstock (pivot)
        Sedan letar den vänster -> höger tills den hittar ett element som är > pivot
        Sedan letar den höger -> vänster tills den hittar ett element som är <= pivot.
        Om dessa två element hittas byter de plats med varandra.

        När algoritmen inte hittar fler element som uppfyller kraven flyttar den pivot
        till sin sorterade plats och returnerar denna.

        Anropas sedan rekursivt med pivot - 1 och pivot + 1 till arrayen är sorterad.
     */

    private static int partition(int[] array, int first, int last) {
        int pivot = array[first];
        int up = first;
        int down = last;
        while (up < down) {
            while (array[up] <= pivot && up != last) up++;
            while (array[down] > pivot && down != first) down--;
            if (up < down) swap(array, up, down);
        }
        swap(array, first, down);
        return down;
    }

    private static void swap(int[] array, int s1, int s2){
        int tmp = array[s1];
        array[s1] = array[s2];
        array[s2] = tmp;
    }

}




