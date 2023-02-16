import java.util.Arrays;
import java.util.Random;

public class NB28 {

    public static void main(String[] args) {

        int[] randArr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < randArr.length; i++) {
            int add = Math.abs(rand.nextInt() % 300);
            randArr[i] = add;
        }

        System.out.println("Unsorted:       " + Arrays.toString(randArr));
        int[] insSort = Arrays.copyOf(randArr, randArr.length);
        selectionSort(randArr);
        insertionSort(insSort);
        System.out.println("Selection sort: " + Arrays.toString(randArr));
        System.out.println("Insertion sort: " + Arrays.toString(insSort));


    }

    /*
        Selection sort sätter till en böjran första index som minsta värdet.
        Går genom arrayen för att hitta minsta värdet, när detta har hittats
        byter nya minsta plats med plats 0.

        Nu sätts andra index som minsta värdet och proceduren fortsätter ända till vi har
        kommit till platsen innan sista.
     */

    public static void selectionSort(int[] array){
        for (int index = 0; index < array.length - 1; index++) {
            int minIndex = index;
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    /*
        Insertion Sort sorterar arrayen genom att börja med en "sorterad array"
        som är 1 stor. Först sparas index 1 undan, sedan tittar den platsen innan om den är större. Om den är större
        skrivs plats 1 över med plats 0, och plats 1 flyttas till plats 0.

        Nästa varv sparas index 2 undan, sedan tittar den vänster för att se om platsen innan
        är större om den är det skrivs plats 2 över med 1, om plats 0 är större skrivs plats 1 över med 0
        sedan skrivs plats 2 in på plats 0.. osv.
     */

    public static void insertionSort(int[] array) {
        for (int index = 1; index < array.length; index++){
            int data = array[index];
            int dataIndex = index;
            while (dataIndex > 0 && data < array[dataIndex - 1]) {
                array[dataIndex] = array[dataIndex - 1];
                dataIndex--;
            }
            array[dataIndex] = data;
        }
    }
}
